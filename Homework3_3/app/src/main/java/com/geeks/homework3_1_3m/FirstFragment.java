package com.geeks.homework3_1_3m;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

   private RecyclerView rvMonths;
   private ArrayList<String> monthsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        rvMonths = requireActivity().findViewById(R.id.rv_months);
        loadData();
        MonthsAdapter adapter = new MonthsAdapter(monthsList);
        rvMonths.setAdapter(adapter);
    }

    private void loadData() {
        monthsList.add("January");
        monthsList.add("February");
        monthsList.add("March");
        monthsList.add("April");
        monthsList.add("May");
        monthsList.add("June");
        monthsList.add("July");
        monthsList.add("August");
        monthsList.add("September");
        monthsList.add("October");
        monthsList.add("November");
        monthsList.add("December");
    }
}