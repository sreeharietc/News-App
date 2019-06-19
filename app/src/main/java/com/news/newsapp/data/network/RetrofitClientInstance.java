package com.news.newsapp.data.network;

import com.news.newsapp.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.news.newsapp.data.network.NetworkConstants.BASE_URL;
import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

/**
 * Created by sreehari
 * on 18/6/19.
 *
 * Create singleton instance for retrofit.
 */
class RetrofitClientInstance {
    private static Retrofit retrofit;


    static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private static OkHttpClient getClient() {
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? BODY : NONE);
        Interceptor networkInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request().newBuilder().addHeader(NetworkConstants.API_KEY_PARAM, NetworkConstants.API_KEY_VALUE).build();
                return chain.proceed(request);
            }
        };
        return okHttpClientBuilder
                .readTimeout(3,
                        TimeUnit.MINUTES)
                .connectTimeout(3,
                        TimeUnit.MINUTES)
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(networkInterceptor)
                .build();
    }
}
