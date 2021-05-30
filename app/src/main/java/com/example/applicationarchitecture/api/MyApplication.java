package com.example.applicationarchitecture.api;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;

import android.os.Build;
import androidx.annotation.RequiresApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MyApplication extends Application { // обеспечиваем работу апи

    final String TAG = getClass().getSimpleName();

    private static MyApplication mInstance;
    private static Retrofit retrofit = null;


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized MyApplication getInstance() { // сохранение состояния
        return mInstance;
    }


    public boolean isNetworkAvailable() { // проверка подключения к сети
        @SuppressLint("ServiceCast") ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
        Network activeNetworkInfo = null;
        if(connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activeNetworkInfo = connectivityManager.getActiveNetwork();
            }
        }
        return activeNetworkInfo != null;
    }

    public static Retrofit getRetrofitClient() { // работаем с ретрофитом
        if(retrofit == null) { // если ретрофит ноль то начинаем работать
            okhttp3.OkHttpClient client = new okhttp3.OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .client(client)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()) // превращаем в gson
                    .baseUrl(Constants.BASE_URL)
                    .build();


        }
        return retrofit;
    }


}
