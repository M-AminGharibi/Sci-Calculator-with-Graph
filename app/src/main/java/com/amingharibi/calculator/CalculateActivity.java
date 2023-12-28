package com.amingharibi.calculator;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import com.amingharibi.calculator.databinding.ActivityCalculateBinding;

public class CalculateActivity extends AppCompatActivity {
    private ActivityCalculateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formula = binding.calculateEtFormula.getText().toString();
                double result = calculate(formula);
                binding.resultTextView.setText(String.valueOf(result));
            }
        });
    }

    public double calculate(String formula) {
        String inputExpression = formula;
        Expression expression = new Expression(inputExpression);
        return expression.calculate();
    }
}
