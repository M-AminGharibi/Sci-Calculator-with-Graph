package com.amingharibi.calculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amingharibi.calculator.databinding.ActivityGraphBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;

import org.mariuszgromada.math.mxparser.Argument;
import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {

    private ActivityGraphBinding binding;

//    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//        @Override
//        public void onActivityResult(ActivityResult o) {
//            if (o.getResultCode() == Activity.RESULT_OK && o.getData() != null) {
//                String formula = o.getData().getStringExtra("formula");
//                binding.graphETFormula.setText(formula);
//            }
//        }
//    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGraphBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        if (intent.hasExtra("formula")) {

            String formula = intent.getStringExtra("formula");

            binding.graphETFormula.setText(formula);
        }


        binding.graphBtnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formula = binding.graphETFormula.getText().toString();
                drawGraph(formula);
            }
        });




    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1001 && resultCode == Activity.RESULT_OK && data != null) {
//            String formula = data.getStringExtra("formula");
//            binding.graphETFormula.setText(formula);
//        }
//    }

    public void drawGraph(String formula) {
        LineChart lineChart = binding.lineChart;

        // دریافت تابع وارد شده توسط کاربر
        String userExpression = formula;

        // مقادیر x و y برای رسم نمودار
        float[] xValues = new float[200];
        float[] yValues = new float[200];

        // محاسبه مقادیر x و y
        for (int i = 0; i < 200; i++) {
            double x = (i - 100) * 0.1;
            xValues[i] = (float) x;
            Expression expression = new Expression(userExpression, new Argument("x = " + x));
            yValues[i] = (float) expression.calculate();
        }

        // تنظیمات مربوط به دیتاست نمودار خطی
        LineDataSet dataSet = new LineDataSet(getEntries(xValues, yValues), userExpression);
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setLineWidth(2f);

        // تنظیمات محور y
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setAxisMinimum(-1f);

        // تنظیمات محور x
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAxisMinimum(-10f);

        // فرمت‌بندی مقادیر محور x برای اعداد منفی
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                int intValue = (int) value;
                return String.valueOf(intValue);
            }
        });

        // ایجاد دیتای نمودار خطی
        LineData lineData = new LineData(dataSet);

        // تنظیم توضیحات برای نمودار
        Description description = new Description();
        description.setText("");
        lineChart.setDescription(description);

        // قرار دادن دیتا در نمودار
        lineChart.setData(lineData);
        lineChart.invalidate();

        lineChart.setTouchEnabled(true);
        lineChart.setPinchZoom(true);
    }

    // تولید لیست داده‌ها برای نمودار خطی
    private ArrayList<Entry> getEntries(float[] xValues, float[] yValues) {
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < xValues.length; i++) {
            entries.add(new Entry(xValues[i], yValues[i]));
        }

        return entries;
    }
}
