package com.my.fruit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {
    @GET("fruit/all")
    Call<List<Fruit>> getAllFruits();

    @GET("fruit/all")
    Call<List<Fruit>> getFruits();
}