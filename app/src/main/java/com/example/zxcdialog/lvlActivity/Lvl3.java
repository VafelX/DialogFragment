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

public class Lvl3 extends AppCompatActivity {
    TextView textView;
    EditText editText;
    AppCompatButton appCompatButton;
    int a;
    int b;
    Integer x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl2);
        textView = findViewById(R.id.primer);
        editText = findViewById(R.id.editText2);
        Boolean closeAlarm = true;
        x = 10;
        y = 100;
        a = (int) (x + Math.random() * y - x);
        b = (int) (x + Math.random() * y - x);
        textView.setText(a + " * " + b + " = ?");
        appCompatButton = findViewById(R.id.btn_nextPrimer2);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int z = a * b;
                Log.d("MY_TAG", "btnClick");

                int zxc = Integer.parseInt(editText.getText().toString());
                if (zxc == z) {
                    Log.d("MY_TAG", "equals");
                    Intent stopAlarm = getIntent();
                    Intent workAlarmIntent = new Intent(Lvl3.this, MainActivity.class);
                    workAlarmIntent.putExtra("workAlarm", true);
                    startActivity(workAlarmIntent);
                    Intent zxczxxczc = new Intent(Lvl3.this, AlertReceiver.class);
                    zxczxxczc.putExtra("workAlarmzxc", closeAlarm);
                    sendBroadcast(zxczxxczc);
                    Log.i("psg", "psg");
                }

            }
        });
    }


}