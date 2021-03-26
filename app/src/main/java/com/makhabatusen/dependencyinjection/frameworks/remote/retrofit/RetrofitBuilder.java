package com.makhabatusen.dependencyinjection.frameworks.remote.retrofit;

import com.makhabatusen.dependencyinjection.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  RetrofitBuilder {

    private static GhibliApi instance;

    private RetrofitBuilder() {}

    public static GhibliApi getInstance() {
        if (instance == null)
            instance = buildRetrofit();
        return instance;
    }

    private static GhibliApi buildRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GhibliApi.class);
    }
}
