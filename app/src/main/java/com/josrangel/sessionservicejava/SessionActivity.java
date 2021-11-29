package com.josrangel.sessionservicejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.josrangel.sessionservicejava.service.CounterTimeoutSessionService;
import com.josrangel.sessionservicejava.utils.DialogUtils;

public class SessionActivity extends AppCompatActivity {

    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        SessionActivity.context = this;
        initService();
    }

    private void initService() {
        startService(new Intent(this, CounterTimeoutSessionService.class));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        rebootCounter();
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        rebootCounter();
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean dispatchKeyShortcutEvent(KeyEvent event) {
        rebootCounter();
        return super.dispatchKeyShortcutEvent(event);
    }

    private void rebootCounter(){
        stopService();
        initService();
    }

    private void stopService() {
        stopService(new Intent(this, CounterTimeoutSessionService.class));
    }

    public static void logout() {
        DialogUtils.makeDialogLogout(context);
    }
}