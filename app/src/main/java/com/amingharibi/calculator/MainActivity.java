package com.amingharibi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView IVgraph , IVCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the buttons
        IVgraph = findViewById(R.id.main_iv_graph);
        IVCalculate = findViewById(R.id.main_iv_calcutale);

        //set On Click Listener for Graph Section
        IVgraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , GraphActivity.class);
                startActivity(intent);
            }
        });


        //set On Click Listener for Calculate Section
        IVCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , CalculateActivity.class);
                startActivity(intent);
            }
        });



    }
}