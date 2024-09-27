package com.example.twoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi tombol
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        // Set onClickListener untuk setiap tombol
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teks1 = getString(R.string.teks1);
                openSecondActivity(teks1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teks2 = getString(R.string.teks2);
                openSecondActivity(teks2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String teks3 = getString(R.string.teks3);
                openSecondActivity(teks3);
            }
        });
    }

    // Method untuk membuka Activity kedua dan mengirim teks
    private void openSecondActivity(String text) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("text_key", text);
        startActivity(intent);
    }
}
