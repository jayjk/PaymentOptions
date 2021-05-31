package com.test.paymentoptions.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.test.paymentoptions.R;
import com.test.paymentoptions.models.ApplicableNetwork;

import java.util.ArrayList;


public class PaymentListAdapter extends RecyclerView.Adapter<PaymentListAdapter.CandidateViewHolder> {

    Context context;
    ArrayList<ApplicableNetwork> paymentData;

    public PaymentListAdapter(Context context, ArrayList<ApplicableNetwork> articles) {
        this.context = context;
        this.paymentData = articles;
    }

    @NonNull
    @Override
    public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_payment, parent, false);
        return new  CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateViewHolder holder, final int position) {
        holder.tv_title.setText(paymentData.get(position).getLabel());

        RequestOptions rq = new RequestOptions().placeholder(android.R.drawable.stat_sys_download);

        if (paymentData.get(position).getLinks()!=null)
        {
            String url = paymentData.get(position).getLinks().get("logo").toString();

            Glide.with(context)
                    .load(url)
                    .apply(rq)
                    .into(holder.iv_img);
        }


        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"You have selected " + paymentData.get(position).getLabel(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return paymentData.size();
    }

    public class CandidateViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        ImageView iv_img;
        View view;

        public CandidateViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = itemView.findViewById(R.id.tv_title);
            iv_img = itemView.findViewById(R.id.iv_img);

            view = itemView;

        }
    }


}
