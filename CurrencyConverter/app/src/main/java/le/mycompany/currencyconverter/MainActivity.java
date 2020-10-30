package le.mycompany.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void CurrencyConverter(View view){

        Log.i("Info","Button Pressed");

        EditText AmountInPoundEditText = (EditText) findViewById(R.id.AmountInPoundEditText);

        Log.i("Amount in Pound:", AmountInPoundEditText.getText().toString());

        String PoundAmount = AmountInPoundEditText.getText().toString();

        double PoundAmountDouble = Double.parseDouble(PoundAmount);

        double DollarAmountDouble = PoundAmountDouble * 1.3;

        String DollarAmountString = Double.toString(DollarAmountDouble);


        Toast.makeText(this, "￡"+ PoundAmount+ " is: " + "$" + DollarAmountString, Toast.LENGTH_LONG ).show();





    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}