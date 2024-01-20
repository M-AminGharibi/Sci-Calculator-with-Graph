package com.amingharibi.calculator;

public class CalculationEntry {
    private String formula;
    private double result;

    public CalculationEntry(String formula, double result) {
        this.formula = formula;
        this.result = result;
    }


    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
