package com.example.applicationarchitecture.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.applicationarchitecture.R;
import com.example.applicationarchitecture.databinding.ItemHolidayJavaBinding;
import com.example.applicationarchitecture.model.HolidayModel;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> { // адаптер с ресайклер вью и внутренним классом для mvvm

    private List<HolidayModel> holidayList;

    public HolidayAdapter() {
        holidayList = new ArrayList<>();
    }

    public void addHolidayList(List<HolidayModel> currencyList) { // добавление листа с информацией
        this.holidayList = currencyList;
    }



    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) { // присоединяем к ресайклер вью отдельное вью через биндинг
        ItemHolidayJavaBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_holiday_java, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull final MyViewHolder holder, final int position) {
        holder.binding.setModel( holidayList.get(position) );
    }

    @Override
    public int getItemCount() {
        return holidayList != null ? holidayList.size() : 0; // возращаем размер
    }


    static class MyViewHolder extends RecyclerView.ViewHolder { // соединяем холдер и ресайклер вью
        private final ItemHolidayJavaBinding binding;

        MyViewHolder(ItemHolidayJavaBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
