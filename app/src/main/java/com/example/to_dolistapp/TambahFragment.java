package com.example.to_dolistapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;

public class TambahFragment extends Fragment {

    private EditText etTaskName, etNotes;
    private TextView tvFocus, tvWin, tvTodayGoal;
    private MaterialButton btnSaveTask;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tambah, container, false);

        etTaskName = view.findViewById(R.id.etTaskName);
        etNotes = view.findViewById(R.id.etNotes);
        tvFocus = view.findViewById(R.id.tvFocus);
        tvWin = view.findViewById(R.id.tvWin);
        tvTodayGoal = view.findViewById(R.id.tvTodayGoal);
        btnSaveTask = view.findViewById(R.id.btnSaveTask);

        btnSaveTask.setOnClickListener(v -> {
            // Save task logic
            String taskName = etTaskName.getText().toString();
            if (!taskName.isEmpty()) {
                // Save to database
                android.widget.Toast.makeText(getContext(), "Tugas ditambahkan!", android.widget.Toast.LENGTH_SHORT).show();
                etTaskName.setText("");
                etNotes.setText("");
            }
        });

        return view;
    }
}