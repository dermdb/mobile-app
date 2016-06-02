package com.dscubed.dermdb.dermdbapp.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.dscubed.dermdb.dermdbapp.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventAction = event.getAction();

        switch (eventAction) {
            case MotionEvent.ACTION_DOWN:
                // finger is touching the screen
                break;
            case MotionEvent.ACTION_MOVE:
                // finger is moving on the screen
                break;
            case MotionEvent.ACTION_UP:
                // finger is leaving the screen
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onTouchEvent(event);
    }
}
