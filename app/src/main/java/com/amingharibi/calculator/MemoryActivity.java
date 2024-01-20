package com.amingharibi.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MemoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        displayHistory();

    }

    private void displayHistory() {
        ListView listView = findViewById(R.id.listViewHistory);

        // بازیابی تاریخچه از SharedPreferences
        ArrayList<CalculationEntry> history = CalculationHistoryManager.getHistory(this);

        if (history != null) {
            CalculationAdapter adapter = new CalculationAdapter(this, history);
            listView.setAdapter(adapter);
        }
    }
}