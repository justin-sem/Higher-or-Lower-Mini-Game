package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {        //onCreate method, run code when app loaded
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateNewRandomNum();
    }

    public void guess(View view){                       // guess button function
        Log.i("Info","Guess button pressed");
        Log.i("Info",Integer.toString(n));          // from terminal can view the generated random number

        EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
        int guessedValue = Integer.parseInt(editTextNumber.getText().toString());     // convert from EditText to String then to Int
        Log.i("Info", editTextNumber.getText().toString());            // from terminal can view the number user typed in

        String toastMessage;
        if (guessedValue > n){
            toastMessage = "Guess Lower !";

        }
        else if (guessedValue < n){
            toastMessage = "Guess Higher";
        }
        else{
            toastMessage = "Congrats,you guess it! Try again!";
            generateNewRandomNum();
        }
        Toast.makeText(this,toastMessage,Toast.LENGTH_SHORT).show();
    }

    public void generateNewRandomNum(){

        Random random = new Random();
        n = random.nextInt(50) + 1;             // generate random number between 1 - 50
    }

}