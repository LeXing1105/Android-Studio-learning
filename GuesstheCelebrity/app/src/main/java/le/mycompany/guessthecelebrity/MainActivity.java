package le.mycompany.guessthecelebrity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> celebURLs = new ArrayList<String>();
    ArrayList<String> celebNames = new ArrayList<String>();
    int chosenCeleb = 0;
    String[] answers = new String[4];
    int locationOfCorrectAnswer = 0;
    ImageView imageView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;

    public void celebChosen(View view){
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            Toast.makeText(getApplicationContext(),"Correct!", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Wrong! It was "+ celebNames.get(chosenCeleb),Toast.LENGTH_SHORT).show();
        }
        newQuestion();

    }



    public class ImageDownloader extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);
                return myBitmap;
            } catch(Exception e){
                e.printStackTrace();
                return null;
            }

        }
    }



    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection = null;
            try {
                url = new URL (urls[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                int data = reader.read();

                while(data != -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();
                }


                newQuestion();


                return result;



            } catch(Exception e){
                e.printStackTrace();
                return "Failed";
            }


            //Log.i("URL", urls[0]);
            //Log.i("URL", urls[1]);

        }
    }

    public void newQuestion(){
        try {

            Random rand = new Random();

            chosenCeleb = rand.nextInt(celebURLs.size());

            ImageDownloader imageTask = new ImageDownloader();

            Bitmap celebImage = imageTask.execute(celebURLs.get(chosenCeleb)).get();
            imageView.setImageBitmap(celebImage);

            locationOfCorrectAnswer = rand.nextInt(4);
            int incorrectAnswerLocation;

            for (int i = 0; i < 4; i++) {
                if (i == locationOfCorrectAnswer) {
                    answers[i] = celebNames.get(chosenCeleb);
                } else {
                    incorrectAnswerLocation = rand.nextInt(celebURLs.size());
                    while (incorrectAnswerLocation == chosenCeleb) {
                        incorrectAnswerLocation = rand.nextInt(celebURLs.size());
                    }
                    answers[i] = celebNames.get(incorrectAnswerLocation);
                }
            }
            button0.setText(answers[0]);
            button1.setText(answers[1]);
            button2.setText(answers[2]);
            button3.setText(answers[3]);
        } catch (Exception e){
            e.printStackTrace();
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView= findViewById(R.id.imageView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        DownloadTask task = new DownloadTask();

        String result = null;
        try {
            result = task.execute("https://www.thetoptens.com/greatest-celebrities/").get();

            String[] splitResult =result.split("<div class=\"i hasimage\"");

            Pattern p = Pattern.compile("src=\"(.*?)\"");    //get the url of each image
            Matcher m = p.matcher(splitResult[0]);
            while(m.find()){
                celebURLs.add(m.group(1));
                System.out.println(m.group(1));
            }

            p = Pattern.compile("img alt=\"(.*?)\"");    //get the name of the celebrity
            m = p.matcher(splitResult[0]);
            while(m.find()) {
                celebNames.add(m.group(1));
                System.out.println(m.group(1));
            }

        } catch(Exception e){
            e.printStackTrace();
        }

        Log.i("result", result);




    }
}