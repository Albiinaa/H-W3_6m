package com.geeks.homework3_1_3m;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MonthsAdapter extends RecyclerView.Adapter<MonthsViewHolder> {

    private ArrayList<String> monthsList;

    public MonthsAdapter(ArrayList<String> monthsList) {
        this.monthsList = monthsList;
    }

    @NonNull
    @Override
    public MonthsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MonthsViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_months, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MonthsViewHolder holder, int position) {
        holder.onBind(monthsList.get(position));
    }

    @Override
    public int getItemCount() {
        return monthsList.size();
    }
}
