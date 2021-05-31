package com.test.paymentoptions.repositories.data;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.test.paymentoptions.models.ListResult;
import com.test.paymentoptions.repositories.network.ApiInterface;
import com.test.paymentoptions.repositories.network.ApiManager;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DataRepository {

    private static DataRepository instance;
    private ListResult dataSet = new ListResult();
    private static Context context;

    private ApiInterface api;

    public static DataRepository getInstance(Context applicationContext){
        context = applicationContext;
        if(instance == null){
            instance = new DataRepository();
        }
        return instance;
    }

    ApiResponse temp = new ApiResponse();

    public  DataRepository(){
        api = ApiManager.getApiInterface();
    }

    public MutableLiveData<ApiResponse> getListResults() {
        final MutableLiveData<ApiResponse> data = new MutableLiveData<>();
        try {

            api.getData()
                    .enqueue(new Callback<ListResult>() {

                                 @Override
                                 public void onResponse(Call<ListResult> call, Response<ListResult> response) {
                                     try {
                                         if (response.isSuccessful()) {
                                             dataSet = response.body();
                                             temp.setResponseCode(response.code());
                                             temp.setListResult(dataSet);
                                         }else{
                                             temp.setResponseCode(response.code());
                                             temp.setListResult(dataSet);
                                         }
                                         data.postValue(temp);
                                     } catch (Exception e) {
                                         e.printStackTrace();
                                         temp.setResponseCode(0);
                                         temp.setListResult(dataSet);
                                         data.postValue(temp);
                                     }
                                 }

                                 @Override
                                 public void onFailure(Call<ListResult> call, Throwable t) {
                                     t.printStackTrace();
                                     temp.setResponseCode(0);
                                     temp.setListResult(dataSet);
                                     data.postValue(temp);
                                 }
                             }
                    );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

}