package com.example.stopwatch2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopAct extends AppCompatActivity {
    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone;
    Chronometer timeHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        icanchor = findViewById(R.id.icanchor);
        timeHere = findViewById(R.id.timehere);

        btnstop.setAlpha(0);


        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");


        btnstart.setTypeface(MMedium);
        btnstop.setTypeface(MMedium);
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();

                timeHere.setBase(SystemClock.elapsedRealtime());
                timeHere.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ending animation
                icanchor.clearAnimation();
                btnstart.animate().alpha(1).setDuration(300).start();
                btnstop.animate().alpha(0).setDuration(300).start();
                //ending timer
                timeHere.stop();
            }
        });
    }
}