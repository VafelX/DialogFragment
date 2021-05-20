package com.example.zxcdialog.lvlActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zxcdialog.MainActivity;
import com.example.zxcdialog.R;

import static android.widget.Toast.LENGTH_LONG;

public class Lvl1 extends AppCompatActivity {
    TextView textView;
    EditText editText;
    AppCompatButton appCompatButton;
    int a;
    int b;
    Integer result;
    int resultEdit;
    Integer zxc;
    Integer x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);
        textView = findViewById(R.id.primer);
        editText = findViewById(R.id.editText);
        x = 100;
        y = 1000;
        a = (int) (x + Math.random() * y - x);
        b = (int) (x + Math.random() * y - x);
        textView.setText(a + " + " + b + " = ");
        appCompatButton = findViewById(R.id.btn_nextPrimer);
        appCompatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int z = a + b;
                Log.d("MY_TAG", "btnClick");

                int zxc = Integer.parseInt(editText.getText().toString());
                if (zxc == z) {
                    Log.d("MY_TAG", "equals");
                    Intent workAlarmIntent = new Intent(Lvl1.this, MainActivity.class);
                    workAlarmIntent.putExtra("workAlarm", true);
                    startActivity(workAlarmIntent);
                }
            }
        });
    }
}