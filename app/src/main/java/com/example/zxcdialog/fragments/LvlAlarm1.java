package com.example.zxcdialog.fragments;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zxcdialog.R;

import static android.widget.Toast.LENGTH_LONG;


public class LvlAlarm1 extends DialogFragment {
    TextView textView;
    EditText editText;
    AppCompatButton appCompatButton;
    int a;
    int b;
    String result;
    int resultEdit;
    String zxc;
    Integer x,y;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lvl_alarm1, container, false);
        textView = (TextView)view.findViewById(R.id.primer);
        editText = (EditText)view.findViewById(R.id.editText);
        x = 100;
        y = 1000;
        a = (int) (x + Math.random()*y-x);
        b = (int) (x + Math.random()*y-x);
        textView.setText(a + " + " + b + " = ");
        appCompatButton = (AppCompatButton)view.findViewById(R.id.btn_nextPrimer);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = String.valueOf(a + b);

                zxc = String.valueOf(editText.getText());
                if (zxc == result){
                    Toast toast = Toast.makeText(getActivity(),"NICE", LENGTH_LONG);
                    toast.show();
                }
            }
        });

        return view;
    }
}