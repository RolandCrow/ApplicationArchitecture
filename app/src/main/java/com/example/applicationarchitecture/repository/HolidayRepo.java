package com.example.applicationarchitecture.repository;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.example.applicationarchitecture.api.ApiInterface;
import com.example.applicationarchitecture.api.MyApplication;
import com.example.applicationarchitecture.model.HolidayModel;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class HolidayRepo { // репозиторий для mvvm

    private final String TAG = getClass().getSimpleName();

    public MutableLiveData<List<HolidayModel>> requestHolidays() { // изменения через лайв дата
        final MutableLiveData<List<HolidayModel>> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiInterface = MyApplication.getRetrofitClient().create(ApiInterface.class); // подключаем ретрофит

        apiInterface.getHolidays().enqueue(new Callback<List<HolidayModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<HolidayModel>> call, @NotNull Response<List<HolidayModel>> response) {
                Log.e(TAG, "getCurrencyList response" + response); // ответ от запроса ретрофита

                if(response.isSuccessful() && response.body() != null) { // если запрос успешен и тело запроса не пустое то
                    Log.e(TAG, "requestHolidays response.size" + response.body());
                    mutableLiveData.setValue(response.body()); // устанавливаем значение из запроса

                }

            }

            @Override
            public void onFailure(@NotNull Call<List<HolidayModel>> call, @NotNull Throwable t) {
                Log.d(TAG, "getProdList onFailure" + call.toString());

            }
        });

        return  mutableLiveData;



    }

}
