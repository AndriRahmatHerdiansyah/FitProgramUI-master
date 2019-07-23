package com.example.andri.fitprogram;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView iconanchor;
    Animation roundingalone, roundingnull;
    Chronometer timerHere;
    boolean running;
    long pauseOffset;
    FloatingActionButton btn_back, fab_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = findViewById(R.id.btnstart);
        btnstop = findViewById(R.id.btnstop);
        iconanchor = findViewById(R.id.icanchor);
        timerHere = findViewById(R.id.timerHere);
        btn_back = findViewById(R.id.btn_back);
        fab_refresh = findViewById(R.id.fab_refresh);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(StopWatchAct.this, ExerciseAct.class);
                startActivity(a);
            }
        });

        // create optional animation
        btnstop.setAlpha(0);

        // load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);
        roundingnull = AnimationUtils.loadAnimation(this, R.anim.roundingnull);

        // import font
        Typeface SourceSansProSemiBold = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-SemiBold.ttf");

        // customize font
        btnstart.setTypeface(SourceSansProSemiBold);
        btnstop.setTypeface(SourceSansProSemiBold);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // passing animation
                iconanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                // start time
//                timerHere.setBase(SystemClock.elapsedRealtime());
//                timerHere.start();

                if (!running){
                    timerHere.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    timerHere.start();
                    running = true;
                }
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iconanchor.startAnimation(roundingnull);
                btnstop.animate().alpha(0).setDuration(300).start();
                btnstart.animate().alpha(1).translationY(0).setDuration(300).start();
                //stop
//                timerHere.setBase(SystemClock.elapsedRealtime());
//                timerHere.stop();
                if (running){
                    timerHere.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - timerHere.getBase();
                    running = false;
                }
            }
        });
        fab_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerHere.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;
            }
        });
    }
}
