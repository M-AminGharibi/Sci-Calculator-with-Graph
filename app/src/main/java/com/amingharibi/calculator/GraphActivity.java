package com.amingharibi.calculator;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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

    private LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);


        lineChart = findViewById(R.id.lineChart);

        // از کاربر دریافت تابع مثلثاتی
        String userExpression = "sin(x^2)";

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

        // وارد کردن داده‌ها به مجموعه نقاط
        LineDataSet dataSet = new LineDataSet(getEntries(xValues, yValues), userExpression);
        dataSet.setColor(Color.RED);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setLineWidth(2f);

        // تنظیم محدوده محور y برای نمایش اعداد منفی
        YAxis leftAxis = lineChart.getAxisLeft();
        leftAxis.setAxisMinimum(-1f); // محدوده محور y را از -1 تا 1 تنظیم می‌کند

        // تنظیم محور x برای نمایش اعداد منفی
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setAxisMinimum(-10f); // محدوده محور x را از -10 تا 10 تنظیم می‌کند

        // تنظیم برچسب‌های محور X بر اساس مقادیر منفی
        xAxis.setValueFormatter(new ValueFormatter() {
            @Override
            public String getAxisLabel(float value, AxisBase axis) {
                int intValue = (int) value;
                return String.valueOf(intValue);
            }
        });

        // ایجاد مجموعه داده‌ها
        LineData lineData = new LineData(dataSet);

        // قرار دادن توضیحات نمودار```java
        Description description = new Description();
        description.setText("نمودار تابع مثلثاتی");
        lineChart.setDescription(description);

        // قرار دادن مجموعه داده‌ها در نمودار
        lineChart.setData(lineData);

        // بروزرسانی نمودار
        lineChart.invalidate();

        lineChart.setTouchEnabled(true);
        lineChart.setPinchZoom(true);
    }

    private ArrayList<Entry> getEntries(float[] xValues, float[] yValues) {
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i = 0; i < xValues.length; i++) {
            entries.add(new Entry(xValues[i], yValues[i]));
        }

        return entries;
    }

}
