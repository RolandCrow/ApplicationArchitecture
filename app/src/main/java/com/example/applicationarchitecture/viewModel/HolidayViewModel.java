package com.example.applicationarchitecture.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.applicationarchitecture.model.HolidayModel;
import com.example.applicationarchitecture.repository.HolidayRepo;

import java.util.List;

public class HolidayViewModel  extends ViewModel { // вью модел для mvvm
    private HolidayRepo holidayRepo; // подключаем репозиторий
    private MutableLiveData<List<HolidayModel>> mutableLiveData;

    public HolidayViewModel() {
        holidayRepo = new HolidayRepo(); // новый экземпляр репозиторий
    }

    public MutableLiveData<List<HolidayModel>> getHolidays() { // получаем запрос от класса с данными вне основного потока
        if(mutableLiveData == null) {
            mutableLiveData = holidayRepo.requestHolidays(); // запрос из репозитория
        }
        return mutableLiveData;
    }

}
