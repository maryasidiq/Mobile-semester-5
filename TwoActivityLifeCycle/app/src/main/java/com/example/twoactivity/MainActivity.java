package com.example.twoactivity;

import android.annotation.SuppressLint;
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
 * The TwoActivities app contains two activities and sends messages (intents) between them.
 */
public class MainActivity extends AppCompatActivity {

    private TextView[] shoppingList;
    private static final int REQUEST_CODE = 1;
    private static final String SHOPPING_LIST_KEY = "shoppingList";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize TextViews
        shoppingList = new TextView[12];
        shoppingList[0] = findViewById(R.id.item1);
        shoppingList[1] = findViewById(R.id.item2);
        shoppingList[2] = findViewById(R.id.item3);
        shoppingList[3] = findViewById(R.id.item4);
        shoppingList[4] = findViewById(R.id.item5);
        shoppingList[5] = findViewById(R.id.item6);
        shoppingList[6] = findViewById(R.id.item7);
        shoppingList[7] = findViewById(R.id.item8);
        shoppingList[8] = findViewById(R.id.item9);
        shoppingList[9] = findViewById(R.id.item10);
        shoppingList[10] = findViewById(R.id.item11);
        shoppingList[11] = findViewById(R.id.item12);
        // Continue for the rest of the items...

        // Restore state if available
        if (savedInstanceState != null) {
            String[] savedList = savedInstanceState.getStringArray(SHOPPING_LIST_KEY);
            if (savedList != null) {
                for (int i = 0; i < savedList.length; i++) {
                    shoppingList[i].setText(savedList[i]);
                }
            }
        }

        // Add Item button to launch second activity
        Button addItemButton = findViewById(R.id.addItemButton);
        addItemButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
            Log.d(LOG_TAG, "masuk ke 2 ");
        });
    }

    // Handle result from second activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String selectedItem = data.getStringExtra("selectedItem");

            // Find the first empty TextView and set the selected item
            for (TextView item : shoppingList) {
                if (item.getText().toString().isEmpty()) {
                    item.setText(selectedItem);
                    break;
                }
            }
        }
    }

    // Save state on rotation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String[] currentList = new String[12];
        for (int i = 0; i < shoppingList.length; i++) {
            if (shoppingList[i] != null) {  // Tambahkan pengecekan null
                currentList[i] = shoppingList[i].getText().toString();
            } else {
                currentList[i] = "";  // Atur nilai default jika TextView null
            }
        }
        outState.putStringArray(SHOPPING_LIST_KEY, currentList);
    }
}
