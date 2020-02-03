package com.example.visumed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R .layout.activity_splash_screen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MostrarLogin();
            }
        }, 3000);

    }

    private void MostrarLogin() {
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);
        finish();
    }
}
