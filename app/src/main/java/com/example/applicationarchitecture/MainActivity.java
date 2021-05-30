package com.example.applicationarchitecture;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import com.example.applicationarchitecture.activity.HolidayActivity;
import com.example.applicationarchitecture.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // биндинг после установки layout

        // переход к приложению с mvvm архитектурой
        binding.btnJava.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, HolidayActivity.class)));
    }
}