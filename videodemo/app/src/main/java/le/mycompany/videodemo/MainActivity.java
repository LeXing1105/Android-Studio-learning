package le.mycompany.videodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        videoView.setVideoPath("android.resource://"+ getPackageName() + "/" +R.raw.tedtalk);

        videoView.start();

        MediaController mediaController = new MediaController(this);

        mediaController.setMediaPlayer(videoView);

        videoView.setMediaController(mediaController);

        videoView.start();


    }
}