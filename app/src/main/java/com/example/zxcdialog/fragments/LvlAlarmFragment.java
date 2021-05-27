package com.example.zxcdialog.fragments;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.zxcdialog.AlertReceiver;
import com.example.zxcdialog.MainActivity;
import com.example.zxcdialog.NotificationHelper;
import com.example.zxcdialog.R;


public class LvlAlarmFragment extends DialogFragment {

    AppCompatButton btnLvl0, btnLvl1, btnLvl2, btnLvl3, btnNext;
    TextView textViewLvl;
    public int lvlAlarmint;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lvl_alarm, container, false);
        textViewLvl = (TextView) view.findViewById(R.id.tv_lvl);
        btnLvl1 = (AppCompatButton) view.findViewById(R.id.btnLvl1);
        btnLvl2 = (AppCompatButton) view.findViewById(R.id.btnLvl2);
        btnLvl3 = (AppCompatButton) view.findViewById(R.id.btnLvl3);
        btnNext = (AppCompatButton) view.findViewById(R.id.btn_next);



        btnLvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarmint = 1;
                textViewLvl.setText("Вы установли " + String.valueOf(lvlAlarmint) + "-ый уровень");
            }
        });

        btnLvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarmint = 2;
                textViewLvl.setText("Вы установли " + String.valueOf(lvlAlarmint) + "-ой уровень");
            }
        });

        btnLvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarmint = 3;
                textViewLvl.setText("Вы установли " + String.valueOf(lvlAlarmint) + "-ий уровень");
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
                /*Intent lvlAlarm = new Intent(LvlAlarmFragment.this.getActivity(), AlertReceiver.class);
                Log.i("new Intent", "new Intent");
                lvlAlarm.putExtra("lvlAlarm", lvlAlarmint);
                Log.i("putExtra", "putExtra");
                getActivity().sendBroadcast(lvlAlarm);
                Log.i("startActivity", "startActivity");*/
            }
        });


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}