package com.miguelcr.a05_randomdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random;
    ImageView dice;
    TextView history;
    int h1=0, h2=0,h3=0,h4=0,h5=0,h6=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dice = (ImageView) findViewById(R.id.imageViewDice);
        history = (TextView) findViewById(R.id.textViewHistory);

        // Create the random object to generate random integer
        random = new Random();
    }

    public void generateRandomDice(View view) {
        int min = 1;
        int max = 6;
        int result = random.nextInt(max - min + 1) + min;

        switch (result) {
            case 1: dice.setImageResource(R.drawable.dice_1);
                h1++;
                break;
            case 2: dice.setImageResource(R.drawable.dice_2);
                h2++;
                break;
            case 3: dice.setImageResource(R.drawable.dice_3);
                h3++;
                break;
            case 4: dice.setImageResource(R.drawable.dice_4);
                h4++;
                break;
            case 5: dice.setImageResource(R.drawable.dice_5);
                h5++;
                break;
            case 6: dice.setImageResource(R.drawable.dice_6);
                h6++;
                break;
        }

        //history.setText(history.getText() + "," + result);
    }

    public void showHistory(View view) {
        Intent intentHistory = new Intent(MainActivity.this,HistoryActivity.class);
        intentHistory.putExtra("history1",h1);
        intentHistory.putExtra("history2",h2);
        intentHistory.putExtra("history3",h3);
        intentHistory.putExtra("history4",h4);
        intentHistory.putExtra("history5",h5);
        intentHistory.putExtra("history6",h6);
        startActivity(intentHistory);
    }
}
