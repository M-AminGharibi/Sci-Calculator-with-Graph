package com.amingharibi.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class CalculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        Button btn_calculate = findViewById(R.id.btn_calculate);
        EditText et_formula = findViewById(R.id.calculate_et_formula);
        TextView resultTextView = findViewById(R.id.resultTextView);






        btn_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formula = String.valueOf(et_formula.getText());
                double result = calculate(formula);
                resultTextView.setText(String.valueOf(result));
            }
        });


    }

    public double calculate(String formula) {

        String inputExpression = formula;
        Expression expression = new Expression(inputExpression);
        double result = expression.calculate();
        return result;


    }
}