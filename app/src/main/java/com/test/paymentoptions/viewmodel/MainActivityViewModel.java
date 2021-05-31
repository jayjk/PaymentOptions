package com.test.paymentoptions.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.test.paymentoptions.models.ApplicableNetwork;
import com.test.paymentoptions.models.ListResult;
import com.test.paymentoptions.repositories.data.ApiResponse;
import com.test.paymentoptions.repositories.data.DataRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<ApiResponse> mMasterData;

    private DataRepository mRepo;

    public void init(Context applicationContext){
        if(mMasterData != null){
            return;
        }
        mRepo = DataRepository.getInstance(applicationContext);
        mMasterData = new MutableLiveData<>();
    }


    public LiveData<ApiResponse> getMasterData(){

        mMasterData = mRepo.getListResults();
        return mMasterData;
    }


}