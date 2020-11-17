package le.mycompany.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("le.mycompany.sharedpreference", Context.MODE_PRIVATE);

        //sharedPreferences.edit().putString("username","Xing").apply();

        //String username = sharedPreferences.getString("username","");

        //Log.i("this is the username", username);

        /*
        ArrayList<String> friends = new ArrayList<String>();

        friends.add("Le");
        friends.add("Xing");
        friends.add("Yang");

        try {
            sharedPreferences.edit().putString("friends", ObjectSerializer.serialize(friends)).apply();
            Log.i("friends", ObjectSerializer.serialize(friends));
        } catch (Exception e){
            e.printStackTrace();
        }
        */

        ArrayList<String> newFriends = new ArrayList<>();
        try {
            newFriends = (ArrayList<String>) ObjectSerializer.deserialize(sharedPreferences.getString("friends",ObjectSerializer.serialize(new ArrayList<String>())));
        } catch(Exception e){
            e.printStackTrace();
        }

        Log.i("new Friends", newFriends.toString());
    }

}