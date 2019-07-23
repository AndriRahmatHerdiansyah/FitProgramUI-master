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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class EditWorkArmAct3 extends AppCompatActivity {
    TextView titlepage, subtitlepage, fitonetitle, fitonedesc,
            workvalue, fittwotitle, fittwodesc, btnexercise;

    Button btnlocked, btnadd, btnremove;

    FloatingActionButton fab_stop;

    View divpage, bgprogress;

    RelativeLayout fitone, fittwo, fitthree, fitfour;

    Animation bttone, bttwo, bttfour, bttfive, bttsix;

    int sumworkout = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_work_arm_act3);

        // load animations
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive);
        bttsix = AnimationUtils.loadAnimation(this, R.anim.bttsix);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        fitone = findViewById(R.id.fitone);
        fittwo = findViewById(R.id.fittwo);
        fitthree = findViewById(R.id.fitthree);
        fitfour = findViewById(R.id.fitfour);

        divpage = findViewById(R.id.divpage);
        bgprogress = findViewById(R.id.bgprogress);

        fitonetitle = findViewById(R.id.fitonetitle);
        fitonedesc = findViewById(R.id.fitonedesc);
        fittwotitle = findViewById(R.id.fittwotitle);
        fittwodesc = findViewById(R.id.fittwodesc);

        btnlocked = findViewById(R.id.btnlocked);
        btnadd = findViewById(R.id.btnadd);
        btnremove = findViewById(R.id.btnremove);

        workvalue = findViewById(R.id.workvalue);

        btnexercise = findViewById(R.id.btnexercise);

        fab_stop = findViewById(R.id.fab_stop);

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface Vidaloka = Typeface.createFromAsset(getAssets(), "fonts/Vidaloka.ttf");
        // import font
        Typeface PlayfairDisplay = Typeface.createFromAsset(getAssets(), "fonts/PlayfairDisplay-Bold.ttf");
        Typeface SourceSansProRegular = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        Typeface SourceSansProSemiBold = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-SemiBold.ttf");


        // customize font
        titlepage.setTypeface(PlayfairDisplay);
        subtitlepage.setTypeface(SourceSansProRegular);
        btnexercise.setTypeface(SourceSansProSemiBold);

        fitonetitle.setTypeface(SourceSansProSemiBold);
        fitonedesc.setTypeface(SourceSansProRegular);
        fittwotitle.setTypeface(SourceSansProSemiBold);
        fittwodesc.setTypeface(SourceSansProRegular);

        workvalue.setTypeface(SourceSansProSemiBold);

        btnlocked.setTypeface(SourceSansProSemiBold);
        btnadd.setTypeface(SourceSansProSemiBold);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sumworkout+=1;
                workvalue.setText(sumworkout+"");
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sumworkout <= 0){
                    Toast.makeText(getApplicationContext(), "Sorry!", Toast.LENGTH_SHORT).show();
                } else {
                    sumworkout-=1;
                    workvalue.setText(sumworkout+"");
                }
            }
        });

        // assign the animations
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        fitone.startAnimation(bttwo);
        fittwo.startAnimation(bttfour);
        fitthree.startAnimation(bttfive);
        fitfour.startAnimation(bttsix);

        btnexercise.startAnimation(bttfive);
        bgprogress.startAnimation(bttfive);

        // give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(EditWorkArmAct3.this, StartWorkArmAct4.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        // close all
        fab_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(EditWorkArmAct3.this, ExerciseAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
    }
}
