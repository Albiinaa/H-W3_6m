package com.geeks.homework3_1_3m;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MonthsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvMonths;
    public MonthsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvMonths = itemView.findViewById(R.id.tv_months);
    }
    public void onBind(String months){
        tvMonths.setText(months);
    }
}
