package le.mycompany.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /*
    boolean bartisshowing = true;
     */

    public void fade(View view){
        Log.i("Info","view clicked");

        ImageView bartImageView = (ImageView) findViewById(R.id.bartImageView);

        ImageView  homerImageView = (ImageView)  findViewById(R.id.homerImageView);

        bartImageView.setX(-1000);

        bartImageView.animate().rotation(1800).translationXBy(1000).setDuration(2000);





























        /*if (bartisshowing){

            bartisshowing = false;

            bartImageView.animate().alpha(0).setDuration(2000);

            homerImageView.animate().alpha(1).setDuration(2000);

        }
        else {

            bartisshowing = true;
            bartImageView.animate().alpha(1).setDuration(2000);

            homerImageView.animate().alpha(0).setDuration(2000);

        }

         */




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
    }
}