/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.myapp.calculator;

import java.util.function.BiFunction;

/**
 *
 * @author leon
 */
public class RunCalculation {
    public static void main(String[] args) {
        RunCalculation runCalc = new RunCalculation();
        System.out.println("Standard Class:" + runCalc.doCalc1());
        System.out.println("Anonymous Inner Class:" + runCalc.doCalc2());
        System.out.println("Lambda Expression:" + runCalc.doCalc3());
    }



    public int doCalc1() {
        Calculator calc = new AdditionCalculator();
        return calc.calculate(10, 15);
    }


    public int doCalc2() {
        Calculator calc = new Calculator() {
            public int calculate(int a, int b) {
                return a + b;
            }
        };
        return calc.calculate(10, 15);
    }


    public int doCalc3() {
        Calculator calc = (a, b) -> a + b;
        return calc.calculate(10, 15);
    }

    public int doCalc4() {
        Calculator calc = (a, b) -> {
            return new AdditionCalculator().calculate(a, b);
        };
        return calc.calculate(10, 15);
    }

    public int doCalc5() {
        Calculator calc = new AdditionCalculator()::calculate;
        return calc.calculate(10, 15);
    }

    public int doCalc6() {
        Calculator calc = RunCalculation::addition;
        return calc.calculate(10, 15);
    }

    
    public int doCalc7() {
        BiFunction<Integer, Integer, Integer> calcAddition = (a, b) -> a + b;
        calcAddition.apply(10, 15);
    }
    
    public static int addition(int a, int b) {
        return a + b;
    }
    
    
}