package com.vinay.eyeexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 30000; // 30Sec
    private TextView aTextViewCountdown;
    private TextView aEditTextMinInput;
    private Button aButtonStartPause;
    private Button aButtonReset;
    private boolean aTimerRunning;
    private CountDownTimer mCountDownTimer;
    private long aTimeLeftInMillis = START_TIME_IN_MILLIS;
    private long aStartTimeInMillis;
    private long millisInput = 30000;
    private long aEndTime;
    // private VideoView bombView;
    private boolean isFocusTimer = true;
    Window window;

    private String TAG = "timebb";
    private TextView aExerciseName;
    private TextView aExerciseDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        setTitle("Timer");
        aExerciseName = findViewById(R.id.exercise_name);
        aExerciseDescription = findViewById(R.id.exercise_description);

        aTextViewCountdown = findViewById(R.id.tv_Countdown);
        aButtonStartPause = findViewById(R.id.bt_start);
        aButtonReset = findViewById(R.id.bt_reset);
        aEditTextMinInput = findViewById(R.id.et_input_min);
        // bombView = findViewById(R.id.virtual_view);

        aTextViewCountdown.setText("00:30");
        aButtonReset.setVisibility(View.INVISIBLE);

//        aButtonFocus = findViewById(R.id.focus_btn);
//        aButtonBreak = findViewById(R.id.break_btn);
//        color = findViewById(R.id.main_layout);

        addListenerOnStartButtonAndHandleAction();
        addListenerOnResetButtonAndHandleAction();
//        clickFocus();
//        clickBreak();
        clickedExercise();

    }

    private void clickedExercise() {
        Log.d(TAG, " clicked exercise is called ");
        Intent intent = getIntent();
        Log.d(TAG, "intent value :" + intent);
        //  String message = "Selected course is " + intent.getSerializableExtra("COURSE_SELECTED");
        FirstDataModel dataModel = (FirstDataModel) intent.getSerializableExtra("COURSE_SELECTED");
        String exercise = dataModel.getName();
        String description = dataModel.getDescription();
        aExerciseName.setText(exercise);
        aExerciseDescription.setText(description);
    }

    private void addListenerOnStartButtonAndHandleAction() {
        // One button is being used to handle start and pause action.
        aButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (aTimerRunning) {
                    pauseTimer();
                } else {
                    long timerMilliseconds = START_TIME_IN_MILLIS;
                    startTimer(timerMilliseconds);
                    //takeInputWhileStart();
                }
            }
        });
    }

//    private void takeInputWhileStart() {
//        // 1. Get user input minutes from minutes edit text
//        String input = aEditTextMinInput.getText().toString();
//        Log.d("TIMER", "input: " + input);
//        if (input.isEmpty()) {
//            String remainingMinute = formatTime(aTimeLeftInMillis);
//            aTextViewCountdown.setText(remainingMinute);
////            startTimer(aTimeLeftInMillis, true);
//        } else if (Integer.parseInt(input) > 0 && Integer.parseInt(input) <= 60) {
//            // 2. Convert user input minutes in millisecond. 1 min = 1 * 60 * 1000 milliseconds = 60000 milliseconds
//            long timerMilliseconds = Long.parseLong(String.valueOf(input)) * 60000;
//            setMinutesInCircle(input);
//            startTimer(timerMilliseconds, true);
//        } else {
//            Toast.makeText(TimerActivity.this, "Enter time between 1 to 60", Toast.LENGTH_SHORT).show();
//            return;
//        }
//    }

    private void startTimer(long millisecond) {
        //  cancelTimer();
        // constructor obj dega ,  2 fun ki defination b batao
        mCountDownTimer = new CountDownTimer(millisecond, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                aTimeLeftInMillis = millisUntilFinished;
                // Update remaining minutes in countdown timer
                aEditTextMinInput.setVisibility(View.INVISIBLE);
                //TODO
                aEditTextMinInput.setText("");

                String formattedminute = formatTime(aTimeLeftInMillis);
                aTextViewCountdown.setText(formattedminute);
            }

            @Override
            public void onFinish() {
                aTimerRunning = false;

                // aButtonStartPause.setBackgroundResource(R.drawable.ic_pause_circle_outline);
                aButtonStartPause.setText("PAUSE");

                aTimeLeftInMillis = START_TIME_IN_MILLIS;
                aButtonReset.setVisibility(View.INVISIBLE);
                // playBomb();
            }
        }.start();
//        bombView.setVisibility(View.INVISIBLE);
        closeKeyboard();
        aTimerRunning = true;
        //bombView.stopPlayback();
        //  aButtonStartPause.setBackgroundResource(R.drawable.ic_pause_circle_outline);
        aButtonStartPause.setText("PAUSE");

        aButtonReset.setVisibility(View.VISIBLE);
        // start function  return object of countdowntimer type , constructor does the same thing
    }

    private String formatTime(long millisecond) {
        // Convert milliseconds in minutes to display on UI. 1 min = 1/ 60 sec, 1 sec = 1/1000 millisecond.
        int minutes = (int) (millisecond / 1000 % 3600) / 60;
        int seconds = (int) (millisecond / 1000) % 60;
        // Format minutes to display on UI example: 15:00
        String formattedMinutes = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        return formattedMinutes;
    }

    private void setMinutesInCircle(String minutes) {
        int min = Integer.parseInt(minutes);
        // 2. Format minutes so that it looks like 15:00 instead of just 15
        String formattedTime = String.format(Locale.getDefault(), "%02d:%02d", min, 0);
        // 3. Set this value in timer circle
        aTextViewCountdown.setText(formattedTime);
    }

    private void addListenerOnResetButtonAndHandleAction() {
        aButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                aTimeLeftInMillis = START_TIME_IN_MILLIS;
                aTextViewCountdown.setText("00:30");
                aEditTextMinInput.setVisibility(View.INVISIBLE);
                aEditTextMinInput.setText("");
                // aButtonStartPause.setBackgroundResource(R.drawable.ic_play_circle_outline);
                aButtonStartPause.setText("PLAY");
                mCountDownTimer.cancel();
                aTimerRunning = false;
            }
        });
    }

//    public void playBomb() {
//        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bomb);
//        Log.d("BOMB", String.valueOf(uri));
//        bombView.setVideoURI(uri);
//        bombView.setVisibility(View.VISIBLE);
//        bombView.start();
//        bombView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//                bombView.setVisibility(bombView.INVISIBLE);
//                aTextViewCountdown.setText("25:00");
//            }
//        });
//    }

    private void pauseTimer() {
        aEditTextMinInput.setVisibility(View.INVISIBLE);
        mCountDownTimer.cancel();
        aTimerRunning = false;
        // aButtonStartPause.setBackgroundResource(R.drawable.ic_play_circle_outline);
        aButtonStartPause.setText("PLAY");
    }

    private void resetTimer() {
        aTimeLeftInMillis = aStartTimeInMillis;
        updateCountDownText();
        updateWatchInterface();

        //    aTextViewCountdown.setText(00:00:00);
    }

    private void updateCountDownText() {
        int minutes = (int) (aTimeLeftInMillis / 1000 % 3600) / 60;
        int seconds = (int) (aTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(),
                "%02d:%02d", minutes, seconds);
        aTextViewCountdown.setText(timeLeftFormatted);
    }

    private void updateWatchInterface() {
        if (aTimerRunning) {
            aEditTextMinInput.setVisibility(View.INVISIBLE);
            aButtonReset.setVisibility(View.INVISIBLE);
            //  aButtonStartPause.setBackgroundResource(R.drawable.ic_pause_circle_outline);
            aButtonStartPause.setText("PAUSE");

            aEditTextMinInput.setText(0);
        } else {
            aEditTextMinInput.setVisibility(View.VISIBLE);
            // aButtonStartPause.setBackgroundResource(R.drawable.ic_play_circle_outline);
            aButtonStartPause.setText("PLAY");

            if (aTimeLeftInMillis < 1000) {
                aButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                aButtonStartPause.setVisibility(View.VISIBLE);
            }
            if (aTimeLeftInMillis < aStartTimeInMillis) {
                aButtonReset.setVisibility(View.VISIBLE);
            } else {
                aButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void cancelTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        cancelTimer();
    }

}