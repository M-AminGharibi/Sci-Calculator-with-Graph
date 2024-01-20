package com.amingharibi.calculator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CalculationAdapter extends ArrayAdapter<CalculationEntry> {
    private ArrayList<CalculationEntry> entries;
    private Context context;

    public CalculationAdapter(Context context, ArrayList<CalculationEntry> entries) {
        super(context, 0, entries);
        this.entries = entries;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CalculationEntry entry = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_calculation, parent, false);
        }

        TextView textViewFormula = convertView.findViewById(R.id.textViewFormula);
        TextView textViewResult = convertView.findViewById(R.id.textViewResult);

        textViewFormula.setText(entry.getFormula());
        textViewResult.setText(String.valueOf(entry.getResult()));

        return convertView;
    }
}
