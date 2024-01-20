package com.amingharibi.calculator;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CalculationHistoryManager {
    private static final String PREF_NAME = "CalculationHistory";
    private static final String KEY_HISTORY = "history";

    // ذخیره تاریخچه محاسبات
    public static void saveHistory(Context context, ArrayList<CalculationEntry> history) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        Gson gson = new Gson();
        String json = gson.toJson(history);

        editor.putString(KEY_HISTORY, json);
        editor.apply();
    }

    // بازیابی تاریخچه محاسبات
    public static ArrayList<CalculationEntry> getHistory(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_HISTORY, null);

        Type type = new TypeToken<ArrayList<CalculationEntry>>() {}.getType();
        return gson.fromJson(json, type);
    }


    public static void clearHistory(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}

