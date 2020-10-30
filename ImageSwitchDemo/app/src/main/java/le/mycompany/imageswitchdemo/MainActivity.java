package le.mycompany.imageswitchdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void LOLswitch(View view) {

        Log.i("Info", "Switch images!!");

        ImageView image = (ImageView) findViewById(R.id.LOLimage);
        image.setImageResource(R.drawable.image2);
        image.setImageResource(R.drawable.image1);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}