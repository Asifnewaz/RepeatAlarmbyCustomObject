package com.asifnewaz.alarmwithcustomobjectdb;

/**
 * Created by USER on 8/30/2017.
 */
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyBroadcastReceiver extends BroadcastReceiver {
    MediaPlayer mp;
    DatabaseHelper mDatabaseHelper;
    AlarmLog alarmLog;
    @Override
    public void onReceive(Context context, Intent intent) {
        mDatabaseHelper = new DatabaseHelper(context);
        mp=MediaPlayer.create(context, R.raw.alarm   );
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();

        //setContentView(R.layout.main);
        Calendar myCalender = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String newEntry = "Alarmed On ";
        String formattedDate = df.format(myCalender.getTime());
        AlarmLog alarmLog=new AlarmLog(newEntry,formattedDate);
        mDatabaseHelper.addData(alarmLog);

    }
}