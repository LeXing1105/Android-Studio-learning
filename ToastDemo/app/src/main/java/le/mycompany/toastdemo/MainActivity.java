package le.mycompany.toastdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void display(View view) {

        Log.i("Info", "Button Pressed!!");

        EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        Log.i("Name", nameEditText.getText().toString());

        Toast.makeText(this, "Hello "  + nameEditText.getText().toString(), Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}