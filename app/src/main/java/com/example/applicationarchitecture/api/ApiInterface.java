package com.example.applicationarchitecture.api;


import com.example.applicationarchitecture.model.HolidayModel;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface ApiInterface {

    @GET("PublicHolidays/2021/RU")
    Call<List<HolidayModel>> getHolidays();


}
