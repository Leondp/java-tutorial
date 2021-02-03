/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.myapp.calculator;

/**
 *
 * @author leon
 */
public class AdditionCalculator implements Calculator {

    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
    
}
