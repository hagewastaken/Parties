package com.example.parties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class bottle extends AppCompatActivity {

    ImageView bottle, back;

    Button spin_btn;

    Random random;

    int angle;

    boolean reset = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottle);

        bottle = findViewById(R.id.bottle);

        spin_btn = findViewById(R.id.spin_btn);

        back = findViewById(R.id.back_icon);

        random = new Random();

        MediaPlayer sound = MediaPlayer.create(bottle.this, R.raw.amongus);

        spin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (reset){
                    int temp = angle % 360;
                    RotateAnimation rotate = new RotateAnimation(temp, 360 , RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(1000);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);

                    Toast.makeText(bottle.this, "Bottle Position Reset", Toast.LENGTH_SHORT).show();

                    spin_btn.setText("SPIN");
                    reset = false;
                } else {
                    sound.start();
                    angle = random.nextInt(1800) + 1080;
                    RotateAnimation rotate = new RotateAnimation(0, angle , RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                    rotate.setFillAfter(true);
                    rotate.setDuration(2500);
                    rotate.setInterpolator(new AccelerateDecelerateInterpolator());

                    bottle.startAnimation(rotate);

                    Toast.makeText(bottle.this, "Bottle Spinning", Toast.LENGTH_SHORT).show();

                    reset = true;
                    spin_btn.setText("RESET");
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(bottle.this, MainActivity.class));
            }
        });
    }
}