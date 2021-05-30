package com.example.applicationarchitecture.presenter;

import com.example.applicationarchitecture.activity.SomeScreenActivity;
import com.example.applicationarchitecture.view.SomeScreenView;

public class SomeScreenPresenter{ // презентер для mvp задаем функции для вью с использованием методов из интерфейса модели
    private SomeScreenView mView;

    public SomeScreenPresenter(SomeScreenActivity someScreenActivity) {

    }

    public void setView(SomeScreenView view) {
        mView = view;
    }

    public void initialize() {
        mView.startLoading();


        mView.mapDataItems();
        mView.stopLoading();

    }
}
