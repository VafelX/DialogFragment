package com.example.zxcdialog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AlertReceiver extends BroadcastReceiver {
    public int zxcGhoul;
    public int def = 0;
    public int zvb;

    @Override
    public void onReceive(Context context, Intent intent) {
        int aboba;
        MediaPlayer song = MediaPlayer.create(context, R.raw.alarm);
        Bundle workAlarm = intent.getExtras();

        ArrayList<Integer> arrayList = new ArrayList<>();
        int lvl = workAlarm.getInt("LVL");
        zvb = lvl;
        arrayList.add(lvl);


        Integer wrkLvl1;
        Intent intent1 = new Intent(context, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 100, intent1, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        boolean equals = workAlarm.getBoolean("equals");
        Log.i("equ", String.valueOf(equals));
        wrkLvl1 = workAlarm.getInt("wrkLvl1");
        Log.i("wLVLr1", String.valueOf(wrkLvl1));
        int count;
        int wrk = 0;


        int LVL = zxcGhoul;
        if (def == 0) {
            wrk = workAlarm.getInt("wrk", 0);
            if (wrk == 3) {
                def = 1;
            }
        }
        Log.i("def", String.valueOf(def));


        if (wrkLvl1 == 1) {
            Log.i("true", "true");
            if (song != null) {
                try {
                    song.reset();
                    song.prepare();
                    song.stop();
                    song.release();
                    song = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                alarmManager.cancel(pendingIntent);
                pendingIntent.cancel();
                def = 0;

            }

        }
        if (def == 1) {
            int lvlAlarm = workAlarm.getInt("hello");
            Log.i("hello", String.valueOf(lvlAlarm));
            Log.i("lvlvan", String.valueOf(lvlAlarm));
            if (lvlAlarm == 1) {
                NotificationHelper1 notificationHelper = new NotificationHelper1(context);
                NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
                notificationHelper.getManager().notify(1, nb.build());
            }
            if (lvlAlarm == 2) {
                NotificationHelper2 notificationHelper2 = new NotificationHelper2(context);
                NotificationCompat.Builder nb = notificationHelper2.getChannelNotification();
                notificationHelper2.getManager().notify(2, nb.build());
            }
            if (lvlAlarm == 3) {
                NotificationHelper3 notificationHelper3 = new NotificationHelper3(context);
                NotificationCompat.Builder nb = notificationHelper3.getChannelNotification();
                notificationHelper3.getManager().notify(3, nb.build());
            }
            song.start();
        }

    }


}