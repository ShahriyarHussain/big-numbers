package com.example.bignumbers;

import static java.lang.String.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected Button leftButton, rightButton;
    protected TextView scoreText;
    private int left = 0, right = 0, score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftButton = findViewById(R.id.buttonLeft);
        rightButton = findViewById(R.id.buttonRight);
        scoreText = findViewById(R.id.bottomText);
        this.resetNumbers(leftButton, rightButton);

//        scoreText.setText(score);

        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getLeft() > getRight()) score++;
                else score--;
                resetNumbers(leftButton, rightButton);
            }
        });

        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getLeft() > getRight()) score--;
                else score++;
                resetNumbers(leftButton, rightButton);
            }
        });

    }

    private void resetNumbers(Button leftButton, Button rightButton) {

        if (this.getScore() > 9) this.setScore(0);

        this.setLeft((int)((Math.random()) * (1000 - 1 + 1) + 1));
        this.setRight((int)((Math.random()) * (1000 - 1 + 1) + 1));

        leftButton.setText(
                format("%s", this.left));
        rightButton.setText(
                format("%s", this.right));

        scoreText.setText(format("Score: %d", this.getScore()));
    }

    public int getLeft() {
        return this.left;
    }
    public int getRight() {
        return this.right;
    }
    public int getScore() { return score; }

    public void setRight(int right) {
        this.right = right;
    }
    public void setLeft(int left) {
        this.left = left;
    }
    public void setScore(int score) { this.score = score; }
}