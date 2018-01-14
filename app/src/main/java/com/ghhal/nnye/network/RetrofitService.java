package com.ghhal.nnye.network;

import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static volatile RetrofitService instance;
    private Gson myGson;
    private IRetrofitApi retrofitApi;

    public synchronized static IRetrofitApi getRetrofitApi() {
        if (instance == null) {
            instance = new RetrofitService(new Gson());
        }
        return instance.retrofitApi;
    }

    private RetrofitService(Gson gson) {
        this.myGson = gson;
        createRetrofit();
    }

    private void createRetrofit() {
        HttpLoggingInterceptor interceptorLogging = new HttpLoggingInterceptor(message -> {

        });
        interceptorLogging.setLevel(Level.BODY);
        this.retrofitApi = new Builder().baseUrl("http://freegeoip.net/")
                .client(new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                        .readTimeout(30, TimeUnit.SECONDS).addInterceptor(interceptorLogging).build())
                .addConverterFactory(buildGsonConverter()).build().create(IRetrofitApi.class);
    }

    private GsonConverterFactory buildGsonConverter() {
        return GsonConverterFactory.create(this.myGson);
    }
}
