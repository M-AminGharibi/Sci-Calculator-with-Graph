package com.amingharibi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ImageView IVgraph , IVCalculate;
    private Button btn_draw , btn_calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize the buttons
        IVgraph = findViewById(R.id.main_iv_graph);
        IVCalculate = findViewById(R.id.main_iv_calcutale);
        btn_draw = findViewById(R.id.main_btn_draw);
        btn_calculate = findViewById(R.id.main_btn_calculate);

        Intent intentDraw = new Intent(MainActivity.this , GraphActivity.class);
        Intent intentCal = new Intent(MainActivity.this , CalculateActivity.class);

        //set On Click Listener for Graph Button
        btn_draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentDraw);
            }
        });



        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentCal);
            }
        });






        //set On Click Listener for Graph Section
        IVgraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intentDraw);
            }
        });


        //set On Click Listener for Calculate Section
        IVCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intentCal);
            }
        });



    }
}