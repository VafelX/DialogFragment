package com.example.zxcdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.zxcdialog.fragments.LvlAlarmFragment;
import com.example.zxcdialog.fragments.TimePickerFragment;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private SharedPreferences pref;
    private TextView mTextView;
    Boolean aBoolean;
    public static final String save_key = "save_key";
    int ALARM_TYPE = AlarmManager.RTC_WAKEUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        mTextView = findViewById(R.id.textView);
        Button buttonTimePicker = findViewById(R.id.button_timepicker);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });
        Button buttonCancelAlarm = findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelAlarm();
            }
        });
        mTextView.setText(pref.getString(save_key, "пусто"));
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        DialogFragment lvlAlarm = new LvlAlarmFragment();
        lvlAlarm.show(getSupportFragmentManager(), "lvlAlarm");
        updateTimeText(c);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString(save_key, mTextView.getText().toString());
        edit.apply();
        startAlarm(c);
    }

    @SuppressLint("NewApi")
    private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());
        mTextView.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }


        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis() + 5000, pendingIntent);


    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm canceled");
        SharedPreferences.Editor editCancel = pref.edit();
        editCancel.putString(save_key, mTextView.getText().toString());
        editCancel.apply();

    }

    private void init() {
        pref = getSharedPreferences("Test", MODE_PRIVATE);
    }
}