package com.amingharibi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ImageView IVgraph , IVCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IVgraph = findViewById(R.id.IVgraph);
        Intent intent = new Intent(MainActivity.this , GraphActivity.class);
        startActivity(intent);


    }
}