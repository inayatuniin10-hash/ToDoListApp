package com.jadwalin.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class ProfilFragment extends Fragment {

    private TextView tvUserName, tvUserEmail;
    private Button btnLogout;
    private SharedPreferences sharedPreferences;
    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        tvUserName = view.findViewById(R.id.tvUserName);
        tvUserEmail = view.findViewById(R.id.tvUserEmail);
        btnLogout = view.findViewById(R.id.btnLogout);

        sharedPreferences = getActivity().getSharedPreferences("JadwalinPrefs", MODE_PRIVATE);
        databaseHelper = new DatabaseHelper(getContext());

        String email = sharedPreferences.getString("userEmail", "");
        tvUserEmail.setText(email);

        // Get user name from database
        String name = databaseHelper.getUserName(email);
        tvUserName.setText(name);

        btnLogout.setOnClickListener(v -> {
            sharedPreferences.edit().clear().apply();
            startActivity(new Intent(getContext(), LoginActivity.class));
            getActivity().finish();
        });

        return view;
    }
}