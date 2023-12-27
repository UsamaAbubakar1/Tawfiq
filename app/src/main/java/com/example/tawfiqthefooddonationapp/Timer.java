package com.example.tawfiqthefooddonationapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class Timer extends AppCompatActivity {

    private TextView textView1, textView2, textView3;
    private AppCompatButton startButton, stopButton, resetButton;
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis = 3600000; // Initial time in milliseconds (60 minutes)
    private boolean timerRunning = false; // Flag to track if the timer is running

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        textView1 = findViewById(R.id.textView_id1);
        textView2 = findViewById(R.id.textView_id2);
        textView3 = findViewById(R.id.textView_id3);

        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        resetButton = findViewById(R.id.resetButton);

        // Set initial time on TextViews
        updateCountdownText();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!timerRunning) {
                    startTimer();
                }
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                // Timer finished, you can add your code here
                // For example, display a message or perform an action
                timerRunning = false;
                startButton.setEnabled(true); // Re-enable the start button
            }
        }.start();

        timerRunning = true;
        startButton.setEnabled(false); // Disable the start button while the timer is running
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            timerRunning = false;
            startButton.setEnabled(true); // Re-enable the start button
        }
    }

    private void resetTimer() {
        stopTimer();
        timeLeftInMillis = 3600000; // Reset time to initial value (60 minutes)
        updateCountdownText();
    }

    private void updateCountdownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        textView1.setText(String.format("%02d", minutes));
        textView3.setText(String.format("%02d", seconds));
    }
}
