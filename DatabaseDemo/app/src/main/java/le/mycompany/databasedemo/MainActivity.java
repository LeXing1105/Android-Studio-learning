package le.mycompany.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Create and define a SQL database, named 'Users'
            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            //Define the elements of database ('Name' and 'age')
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");   ///SQL CAPITAL

            //Put information into the database
            //myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Nick', 28)");
            //myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Nick', 44)");
            //myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Le Xing',25)");
            //myDatabase.execSQL("INSERT INTO newUsers (name, age) VALUES ('Yang',14)");

            myDatabase.execSQL("DELETE FROM newUsers WHERE id = 2");

            //Create a cursor to pull information from the database  指针
            Cursor c = myDatabase.rawQuery("SELECT * FROM newUsers", null);

            //Create the index of the elements
            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");


            //指针指向first one
            c.moveToFirst();

            while (!c.isAfterLast()){
                Log.i("name", c.getString(nameIndex));
                Log.i("age", c.getString(ageIndex));
                Log.i("id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }


        } catch(Exception e){
            e.printStackTrace();
        }



    }
}