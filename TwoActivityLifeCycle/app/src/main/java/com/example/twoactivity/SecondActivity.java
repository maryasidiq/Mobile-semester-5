
package com.example.twoactivity;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * SecondActivity defines the second activity in the app. It is launched from an intent
 * with a message, and sends an intent back with a second message.
 */
public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         // Pastikan ini bukan null


        // Set up buttons for common items
        // Inisialisasi tombol dari layout XML
        Button cheeseButton = findViewById(R.id.cheeseButton);
        Button riceButton = findViewById(R.id.riceButton);
        Button applesButton = findViewById(R.id.applesButton);
        Button watermelonButton = findViewById(R.id.watermelonButton);
        Button waterButton = findViewById(R.id.waterButton);
        Button meatballButton = findViewById(R.id.meatballButton);
        Button chickenButton = findViewById(R.id.chickenButton);
        Button catfishButton = findViewById(R.id.catfishButton);
        Button snackButton = findViewById(R.id.snackButton);
        Button avocadoButton = findViewById(R.id.avocadoButton);
        Button dimsumButton = findViewById(R.id.dimsumButton);
        Button orogButton = findViewById(R.id.orogButton);

        Log.d(LOG_TAG, "Start");

// Set click listeners untuk masing-masing tombol
        cheeseButton.setOnClickListener(v -> selectItem("Cheese"));
        riceButton.setOnClickListener(v -> selectItem("Rice"));
        applesButton.setOnClickListener(v -> selectItem("Apples"));
        watermelonButton.setOnClickListener(v -> selectItem("Watermelon"));
        waterButton.setOnClickListener(v -> selectItem("Water"));
        meatballButton.setOnClickListener(v -> selectItem("Meatball"));
        chickenButton.setOnClickListener(v -> selectItem("Chicken"));
        catfishButton.setOnClickListener(v -> selectItem("Catfish"));
        snackButton.setOnClickListener(v -> selectItem("Snack"));
        avocadoButton.setOnClickListener(v -> selectItem("Avocado"));
        dimsumButton.setOnClickListener(v -> selectItem("Dimsum"));
        orogButton.setOnClickListener(v -> selectItem("Orog-Orog"));

        Log.d(LOG_TAG, "End");

    }

    private void selectItem(String item) {
        Log.d(LOG_TAG, "Start2");
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedItem", item);
        setResult(RESULT_OK, resultIntent);
        finish();
        Log.d(LOG_TAG, "end2");
    }
}
