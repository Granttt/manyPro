package com.hit.demo;

public class FormulaImpl implements Formula{

    @Override
    public double calculate(int a) {
        return sqrt(a * 100);
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Formula formula=new FormulaImpl();
        System.out.println(formula.calculate(100));
        System.out.print(formula.sqrt(16));

    }


}
