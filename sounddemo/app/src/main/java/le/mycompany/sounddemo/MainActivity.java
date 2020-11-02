package le.mycompany.sounddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    //1. 播放音频 -> 2. 开始，暂停键 控制播放音频 -> 3.用SeekBar控制音量，根据机器的最大音量进行设置 -> 4. SeekBar显示播放进度 -> 5. 拖动SeekBar自由播放


    MediaPlayer mediaPlayer;

    AudioManager audioManager;

    public void play (View view){

        mediaPlayer.start();
    }

    public void pause(View view){

        mediaPlayer.pause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        mediaPlayer = MediaPlayer.create(this, R.raw.train);

        SeekBar volumecontrol = (SeekBar) findViewById(R.id.volumeSeekBar);

        volumecontrol.setMax(maxVolume);
        volumecontrol.setProgress(currentVolume);

        volumecontrol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Log.i("Seekbar changed",Integer.toString(progress));

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        SeekBar srcubSeekBar = (SeekBar) findViewById(R.id.srcubSeekBar);
        srcubSeekBar.setMax(mediaPlayer.getDuration());

        srcubSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("SrcubSeekbar moved", Integer.toString(progress));
                mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                srcubSeekBar.setProgress(mediaPlayer.getCurrentPosition());

            }
        }, 0,300);
    }
}