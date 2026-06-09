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

public class JurnalFragment extends Fragment {

    private RecyclerView recyclerViewTasks;
    private TaskOrganizerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jurnal, container, false);

        recyclerViewTasks = view.findViewById(R.id.recyclerViewTasks);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(getContext()));

        List<TaskOrganizer> tasks = new ArrayList<>();
        tasks.add(new TaskOrganizer("Rencana produk", "05:40 AM", false, "Kerja"));
        tasks.add(new TaskOrganizer("Badai otak", "05:40 AM", false, "Kerja"));
        tasks.add(new TaskOrganizer("Belanja", "", false, "Pribadi"));
        tasks.add(new TaskOrganizer("Analisis data", "06:40 PM", true, "Kerja"));
        tasks.add(new TaskOrganizer("Pergi ke Latihan", "", true, "Pribadi"));
        tasks.add(new TaskOrganizer("Pakaian Olahraga", "", true, "Pribadi"));

        adapter = new TaskOrganizerAdapter(tasks);
        recyclerViewTasks.setAdapter(adapter);

        return view;
    }
}