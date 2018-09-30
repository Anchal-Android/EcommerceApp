package com.example.anchalsinghal.ecommerce_demo.Model;


import android.app.ProgressDialog;
import android.content.Context;

import android.support.annotation.NonNull;

import android.widget.Toast;

import com.example.anchalsinghal.ecommerce_demo.Presenter.IPresenter;
import com.example.anchalsinghal.ecommerce_demo.View.Interfaces.ICategory;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {

    private Context context;
    private com.example.anchalsinghal.ecommerce_demo.data.Response assesmentList;
   private IPresenter listener;

    public NetworkManager(Context context) {

        this.context = context;
    }

    public void networkApi(IPresenter listener) {
        this.listener = listener;

        sendAndRequestResponse();
    }


    private void sendAndRequestResponse() {

        Retrofit retroFit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory
                .create()).baseUrl(RetroApi.url).build();
        ICategory api = retroFit.create(ICategory.class);
        Call<JsonObject> call = api.getAssesmentList();

        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(context);
        progressDoalog.setMessage("Its loading....");

        // show it
        progressDoalog.show();

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(@NonNull Call<JsonObject> call, @NonNull
                    Response<JsonObject> response) {

                try {
                        progressDoalog.dismiss();
                    assesmentList = new Gson().fromJson(response.body(), com.example.anchalsinghal.ecommerce_demo.data.Response.class);
                    listener.getAssessments(assesmentList);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
progressDoalog.dismiss();
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
