package com.amanda.abcalculator;
import java.util.*; //includes the regex class.

public class Function extends Calculus {
	
	private List<String> function;


	public Function(String original) {
		//Creates an empty ArrayList waiting to be populated by polynomials.
		function = new ArrayList<String>();
		//takes the 'original' (which is user inputted) converts to lowercase.
		String corrected = original.toLowerCase();
		
		//populates function ArrayList with polynomials as entries where the orig. are seperated by space.
		 function = Arrays.asList(corrected.split(" "));
	}
	
	
	public String derive() {
			
		//loop cycles through each polynomial
		for (int i=0; i<function.size(); i++){
			
			//Derivative of a constant. Constants do not fulfill any of the above if statements.
				if (!function.get(i).contains("x")&& !function.get(i).contains("+")){
					super.applyPowerRule(function.get(i));
					function.set(i, Calculus.getZero());
				}
			
			//Checking for power rule
				if (function.get(i).contains("x") 
						&& (!function.get(i).contains("*") 
						&& !function.get(i).contains("/") 
						&& !function.get(i).contains("(") 
						&& !function.get(i).contains(")"))) {
					//applying power rule to element
					super.applyPowerRule(function.get(i));
					function.set(i, Calculus.getDerivative());
					
				//chain rule
					
				//product rule
					
				//quotient rule
	
				}
				
			}
//returns the modified ArrayList as a string. 
		StringBuilder myStringBuilder = new StringBuilder();
		for (String x : function)
		{
			//adds entry x to myStringBuilder
		    myStringBuilder.append(x);
		    //adds space for readability
		    myStringBuilder.append(" ");
		}
		return myStringBuilder.toString();
	}
	
}
