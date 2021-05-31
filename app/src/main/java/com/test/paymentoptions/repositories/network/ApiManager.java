package com.test.paymentoptions.repositories.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiManager {
    //to handle Api calls

    private static ApiInterface apiInterface;

    private static void createApiInterface(){

        OkHttpClient client = new OkHttpClient.Builder()
                //to increase timeout as socket gets timedOut
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetworkURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static ApiInterface getApiInterface(){
        if(apiInterface == null)
            createApiInterface();

        return apiInterface;

    }
}

