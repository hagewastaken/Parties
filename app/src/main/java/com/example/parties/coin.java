package com.example.parties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class coin extends AppCompatActivity {

    ImageView coin, back;

    Button flip;

    int sides;

    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin);

        coin = findViewById(R.id.iv_coin);
        back = findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(coin.this, MainActivity.class));
            }
        });

        flip = findViewById(R.id.flip_btn);

        random = new Random();

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sides = random.nextInt(2);

                Animation fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setStartOffset(1000);
                fadeOut.setDuration(2000);

                Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setDuration(2000);

                coin.startAnimation(fadeOut);

                MediaPlayer sound = MediaPlayer.create(coin.this, R.raw.ding);

                if (sides == 1){
                    sound.start();
                    coin.setImageResource(R.drawable.coin_head);
                    coin.startAnimation(fadeIn);
                    Toast.makeText(coin.this, "It's a Head", Toast.LENGTH_SHORT).show();
                } else {
                    sound.start();
                    coin.setImageResource(R.drawable.coin_tail);
                    coin.startAnimation(fadeIn);
                    Toast.makeText(coin.this, "It's a Tail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}