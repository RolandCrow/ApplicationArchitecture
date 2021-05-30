package com.example.applicationarchitecture.activity;

import android.os.Build;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.applicationarchitecture.R;
import com.example.applicationarchitecture.adapter.HolidayAdapter;
import com.example.applicationarchitecture.api.MyApplication;
import com.example.applicationarchitecture.databinding.ActivityHolidayBinding;
import com.example.applicationarchitecture.model.HolidayModel;
import com.example.applicationarchitecture.viewModel.HolidayViewModel;

import java.util.List;

public class HolidayActivity extends AppCompatActivity { // соединяем тут адаптер с биндингом

    final String TAG = getClass().getSimpleName();
    HolidayAdapter adapter;
    ActivityHolidayBinding binding; // auto generated после добавления в xml разметки layout




    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_holiday);
        initUI();

        if(MyApplication.getInstance().isNetworkAvailable()) {
            HolidayViewModel holidayViewModel = new HolidayViewModel(); // новый экземпляр вьюмоделя
            // добавляем данные из вью моделя в активность
            holidayViewModel.getHolidays().observe(this, holidayModels -> {
                if (holidayModels != null && !holidayModels.isEmpty()) { // если модель не равна ничего и не пуста то можно загружать
                    binding.progressBar.setVisibility(View.GONE);
                    adapter.addHolidayList(holidayModels); // через адаптер устанавливаем данные дальше в активность
                    adapter.notifyDataSetChanged();
                }
            });

        } else {
            Toast.makeText(HolidayActivity.this, "No network available", Toast.LENGTH_LONG).show(); // иначе выскакивает тост с сообщением о проблеме с сетью
        }

    }


    void initUI() { // устанавливаем графический интерфейс
        binding.rvHolidayList.setHasFixedSize(true); // фиксированный размер отображения данных
        binding.rvHolidayList.setLayoutManager(new LinearLayoutManager(this)); // установили лейаут

        adapter = new HolidayAdapter(); // новый экземпляр адаптера
        binding.rvHolidayList.setAdapter(adapter); // утстанавливаем адаптер в лист

    }




}