package com.example.zxcdialog;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone r = RingtoneManager.getRingtone(context, notification);
        Bundle workAlarm = intent.getExtras();
        Intent intent1 = new Intent(context, AlertReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 100, intent1, 0);
        final AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent);
        Boolean b = workAlarm.getBoolean("workAlarmzxc");
        if (b == true) {
            Log.i("true", "true");
            r.stop();
            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
        } else {
            Log.i("False", "false");
            NotificationHelper notificationHelper = new NotificationHelper(context);
            NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
            notificationHelper.getManager().notify(1, nb.build());
            r.play();
        }


    }

}
