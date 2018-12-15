package com.example.soniagrigor.santascomming;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread xyz= new Thread(){
            public void run(){
                try{
                    sleep(SPLASH_TIME_OUT);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    String action;
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        };
        xyz.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
