package com.test.paymentoptions;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;

import com.test.paymentoptions.adapter.PaymentListAdapter;
import com.test.paymentoptions.models.ApplicableNetwork;
import com.test.paymentoptions.models.ListResult;
import com.test.paymentoptions.repositories.data.ApiResponse;
import com.test.paymentoptions.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private MainActivityViewModel mMainActivityViewModel;


    ArrayList<ApplicableNetwork> masterList = new ArrayList<>();


    private ProgressDialog dialog;

    RecyclerView rv_payment;
    PaymentListAdapter paymentListAdapter;

    boolean isScrolling = false;

    int currentItem,totalItems,scrollItems, pageNumber = 1;
    private SearchView searchView;

    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        setupRecyclerView();

        fetchData();
    }


    private void init() {
        rv_payment = findViewById(R.id.rv_payment);

        dialog = new ProgressDialog(MainActivity.this);

        pb = findViewById(R.id.pb);
    }


    private void setupRecyclerView() {
        if (paymentListAdapter == null) {
            paymentListAdapter = new PaymentListAdapter(MainActivity.this, masterList);
            rv_payment.setLayoutManager(new LinearLayoutManager(this));
            rv_payment.setAdapter(paymentListAdapter);
            rv_payment.setItemAnimator(new DefaultItemAnimator());
            rv_payment.setNestedScrollingEnabled(true);
        } else {
            paymentListAdapter.notifyDataSetChanged();
        }
    }

    private void fetchData() {

        pb.setVisibility(View.GONE);

        dialog.setMessage("Fetching Payments Options");
        dialog.show();

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init(getApplicationContext());
        mMainActivityViewModel.getMasterData().observe(MainActivity.this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(@Nullable ApiResponse data) {
                dialog.dismiss();
                if (data!=null)
                    if (data.getResponseCode() == 200){
                        masterList.addAll(data.getListResult().getNetworks().getApplicable());
                        paymentListAdapter.notifyDataSetChanged();
                    }else{
                        MessageHandler msgHandler = new MessageHandler(MainActivity.this);
                        Message conMsg = new Message();
                        conMsg.what = data.getResponseCode();
                        msgHandler.handleMessage(conMsg);
                    }


            }
        });
    }


}