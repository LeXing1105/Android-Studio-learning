package le.mycompany.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number{
        int number;
        public boolean isTriangular(){
            int n=1;
            int triangular=1;
            while(number>triangular){
                triangular=n*(n+1)/2;
                n++;
            }
            if (number==triangular){
                return true;
            }
            else{
                return false;
            }
        }

        public boolean isSquare(){
            double squareRoot= Math.sqrt(number);

            if (squareRoot == Math.floor(squareRoot)){
                return true;
            }
            else{
                return false;
            }

        }

    }


    public void testNumber(View view){
        Log.i("Info", "Button pressed");

        EditText editText = (EditText) findViewById(R.id.editText);

        if (editText.getText().toString().isEmpty()){
            Toast.makeText(this, "Please enter a number:", Toast.LENGTH_LONG).show();
        }
        else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());

            String message = editText.getText().toString();
            if (myNumber.isSquare() & myNumber.isTriangular()) {
                message += " is triangular and square";
            } else if (myNumber.isTriangular()) {
                message += " is triangular ";
            } else if (myNumber.isSquare()) {
                message += " is square";
            } else {
                message += " is neither triangular or square";
            }

            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

    }













    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}