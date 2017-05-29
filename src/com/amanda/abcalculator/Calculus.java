package com.amanda.abcalculator;
import java.util.*;

public class Calculus {
	
	private static String derivative;
	
	public static String getDerivative() {
		return derivative;
	}

	public static void setDerivative(String derivative) {
		Calculus.derivative = derivative;
	}

	public static String getZero(){
		return "0";
	}
	
	protected static String applyPowerRule(String x) {
		
		derivative = "";
        List<String> arr = new ArrayList<String>();
        
        int num = 1;
        int power;

        String p = "";
        String coefficient = "";
        
        	//For when d/dx(x) is passed.
        if(x.contains("x") && !x.contains("^") && !x.matches(".*[0-9].*")) {
            setDerivative(getDerivative().concat("1"));
            return getDerivative();
        }
        
        //x^ product rule decomposition.
        if (x.contains("x") && !x.contains("^")) {
            arr = Arrays.asList(x.split("x"));
            //Coefficient is derivative.
            setDerivative(getDerivative().concat(arr.get(0)));
        } 
        //if the expression involves a caret, we need to use the power rule
        else if (x.contains("^")) {
          
            //no coefficient in front of the x... default value is 1
            if(x.charAt(0) == 'x'){
                //concatenates the power as a new coefficient
                for(int c = 2; c < x.length(); c++){
                    String temp = Character.toString(x.charAt(c));
                    coefficient = coefficient.concat(temp);
                }
                
                //convert the strings containing our needed numbers into integers
                num = Integer.parseInt(coefficient);
                power = Integer.parseInt(coefficient) - 1;
                
                //they are then converted back after some algebraic manipulation in order to be added to the derivative string
                String part1 = Integer.toString(num);
                String part2 = Integer.toString(power);
                
                //concatenates the new part of the derivative onto the other part of the computed derivative
                setDerivative(getDerivative().concat(part1 + "x" + "^" + part2));
                
                //once we have completed part of the derivative, we can escape from the method
                return getDerivative();
            }
            
            //otherwise, we split the string into just numbers
            arr = Arrays.asList(x.split("[x...]+[^...]"));
            
            //grabs the coefficient and the power
            for (int l = 0; l < arr.size(); l++) {

                if (l == (arr.size() - 1)) {
                    //the last number in the string is going to be the power
                    p = arr.get(l);
                } else {
                    //if there is no coefficient, the coefficient is 1...
                    if(arr.get(l) == null){
                        coefficient = coefficient.concat("1");
                    }
                    else{
                        coefficient = coefficient.concat(arr.get(l));
                    }
                }

            }
            //turns the strings into integers...
            num *= Integer.parseInt(coefficient);
            power = Integer.parseInt(p);

            //now that we have all that is needed, we compute the derivative and save it as a string and return it
            String part1 = Integer.toString(num * power);
            String part2 = Integer.toString(power - 1);

            //if the new power of the expression is one, we can omit the exponent
            if ((power - 1) == 1) {
                setDerivative(getDerivative().concat(part1 + "x"));
            //otherwise, we need to inclde the caret and its corresponding exponent
            } else {
                setDerivative(getDerivative().concat(part1 + "x" + "^" + part2));
            }
        }
		return getDerivative();

    }
	
	public static void applyChainRule(){
		
	}
	
	//public static String applyProductRule(String c){
		
	//}
	
	//public static String applyQuotientRule(String d){
		
	//}

	
}