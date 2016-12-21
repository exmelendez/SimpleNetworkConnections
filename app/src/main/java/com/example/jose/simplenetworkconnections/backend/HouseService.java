package com.example.jose.simplenetworkconnections.backend;

import com.example.jose.simplenetworkconnections.model.HouseResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Joe on 12/20/16.
 */

public interface HouseService {
    @GET("class_12_20_2016.pl")
    Call<HouseResponse> getHouses();
}
