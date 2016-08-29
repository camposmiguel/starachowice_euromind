package com.example.jorge.pato;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DuckGameActivity extends AppCompatActivity {
    TextView usernameTextView, timerTextView, pointsTextView;
    CountDownTimer countDownGame;
    AlertDialog.Builder builder;
    int numKilledDucks = 0;
    ImageView duckImageView;
    Random randomXPosition, randomYPosition;
    int screenWidth, screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duck_game);

        usernameTextView = (TextView) findViewById(R.id.textViewUser);
        timerTextView = (TextView) findViewById(R.id.textViewTime);
        duckImageView = (ImageView) findViewById(R.id.imageViewDuck);
        pointsTextView = (TextView) findViewById(R.id.textViewPoints);


        // Show FullScreen (without StatusBar)
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // get Intent extra params
        Bundle extras = getIntent().getExtras();
        String username = extras.getString("username");
        usernameTextView.setText(username);

        Typeface type = Typeface.createFromAsset(getAssets(),"pixel.TTF");
        usernameTextView.setTypeface(type);

        duckImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numKilledDucks++;
                pointsTextView.setText(String.valueOf(numKilledDucks));
                generateDuckRandomPosition();
            }
        });

        startCountDownGame();

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenHeight = metrics.heightPixels;
        screenWidth = metrics.widthPixels;

    }

    private void generateDuckRandomPosition() {
        randomXPosition = new Random();
        int minX = 0;
        int maxX = screenWidth;
        int x = randomXPosition.nextInt(maxX - minX + 1) + minX;

        randomYPosition = new Random();
        int minY = 0;
        int maxY = screenHeight;
        int y = randomYPosition.nextInt(maxY - minY + 1) + minY;


        int duckImageWidth = duckImageView.getWidth();
        int duckImageHeight = duckImageView.getHeight();

        duckImageView.setX(x-duckImageWidth);
        duckImageView.setY(y-duckImageHeight);
    }

    private void startCountDownGame() {
        countDownGame = new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerTextView.setText( millisUntilFinished / 1000+"s");
            }

            public void onFinish() {
                timerTextView.setText("0s");
                showDialogGameOver();
            }
        }.start();
    }

    private void showDialogGameOver() {
        builder = new AlertDialog.Builder(DuckGameActivity.this);
        builder.setTitle("GAME OVER");
        builder.setMessage("Your final result is "+numKilledDucks+" ducks");
        builder.setPositiveButton("Play again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // All we must to reset if user wants to play again
                startCountDownGame();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.create();
        builder.show();
    }
}
