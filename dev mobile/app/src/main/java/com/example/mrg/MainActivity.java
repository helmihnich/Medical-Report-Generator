package com.example.mrg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mrg.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    boolean i=true;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isFirstTime = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstTime", true);


        if (isFirstTime) {
            // Display intro layout
            setContentView(R.layout.intro);

            // Set flag to indicate that intro has been shown
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstTime", false).apply();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    // Switch to main activity layout after 5 seconds
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setContentView(R.layout.activity_main);
                        }
                    });
                }
            }, 5000); // 5000 milliseconds = 5 seconds
        } else {
            // Intro has been shown before, directly switch to main activity layout
            setContentView(R.layout.activity_main);
        }
    }    public void login_btn(View view) {
        // Action à effectuer lorsque le bouton est cliqué
        Toast.makeText(this, "Le bouton a été cliqué!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, home.class));


    }
    public void forgotPasswordClicked(View view) {
        // Action à effectuer lorsque le bouton est cliqué
        Toast.makeText(this, "forget passwordp!", Toast.LENGTH_SHORT).show();
    }
    public void btn_sign_up(View view) {
        // Action à effectuer lorsque le bouton est cliqué
        Toast.makeText(this, "sign up !", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, sign_up.class));

    }


}