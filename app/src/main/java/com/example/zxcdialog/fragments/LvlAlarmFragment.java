package com.example.zxcdialog.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.zxcdialog.R;


public class LvlAlarmFragment extends DialogFragment {

    public int lvlAlarm = 0;
    AppCompatButton btnLvl0, btnLvl1, btnLvl2, btnLvl3, btnNext;
    TextView textViewLvl;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lvl_alarm, container, false);
        textViewLvl = (TextView) view.findViewById(R.id.tv_lvl);
        btnLvl0 = (AppCompatButton) view.findViewById(R.id.btnLvl0);
        btnLvl1 = (AppCompatButton) view.findViewById(R.id.btnLvl1);
        btnLvl2 = (AppCompatButton) view.findViewById(R.id.btnLvl2);
        btnLvl3 = (AppCompatButton) view.findViewById(R.id.btnLvl3);
        btnNext = (AppCompatButton) view.findViewById(R.id.btn_next);

        btnLvl0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewLvl.setText("Вы установли " + String.valueOf(lvlAlarm) + "-ой уровень");
            }
        });

        btnLvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarm = 1;
                textViewLvl.setText("Вы установли " + String.valueOf(lvlAlarm) + "-ый уровень");
            }
        });

        btnLvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarm = 2;
                textViewLvl.setText("Вы установли " + String.valueOf(lvlAlarm) + "-ой уровень");
            }
        });

        btnLvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarm = 3;
                textViewLvl.setText("Вы установли " + String.valueOf(lvlAlarm) + "-ий уровень");
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().
                        getSupportFragmentManager()
                        .beginTransaction()
                        .remove(LvlAlarmFragment.this)
                        .commit();
            }
        });


        return view;
    }
}