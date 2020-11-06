package le.mycompany.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView countdownTextView;
    SeekBar timerSeekBar;

    Boolean counterIsActive =false;
    Button startButton;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        countdownTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        startButton.setText("Start");
        counterIsActive = false;

    }


    public void startTiming (View view){

        if (counterIsActive){
            resetTimer();
        }

        else{


        counterIsActive = true;
        timerSeekBar.setEnabled(false);
        startButton.setText("STOP!");


        //create a countdown timer, timerSeekBar.getProgress()调用用户输入的时间作为初始time, 1000 ms =1 s
        countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 +100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished / 1000);  //long的数据类型转换为int
            }

            @Override
            public void onFinish() {
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.doorbell);
                mediaPlayer.start();
                resetTimer();

            }
        }.start();

        }
    }

    //创建一个新的函数 updateTimer == f(x), 参数给定为secondsLeft
    public void updateTimer(int secondsLeft){
        int minutes = secondsLeft/60;
        int seconds = secondsLeft - minutes*60;

        String secondsString = Integer.toString(seconds);

        if (seconds <=9){
            secondsString ="0" + secondsString;
        }

        countdownTextView.setText(Integer.toString(minutes) + ":" + secondsString);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get access to Seekbar textview button
        timerSeekBar = findViewById(R.id.timerSeekBar);
        countdownTextView = findViewById(R.id.countdownTextView);
        startButton = findViewById(R.id.startButton);


        timerSeekBar.setMax(600);   //seekbar 设置最大值为600
        timerSeekBar.setProgress(30);  //seekbar初始位置为30


        //Seekbar Listener用来拖动Seekbar并且加入功能
        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);  //progress指的是seekbar实时的位置， 这里调用updateTimer函数，给定参数progress；
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





    }
}