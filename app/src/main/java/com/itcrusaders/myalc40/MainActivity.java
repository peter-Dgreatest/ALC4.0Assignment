package com.itcrusaders.myalc40;

import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button launchALCPage,launchProfilePage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launchALCPage = findViewById(R.id.btn_launch_alc_page);
        launchProfilePage = findViewById(R.id.btn_launch_profile_page);

        launchALCPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ALCPage = new Intent(MainActivity.this,ALCPage.class);
                startActivity(ALCPage);
                //MainActivity.this.finish();
            }
        });

        launchProfilePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Profile.class));
                //MainActivity.this.finish();
            }
        });


    }
}
