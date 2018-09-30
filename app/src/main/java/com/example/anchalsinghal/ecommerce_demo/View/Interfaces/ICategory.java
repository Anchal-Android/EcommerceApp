package com.example.anchalsinghal.ecommerce_demo.View.Interfaces;


import com.google.gson.JsonObject;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ICategory {

    @GET("json")
    Call<JsonObject> getAssesmentList();
}
