package com.example.timerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView timerTextView;
    private Button startButton, stopButton;
    private Handler timerHandler;

    // timer logic
    long startTime = 0L;
    long updateTime = 0L;
    long timeSwapBufferTimer = 0L;
    long timeInMilliseconds = 0L;
    final long delayTimer = 0L;

    boolean isTimerStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // --INIT UI
        timerTextView = (TextView)findViewById(R.id.timer_textview_placeholder);
        startButton = (Button)findViewById(R.id.start_button);
        stopButton = (Button)findViewById(R.id.stop_button);

        // register buttons for tap events
        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

        // create handler
        timerHandler = new Handler();



    }

    @Override
    public void onClick(View v) {

        //handle event for start button and stop button
        int id = v.getId();

        switch (id){

            case R.id.start_button:
                // start timer

                if(isTimerStarted){
                    // pause button
                    startButton.setText("Start");
                    timeSwapBufferTimer += timeInMilliseconds;
                    timerHandler.removeCallbacks(updateTimer);
                    isTimerStarted = !isTimerStarted;

                }else{
                    startButton.setText("Pause");
                    startTime = SystemClock.uptimeMillis();
                    timerHandler.postDelayed(updateTimer, delayTimer);
                    isTimerStarted = !isTimerStarted;
                }

                break;

            case R.id.stop_button:
                // stop timer



                break;

            default:
                break;

        }

    }
    Runnable updateTimer = new Runnable() {
        @Override
        public void run() {

            // create timer

            // calculate min, sec, millisec

            // update textview timer

            // continue timer


        }
    };
}