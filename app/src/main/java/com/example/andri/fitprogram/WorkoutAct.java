package com.example.andri.fitprogram;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WorkoutAct extends AppCompatActivity {

    TextView titlepage, subtitlepage, intropage, subintropage,
            btnexercise, fitonetitle, fitonedesc, fittwotitle, fittwodesc,
            fitthreetitle, fitthreedesc, fitfourtitle, fitfourdesc;

    Animation bttone, bttwo, bttfour, bttfive, bttsix, bttseven, btteight;

    View divpage, bgprogress;

    LinearLayout fitone, fittwo, fitthree, fitfour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        // load animations
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        bttfour = AnimationUtils.loadAnimation(this, R.anim.bttfour);
        bttfive = AnimationUtils.loadAnimation(this, R.anim.bttfive);
        bttsix = AnimationUtils.loadAnimation(this, R.anim.bttsix);
        bttseven = AnimationUtils.loadAnimation(this, R.anim.bttseven);
        btteight = AnimationUtils.loadAnimation(this, R.anim.btteight);

        // import font

        Typeface PlayfairDisplay = Typeface.createFromAsset(getAssets(), "fonts/PlayfairDisplay-Bold.ttf");
        Typeface SourceSansProRegular = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-Regular.ttf");
        Typeface SourceSansProSemiBold = Typeface.createFromAsset(getAssets(), "fonts/SourceSansPro-SemiBold.ttf");

        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        intropage = (TextView) findViewById(R.id.intropage);
        subintropage = (TextView) findViewById(R.id.subintropage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        divpage = (View) findViewById(R.id.divpage);
        bgprogress = (View) findViewById(R.id.bgprogress);


        // give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(WorkoutAct.this,StartWorkAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });

        // item fit layout
        fitone = (LinearLayout) findViewById(R.id.fitone);
        fittwo = (LinearLayout) findViewById(R.id.fittwo);
        fitthree = (LinearLayout) findViewById(R.id.fitthree);
        fitfour = (LinearLayout) findViewById(R.id.fitfour);




        // item fit
        fitonetitle = (TextView) findViewById(R.id.fitonetitle);
        fitonedesc = (TextView) findViewById(R.id.fitonedesc);

        fittwotitle = (TextView) findViewById(R.id.fittwotitle);
        fittwodesc = (TextView) findViewById(R.id.fittwodesc);

        fitthreetitle = (TextView) findViewById(R.id.fitthreetitle);
        fitthreedesc = (TextView) findViewById(R.id.fitthreedesc);

        fitfourtitle = (TextView) findViewById(R.id.fitfourtitle);
        fitfourdesc = (TextView) findViewById(R.id.fitfourdesc);

        // customize font
        titlepage.setTypeface(PlayfairDisplay);
        subtitlepage.setTypeface(SourceSansProRegular);
        intropage.setTypeface(PlayfairDisplay);
        subintropage.setTypeface(SourceSansProRegular);
        btnexercise.setTypeface(SourceSansProSemiBold);

        // customize font item
        fitonedesc.setTypeface(SourceSansProRegular);
        fitonetitle.setTypeface(SourceSansProSemiBold);

        fittwodesc.setTypeface(SourceSansProRegular);
        fittwotitle.setTypeface(SourceSansProSemiBold);

        fitthreedesc.setTypeface(SourceSansProRegular);
        fitthreetitle.setTypeface(SourceSansProSemiBold);

        fitfourdesc.setTypeface(SourceSansProRegular);
        fitfourtitle.setTypeface(SourceSansProSemiBold);

        // assign the animations
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);
        divpage.startAnimation(bttone);

        intropage.startAnimation(bttwo);
        subintropage.startAnimation(bttwo);

        fitone.startAnimation(bttwo);
        fittwo.startAnimation(bttfour);
        fitthree.startAnimation(bttfive);
        fitfour.startAnimation(bttsix);

        btnexercise.startAnimation(btteight);
        bgprogress.startAnimation(bttseven);

    }
}
