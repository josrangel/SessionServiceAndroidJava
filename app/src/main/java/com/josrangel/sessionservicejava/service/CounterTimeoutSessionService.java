package com.josrangel.sessionservicejava.service;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.josrangel.sessionservicejava.SessionActivity;

/**
 * Source:
 * https://developer.android.com/guide/components/services
 * https://www.tutorialspoint.com/android/android_services.htm
 * https://www.javatpoint.com/android-service-tutorial#:~:text=Android%20Service%20Tutorial%20Android%20service%20is%20a%20component,the%20background%20indefinitely%20even%20if%20application%20is%20destroyed.
 */
public class CounterTimeoutSessionService extends Service {

    CountDownTimer timer;

    @Override
    public void onCreate() {
        super.onCreate();
        timer = new CountDownTimer(10 * 1000, 1000) {

            public void onTick(long millisUntilFinished) {
                //Some code
                Log.i("timer", millisUntilFinished + "");
            }

            public void onFinish() {
                SessionActivity.logout();
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
