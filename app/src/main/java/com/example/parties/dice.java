package com.example.parties;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class dice extends AppCompatActivity {

    ImageView dice1, dice2, dice3, back;

    Button roll1,roll2,roll3;

    Random random;

    int temp, val1, val2, val3, total;

    private int rollDice(){
        random = new Random();
        temp = random.nextInt(6) + 1;

        return temp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        back = findViewById(R.id.back_icon);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dice.this, MainActivity.class));
            }
        });

        dice1 = findViewById(R.id.iv_dice1);
        dice2 = findViewById(R.id.iv_dice2);
        dice3 = findViewById(R.id.iv_dice3);

        dice2.setVisibility(View.GONE);
        dice3.setVisibility(View.GONE);

        roll1 = findViewById(R.id.roll_btn1);
        roll2 = findViewById(R.id.roll_btn2);
        roll3 = findViewById(R.id.roll_btn3);

        Animation fadeOut = new AlphaAnimation(1, 0);
        fadeOut.setStartOffset(1000);
        fadeOut.setDuration(1000);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000);

        MediaPlayer sound = MediaPlayer.create(dice.this, R.raw.bong);

        roll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice2.setVisibility(View.GONE);
                dice3.setVisibility(View.GONE);
                temp = rollDice();
                dice1.startAnimation(fadeOut);
                if (temp == 1){
                    dice1.setImageResource(R.drawable.dice_1);
                    val1 = 1;
                }else if(temp == 2){
                    dice1.setImageResource(R.drawable.dice_2);
                    val1 = 2;
                }else if(temp == 3){
                    dice1.setImageResource(R.drawable.dice_3);
                    val1 = 3;
                }else if(temp == 4){
                    dice1.setImageResource(R.drawable.dice_4);
                    val1 = 4;
                }else if(temp == 5){
                    dice1.setImageResource(R.drawable.dice_5);
                    val1 = 5;
                }else if(temp == 6){
                    dice1.setImageResource(R.drawable.dice_6);
                    val1 = 6;
                }
                dice1.startAnimation(fadeIn);
                sound.start();
                total = val1;
                Toast.makeText(dice.this, "Dice rolled " + String.valueOf(total), Toast.LENGTH_LONG).show();
            }
        });

        roll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice2.setVisibility(View.VISIBLE);
                dice3.setVisibility(View.GONE);
                temp = rollDice();
                dice1.startAnimation(fadeOut);
                dice2.startAnimation(fadeOut);
                if (temp == 1){
                    dice1.setImageResource(R.drawable.dice_1);
                    val1 = 1;
                }else if(temp == 2){
                    dice1.setImageResource(R.drawable.dice_2);
                    val1 = 2;
                }else if(temp == 3){
                    dice1.setImageResource(R.drawable.dice_3);
                    val1 = 3;
                }else if(temp == 4){
                    dice1.setImageResource(R.drawable.dice_4);
                    val1 = 4;
                }else if(temp == 5){
                    dice1.setImageResource(R.drawable.dice_5);
                    val1 = 5;
                }else if(temp == 6){
                    dice1.setImageResource(R.drawable.dice_6);
                    val1 = 6;
                }
                temp = rollDice();
                if (temp == 1){
                    dice2.setImageResource(R.drawable.dice_1);
                    val2 = 1;
                }else if(temp == 2){
                    dice2.setImageResource(R.drawable.dice_2);
                    val2 = 2;
                }else if(temp == 3){
                    dice2.setImageResource(R.drawable.dice_3);
                    val2 = 3;
                }else if(temp == 4){
                    dice2.setImageResource(R.drawable.dice_4);
                    val2 = 4;
                }else if(temp == 5){
                    dice2.setImageResource(R.drawable.dice_5);
                    val2 = 5;
                }else if(temp == 6){
                    dice2.setImageResource(R.drawable.dice_6);
                    val2 = 6;
                }
                sound.start();
                dice1.startAnimation(fadeIn);
                dice2.startAnimation(fadeIn);
                total = val1 + val2;
                Toast.makeText(dice.this, "Dice rolled " + String.valueOf(total), Toast.LENGTH_LONG).show();
            }
        });

        roll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dice2.setVisibility(View.VISIBLE);
                dice3.setVisibility(View.VISIBLE);
                dice1.startAnimation(fadeOut);
                dice2.startAnimation(fadeOut);
                dice3.startAnimation(fadeOut);
                temp = rollDice();
                if (temp == 1){
                    dice1.setImageResource(R.drawable.dice_1);
                    val1 = 1;
                }else if(temp == 2){
                    dice1.setImageResource(R.drawable.dice_2);
                    val1 = 2;
                }else if(temp == 3){
                    dice1.setImageResource(R.drawable.dice_3);
                    val1 = 3;
                }else if(temp == 4){
                    dice1.setImageResource(R.drawable.dice_4);
                    val1 = 4;
                }else if(temp == 5){
                    dice1.setImageResource(R.drawable.dice_5);
                    val1 = 5;
                }else if(temp == 6){
                    dice1.setImageResource(R.drawable.dice_6);
                    val1 = 6;
                }
                temp = rollDice();
                if (temp == 1){
                    dice2.setImageResource(R.drawable.dice_1);
                    val2 = 1;
                }else if(temp == 2){
                    dice2.setImageResource(R.drawable.dice_2);
                    val2 = 2;
                }else if(temp == 3){
                    dice2.setImageResource(R.drawable.dice_3);
                    val2 = 3;
                }else if(temp == 4){
                    dice2.setImageResource(R.drawable.dice_4);
                    val2 = 4;
                }else if(temp == 5){
                    dice2.setImageResource(R.drawable.dice_5);
                    val2 = 5;
                }else if(temp == 6){
                    dice2.setImageResource(R.drawable.dice_6);
                    val2 = 6;
                }
                temp = rollDice();
                if (temp == 1){
                    dice3.setImageResource(R.drawable.dice_1);
                    val3 = 1;
                }else if(temp == 2){
                    dice3.setImageResource(R.drawable.dice_2);
                    val3 = 2;
                }else if(temp == 3){
                    dice3.setImageResource(R.drawable.dice_3);
                    val3 = 3;
                }else if(temp == 4){
                    dice3.setImageResource(R.drawable.dice_4);
                    val3 = 4;
                }else if(temp == 5){
                    dice3.setImageResource(R.drawable.dice_5);
                    val3 = 5;
                }else if(temp == 6){
                    dice3.setImageResource(R.drawable.dice_6);
                    val3 = 6;
                }
                sound.start();
                dice1.startAnimation(fadeIn);
                dice2.startAnimation(fadeIn);
                dice3.startAnimation(fadeIn);
                total = val1 + val2 + val3;
                Toast.makeText(dice.this, "Dice rolled " + String.valueOf(total), Toast.LENGTH_LONG).show();
            }
        });
    }
}