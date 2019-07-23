package com.example.andri.fitprogram;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseAct extends AppCompatActivity {

    TextView titlepage, subtitlepage, tvabs, tvabssub, tvarm, tvarmsub, tvchest, tvchestsub, tvleg, tvlegsub;
    ImageView shapeabs, shapearm, shapechest, shapeleg;
    FloatingActionButton btn_stopwatch;

    Animation bttone, bttwo, bttfour, bttfive, bttsix, bttseven, btteight, btgnine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        // load animations
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive);
        bttsix = AnimationUtils.loadAnimation(this, R.anim.bttsix);
        bttseven = AnimationUtils.loadAnimation(this, R.anim.bttseven);
        btteight = AnimationUtils.loadAnimation(this, R.anim.btteight);
        btgnine = AnimationUtils.loadAnimation(this, R.anim.btgnine);

        // import font
        Typeface PlayfairDisplay = Typeface.createFromAsset(getAssets(), "fonts/PlayfairDisplay-Bold.ttf");
        Typeface SourceSansProRegular = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        Typeface SourceSansProSemiBold = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-SemiBold.ttf");

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        tvabs = (TextView) findViewById(R.id.tvabs);
        tvabssub = (TextView) findViewById(R.id.tvabssub);
        tvarm = (TextView) findViewById(R.id.tvarm);
        tvarmsub = (TextView) findViewById(R.id.tvarmsub);
        tvchest = (TextView) findViewById(R.id.tvchest);
        tvchestsub = (TextView) findViewById(R.id.tvchestsub);
        tvleg = (TextView) findViewById(R.id.tvleg);
        tvlegsub = (TextView) findViewById(R.id.tvlegsub);
        shapeabs = (ImageView) findViewById(R.id.shapeabs);
        shapearm = (ImageView) findViewById(R.id.shapearm);
        shapechest = (ImageView) findViewById(R.id.shapechest);
        shapeleg = (ImageView) findViewById(R.id.shapeleg);
        btn_stopwatch = (FloatingActionButton) findViewById(R.id.btn_stopwatch);

        // customize font
        titlepage.setTypeface(PlayfairDisplay);
        subtitlepage.setTypeface(SourceSansProRegular);
        tvabs.setTypeface(SourceSansProSemiBold);
        tvabssub.setTypeface(SourceSansProRegular);
        tvarm.setTypeface(SourceSansProSemiBold);
        tvarmsub.setTypeface(SourceSansProRegular);
        tvchest.setTypeface(SourceSansProSemiBold);
        tvchestsub.setTypeface(SourceSansProRegular);
        tvleg.setTypeface(SourceSansProSemiBold);
        tvlegsub.setTypeface(SourceSansProRegular);

        // assign the animations
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        shapeabs.startAnimation(bttwo);
        tvabs.startAnimation(bttwo);
        tvabssub.startAnimation(bttwo);

        shapearm.startAnimation(bttfour);
        tvarm.startAnimation(bttfour);
        tvarmsub.startAnimation(bttfour);

        shapechest.startAnimation(bttfive);
        tvchest.startAnimation(bttfive);
        tvchestsub.startAnimation(bttfive);

        shapeleg.startAnimation(bttsix);
        tvleg.startAnimation(bttsix);
        tvlegsub.startAnimation(bttsix);

        btn_stopwatch.startAnimation(btgnine);

        // give an event to another page
        tvabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ExerciseAct.this,WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        tvarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ExerciseAct.this,Workout2Act.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        tvchest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ExerciseAct.this,Workout3Act.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        tvleg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ExerciseAct.this,Workout4Act.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        btn_stopwatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(ExerciseAct.this, StopWatchAct.class);
                startActivity(a);
            }
        });
    }
}
