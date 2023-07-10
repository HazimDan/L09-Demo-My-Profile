package sg.edu.rp.c346.id22012867.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etName, etGPA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);


    }

    @Override
    protected void onResume() {
        super.onResume();

        //Step 2a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Step 2b: Retrieve the saved data from the SharedPreferences object
        String strName = prefs.getString("name", "John");
        Float gpa = prefs.getFloat("gpa", 4);

        //Step 2c: Update the UI element with the value
        etName.setText(strName);
        etGPA.setText(String.valueOf(gpa));
    }

    @Override
    protected void onPause() {
        super.onPause();

        //Step 1a: Get the user input from EditText and store it in a variable
        String strName = etName.getText().toString();
        float gpa = Float.parseFloat(etGPA.getText().toString());

        //Step 1b: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        //Step 1c: Obtain an instance of the SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();

        //Step 1d: Add the key-value pair
        prefEdit.putString("name", strName);
        prefEdit.putFloat("gpa", gpa);

        //Step 1e: Call commit() to save the changes into SharedPreferences
        prefEdit.commit();
    }
}