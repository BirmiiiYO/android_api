package com.ilya.last_lab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    private TextView nameTextView;
    private TextView maxharvestTextView;
    private TextView growthTimeTextView;
    private TextView idTextView;
    private TextView sizeTextView;
    private TextView smoothnessTextView;
    private TextView soilDrynessTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        nameTextView = view.findViewById(R.id.nameTextView);
        maxharvestTextView = view.findViewById(R.id.maxharvestTextView);
        growthTimeTextView = view.findViewById(R.id.growthTimeTextView);
        idTextView = view.findViewById(R.id.idTextView);
        sizeTextView = view.findViewById(R.id.sizeTextView);
        smoothnessTextView = view.findViewById(R.id.smoothnessTextView);
        soilDrynessTextView = view.findViewById(R.id.soilDrynessTextView);

        Bundle args = getArguments();
        if (args != null) {
            String name = args.getString("name", "");
            int maxHarvest = args.getInt("max_harvest");
            int growthTime = args.getInt("growth_time");
            int id = args.getInt("id");
            int size = args.getInt("Size");
            int smoothness = args.getInt("Smoothness");
            int soilDryness = args.getInt("SoilDryness");

            nameTextView.setText("Вид ягоды: " + name);
            maxharvestTextView.setText("Максимальный урожай: " + maxHarvest+" Кг.");
            growthTimeTextView.setText("Время роста: " + growthTime+" Нед.");
            idTextView.setText("Идентификатор: " + id);
            sizeTextView.setText("Размер: " + size+" Мм.");
            smoothnessTextView.setText("Гладкость: " + smoothness+"%");
            soilDrynessTextView.setText("Сухость почвы: " + soilDryness+"%");

        }

        return view;
    }
}

