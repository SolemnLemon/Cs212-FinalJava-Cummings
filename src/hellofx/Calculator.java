/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import liststacktemplate.MyStack;
import liststacktemplate.Numeric;
import liststacktemplate.Spacer;
import liststacktemplate.Symbol;
import liststacktemplate.Value;

/**
 *
 * @author sunbe
 */
public class Calculator extends MyStack {

    public String calculate(String input) {
        inputToStack(input);
        System.out.println("Equation: " + toString());
        System.out.println("top terms points to " + getArr().getFirstTerm().getPointer().getValue().getValue());
        Integer term1 = null;
        Integer term2 = null;
        Character symbol = null;
String equation="";
        term1 = evaluateNumeric();
        
        if (!(pop() instanceof Spacer)) {
            System.out.println("you should never see this message");
        }
        term2 = evaluateNumeric();
        if (!(pop() instanceof Spacer)) {
            System.out.println("you should never see this message pt2");
        }
        symbol = pop().getValue().charAt(0);
        double answer=doMath((double)term1, (double)term2, symbol);
        equation=equation+term1+" "+symbol+" "+term2;
       while(!getArr().isEmpty()){
           
    
        if (!(pop() instanceof Spacer)) {
            System.out.println("you should never see this message pt2");
        }
        term2=evaluateNumeric();
         if (!(pop() instanceof Spacer)) {
            System.out.println("you should never see this message pt2");
        }
        symbol=pop().getValue().charAt(0);
        equation= equation+" "+symbol+" "+ term2;
      answer=doMath(answer, (double)term2, symbol);
       }
        return equation+" = "+answer;
    }

    public double doMath(double term1, double term2, char symbol) {
        switch (symbol) {
            case '+':
                return term1 + term2;
            case '-':
                return term1 - term2;
            case '/':
                return term1 / term2;
            case '*':
                return term1 * term2;
            case '^':
                return Math.pow(term1, term2);
            default:

                return 0;
        }

    }

    public int evaluateNumeric() {
        int term = 0;
        System.out.println("top of stack " + peek().getValue());
        if (peek() instanceof Numeric) {

            term = pop().getIntValue();
        }
        while (peek() instanceof Numeric) {
            term = concatonate(term, pop().getIntValue());
        }
        //negative handler
//        if (peek().getValue().charAt(0) == '-') {
        //         term = term * -1;
        //         pop();
        //     }

        return term;
    }

    public int concatonate(int a, int b) {
        String s = Integer.toString(a) + Integer.toString(b);
        return Integer.parseInt(s);
    }

    public void inputToStack(String input) {
        for (int counter = 0; counter < input.length(); counter++) {
            push(input.charAt(counter));

        }

    }

}
