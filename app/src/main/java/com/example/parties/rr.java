package com.example.parties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class rr extends AppCompatActivity {

    Button action_btn;

    TextView guide;

    ImageView gun, back;

    Random random;

    int magazine = 0 , rounds;

    boolean empty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rr);

        action_btn = findViewById(R.id.action_btn);

        back = findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(rr.this, MainActivity.class));
            }
        });

        gun = findViewById(R.id.gun);

        random = new Random();

        guide = findViewById(R.id.tv_guide);

        final Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        MediaPlayer sound = MediaPlayer.create(rr.this, R.raw.vineboom);

        MediaPlayer soundFail = MediaPlayer.create(rr.this, R.raw.bonk);

        action_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (empty == true){
                    rounds = random.nextInt(6);
                    action_btn.setText("Spin");
                    guide.setText("Tap the Gun to Shot");
                    Toast.makeText(rr.this, "Round Loaded", Toast.LENGTH_SHORT).show();
                    empty = false;
                } else {
                    magazine = random.nextInt(6);
                    Toast.makeText(rr.this, "Magazine Spun, Now Shoot", Toast.LENGTH_LONG).show();
                }
            }
        });

        gun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (empty == false){
                    if (magazine == rounds){
                        sound.start();
                        gun.startAnimation(shake);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            //deprecated in API 26
                            vibrator.vibrate(500);
                        }
                        Toast.makeText(rr.this, "BANG", Toast.LENGTH_LONG).show();
                        magazine = 0;
                        empty = true;
                        guide.setText("Magazine Empty");
                        action_btn.setText("Reload");
                    } else {
                        soundFail.start();
                        Toast.makeText(rr.this, "You're Safe, Now Pass it", Toast.LENGTH_LONG).show();
                        magazine = (magazine + 1) % 6;
                    }
                } else {
                    soundFail.start();
                    Toast.makeText(rr.this, "No Round Loaded", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}