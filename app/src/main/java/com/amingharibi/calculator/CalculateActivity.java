package com.amingharibi.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.amingharibi.calculator.databinding.ActivityCalculateBinding;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;

public class CalculateActivity extends AppCompatActivity {
    private ActivityCalculateBinding binding;
    private ArrayList<CalculationEntry> history;

    double result;
    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalculateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        history = CalculationHistoryManager.getHistory(this);

        binding.b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "0";
                binding.calculateEtFormula.setText(set);
            }
        });

        binding.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "1";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "2";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "3";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "4";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "5";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "6";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "7";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "8";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "9";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + ".";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "+";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "/";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bbrac1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "(";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bbrac2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + ")";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bpi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "3.142";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bsin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "sin";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bcos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "cos";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.btan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "tan";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.binv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "^" + "(-1)";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "ln";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String set = binding.calculateEtFormula.getText() + "log";
                binding.calculateEtFormula.setText(set);

            }
        });

        binding.bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = binding.calculateEtFormula.getText().toString();
                if (str.equals("")) {
                    binding.calculateEtFormula.setText("-");
                } else if (!String.valueOf(str.charAt(str.length() - 1)).equals("-")) {
                    binding.calculateEtFormula.setText(str + "-");
                }

            }
        });

        binding.bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = binding.calculateEtFormula.getText().toString();
                if (str.equals("")) {
                    binding.calculateEtFormula.setText("*");
                } else if (!String.valueOf(str.charAt(str.length() - 1)).equals("*")) {
                    binding.calculateEtFormula.setText(str + "*");
                }

            }
        });

        binding.bsqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String set = binding.calculateEtFormula.getText() + "√";
                binding.calculateEtFormula.setText(set);

            }
        });

        binding.bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.calculateEtFormula.setText("");
                binding.resultTextView.setText("");

            }
        });
        binding.bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = binding.calculateEtFormula.getText().toString();
                if (!str.equals("")) {
                    str = str.substring(0, str.length() - 1);
                    binding.calculateEtFormula.setText(str);
                }
            }
        });
        binding.bsquare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String set = binding.calculateEtFormula.getText() + "^" + "2";
                binding.calculateEtFormula.setText(set);
            }
        });
        binding.bfact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String set = binding.calculateEtFormula.getText() + "!";
                binding.calculateEtFormula.setText(set);
            }
        });

        binding.draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formula = binding.calculateEtFormula.getText().toString();
                Intent intent = new Intent(CalculateActivity.this, GraphActivity.class);
                intent.putExtra("formula", formula);
                startActivity(intent);
//                setResult(Activity.RESULT_OK, intent);
//                startForResult.launch(intent);
//                finish();

            }
        });

        binding.memoryshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculateActivity.this, MemoryActivity.class);
                startActivity(intent);
                // displayHistory();

            }
        });

        binding.memoryclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalculationHistoryManager.clearHistory(CalculateActivity.this);


            }
        });

        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String formula = binding.calculateEtFormula.getText().toString();
                result = calculate(formula);
                binding.resultTextView.setText(String.valueOf(result));
            }
        });


        binding.memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!binding.resultTextView.getText().equals("")) {
                    String formula = binding.calculateEtFormula.getText().toString();
                    // double result = calculate(formula);

                    // اضافه کردن محاسبه جدید به تاریخچه
                    ArrayList<CalculationEntry> history = CalculationHistoryManager.getHistory(CalculateActivity.this);
                    if (history == null) {
                        history = new ArrayList<>();
                    }
                    history.add(new CalculationEntry(formula, result));
                    CalculationHistoryManager.saveHistory(CalculateActivity.this, history);

                    // نمایش پیام موفقیت
                    Toast.makeText(CalculateActivity.this, "تاریخچه با موفقیت ذخیره شد.", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    public double calculate(String formula) {
        String inputExpression = formula;
        Expression expression = new Expression(inputExpression);
        return expression.calculate();
    }
}
