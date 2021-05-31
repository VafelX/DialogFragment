package com.example.zxcdialog.lvlActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zxcdialog.AlertReceiver;
import com.example.zxcdialog.MainActivity;
import com.example.zxcdialog.R;

import java.util.Random;

public class Lvl1 extends AppCompatActivity {
    EditText editText1;
    AppCompatButton btn_nextPrimer1;
    TextView multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);
        editText1 = findViewById(R.id.editText1);
        multiplication = findViewById(R.id.multiplication);
        btn_nextPrimer1 = findViewById(R.id.btn_nextPrimer1);
        int a, b, x, y;
        int[] z = new int[]{2,3,4,5,6,7,8,9};
        Random rand = new Random();
        a = (int) Math.floor(Math.random() * z.length);
        b = (int) Math.floor(Math.random() * z.length);
        int k = 3;
        Intent zxczxxczc = new Intent(Lvl1.this, AlertReceiver.class);
        zxczxxczc.putExtra("wrkLvl1zxcxzc", k);
        sendBroadcast(zxczxxczc);
        multiplication.setText(a + " * " + b + " = ?" );
        btn_nextPrimer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = a * b;
                int y = Integer.parseInt(editText1.getText().toString());
                if (x == y){
                    Intent zxczxxczc = new Intent(Lvl1.this, AlertReceiver.class);
                    Log.d("MY_TAG", "equals");
                    Intent stopAlarm = getIntent();
                    Intent workAlarmIntent = new Intent(Lvl1.this, MainActivity.class);
                    workAlarmIntent.putExtra("workAlarm", true);
                    startActivity(workAlarmIntent);
                    int n = 1;
                    zxczxxczc.putExtra("wrkLvl1", n);
                    sendBroadcast(zxczxxczc);
                    Log.i("psg", "psg");
                }
            }
        });
    }
}