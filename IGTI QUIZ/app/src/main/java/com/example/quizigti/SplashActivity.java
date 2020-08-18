package com.example.quizigti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.util.Random;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        SplashScreenTimer();

    }

    private void SplashScreenTimer(){
        long timeSplashScreen = getSplashTime();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                redirect();
            }
        }, timeSplashScreen);
    }

    public  void redirect (){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private long getSplashTime(){
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        Boolean firstLogin = sharedPreferences.getBoolean("FIRST_LOGIN", true);

        if(firstLogin){
            editor.putBoolean("FIRST_LOGIN", false);
            editor.commit();
            return 2000;
        }else {
            return 500;
        }
    }
}
