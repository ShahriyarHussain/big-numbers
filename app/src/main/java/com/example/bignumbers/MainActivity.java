package com.example.bignumbers;

import static java.lang.String.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button leftButton, rightButton;
    private TextView scoreText;
    protected int left = 0, right = 0, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = findViewById(R.id.buttonLeft);
        rightButton = findViewById(R.id.buttonRight);
        scoreText = findViewById(R.id.bottomText);
        this.resetNumbers(leftButton, rightButton);

        leftButton.setOnClickListener(v -> {
            if (getLeft() > getRight()) this.setScore(this.getScore() + 1);
            else {
                this.setScore(0);
                Toast.makeText(getApplicationContext(),"Wrong !! Score Reset", Toast.LENGTH_SHORT).show();
            }
            resetNumbers(leftButton, rightButton);
        });

        rightButton.setOnClickListener(v -> {
            if (getLeft() > getRight()) {
                this.setScore(0);
                Toast.makeText(getApplicationContext(),"Wrong !! Score Reset", Toast.LENGTH_SHORT).show();
            } else this.setScore(this.getScore() + 1);
            resetNumbers(leftButton, rightButton);
        });

    }

    private void resetNumbers(Button leftButton, Button rightButton) {

        this.setLeft((int)((Math.random()) * (1000 - 1 + 1) + 1));
        this.setRight((int)((Math.random()) * (1000 - 1 + 1) + 1));

        leftButton.setText(format("%s", this.left));
        rightButton.setText(format("%s", this.right));

        if (this.getScore() > 9 && this.getScore() % 10 == 0) {
            scoreText.setTextSize(16);
            scoreText.setText(format(Locale.ENGLISH,"Congrats !! You correctly chose %d times !!", this.getScore()));
        } else {
            scoreText.setTextSize(26);
            scoreText.setText(format(Locale.ENGLISH,"Score: %d", this.getScore()));
        }
    }

    public int getLeft() { return this.left; }
    public int getRight() { return this.right; }
    public int getScore() { return score; }
    public void setRight(int right) { this.right = right; }
    public void setLeft(int left) { this.left = left; }
    public void setScore(int score) { this.score = score; }
}