package le.mycompany.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;


    public void generateRandomNumber(){
        Random rand = new Random();
        randomNumber = rand.nextInt(20)+1;

    }



    public void guess(View view){
        Log.i("Info","Button Pressed!");
        EditText editText = findViewById(R.id.editText);
        Log.i("Guess Number:", editText.getText().toString());
        Log.i("Random Number:",Integer.toString(randomNumber));

        int guessNumber = Integer.parseInt(editText.getText().toString());

        String message;
        if (guessNumber>randomNumber){
            message="greater";
        }
        else if (guessNumber<randomNumber){
            message="smaller";
        }
        else{
            message="You got it, Try again!";
            generateRandomNumber();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateRandomNumber();
    }
}