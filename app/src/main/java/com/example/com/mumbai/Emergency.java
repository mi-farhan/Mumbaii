package com.example.com.mumbai;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;

public class Emergency extends AppCompatActivity {
    CardView c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        LinearLayout constraintLayout=findViewById(R.id.grid);
        AnimationDrawable animationDrawable=(AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        c1=(CardView)findViewById(R.id.card1);
        c2=(CardView)findViewById(R.id.card2);
        c3=(CardView)findViewById(R.id.card3);
        c4=(CardView)findViewById(R.id.card4);
        c5=(CardView)findViewById(R.id.card5);
        c6=(CardView)findViewById(R.id.Card6);
        c7=(CardView)findViewById(R.id.Card7);
        c8=(CardView)findViewById(R.id.Card8);
        c9=(CardView)findViewById(R.id.Card9);
        c10=(CardView)findViewById(R.id.Card10);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:100");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:1298");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:101");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:23004000");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:103");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:02224937747");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:+912224921212");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:02228225709");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:02222694725");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number=Uri.parse("tel:0222067676");
                Intent i=new Intent(Intent.ACTION_DIAL,number);
                startActivity(i);
            }
        });
    }
}
