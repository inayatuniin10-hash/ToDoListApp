package com.example.to_dolistapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class HariIniFragment extends Fragment {

    private RecyclerView recyclerViewReflections;
    private ReflectionAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hari_ini, container, false);

        recyclerViewReflections = view.findViewById(R.id.recyclerViewReflections);
        recyclerViewReflections.setLayoutManager(new LinearLayoutManager(getContext()));

        List<ReflectionItem> items = new ArrayList<>();
        items.add(new ReflectionItem("Pagi menjelang siang", "1/1 selesai", "Harian"));
        items.add(new ReflectionItem("Ambil napas dalam-dalam", "Harian • 12:45", "Meditasi"));

        adapter = new ReflectionAdapter(items);
        recyclerViewReflections.setAdapter(adapter);

        return view;
    }
}