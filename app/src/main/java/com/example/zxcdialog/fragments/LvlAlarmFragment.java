package com.example.zxcdialog.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zxcdialog.AlertReceiver;
import com.example.zxcdialog.MainActivity;
import com.example.zxcdialog.R;


public class LvlAlarmFragment extends DialogFragment {
    private static final String TAG = "MyCustomDialog";




    AppCompatButton btnLvl0, btnLvl1, btnLvl2, btnLvl3, btnNext;
    TextView textViewLvl;
    int lvlAlarmInt;

    public interface OnInputListener{
        void sendInput(Integer input);
    }
    public OnInputListener mOnInputListener;

    private MediaPlayer.OnCompletionListener mListener;

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
                lvlAlarmInt = 1;
                textViewLvl.setText("Вы установли " + lvlAlarmInt + "-ый уровень");
            }
        });

        btnLvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarmInt = 2;
                textViewLvl.setText("Вы установли " + lvlAlarmInt + "-ой уровень");
            }
        });

        btnLvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlAlarmInt = 3;
                textViewLvl.setText("Вы установли " + lvlAlarmInt + "-ий уровень");
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer input = lvlAlarmInt;
                mOnInputListener.sendInput(input);
                Intent lvlAlarm = new Intent(getActivity(), AlertReceiver.class);
                lvlAlarm.putExtra("hello", lvlAlarmInt);
                getActivity().sendBroadcast(lvlAlarm);
                getActivity().
                        getSupportFragmentManager()
                        .beginTransaction()
                        .remove(LvlAlarmFragment.this)
                        .commit();




            }
        });


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            mOnInputListener = (OnInputListener) getActivity();
        }catch (ClassCastException e){
            Log.e(TAG, "onAttach: ClassCastException: " + e.getMessage() );
        }
    }
}