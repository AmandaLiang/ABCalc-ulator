package com.amanda.abcalculator;
import java.util.*; //includes the regex class.

public class Function extends Calculus {
	
	private List<String> function;


	public Function(String original){
		//Creates an empty ArrayList waiting to be populated by polynomials.
		function = new ArrayList<String>();
		//takes the 'original' (which is user inputted) converts to lowercase.
		String corrected = original.toLowerCase();
		
		//populates function ArrayList with polynomials as entries where the orig. are seperated by space.
		 function = Arrays.asList(corrected.split(" "));
	}
	
	
	public String derive(){
		
		//cycles through each polynomial
		for (String entry : function){
			//Checking for power rule
				if (entry.contains("x") 
						&& (!entry.contains("*") 
						&& !entry.contains("/") 
						&& !entry.contains("(") 
						&& !entry.contains(")"))) {
					//applying power rule to the entry
					super.applyPowerRule(entry);
					return Calculus.getDerivative();
				}
				//else if (entry.contains("(") && entry.contains(")")){
					//super.applyChainRule();
			//	}
				//else if (){
				//	postderivation = entry.applyProductRule();
				//}
				//else if (){
				//	postderivation = entry.applyQuotientRule();
				//}
				//return postderivation;
				//} 
	}
		//Derivative of a constant. Constants do not fulfill any of the above if statements.
		return "0";
	}
	
}
