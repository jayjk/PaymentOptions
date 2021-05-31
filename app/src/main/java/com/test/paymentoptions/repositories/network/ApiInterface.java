package com.test.paymentoptions.repositories.network;



import com.test.paymentoptions.models.ListResult;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {


    @GET("lists/listresult.json")
    Call<ListResult> getData();
}
