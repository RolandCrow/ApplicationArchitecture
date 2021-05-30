package com.example.applicationarchitecture.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.example.applicationarchitecture.presenter.SomeScreenPresenter;
import com.example.applicationarchitecture.view.SomeScreenView;

public class SomeScreenActivity extends Activity implements SomeScreenView { // активити для mvp

    private SomeScreenPresenter someScreenPresenter; // добавляем презентер
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        someScreenPresenter = new SomeScreenPresenter(this); // новый экземпляр презентера
        someScreenPresenter.initialize(); // иницируем в начале работы активности

    }

    @Override
    public void startLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void mapDataItems() {

    }
}
