package com.amanda.abcalculator;
import java.util.*;

public class Main extends Calculus {

	//Currently only works for power rule and with single term derivations.
	  
	public static void main(String[]args){
		
		//Creates a scanner that takes in the entire line. 
		//bug: memory leak? //fixed by splitting into two lines.
	Scanner myScanner = new Scanner(System.in);
			myScanner.useDelimiter("\\n");

		//Asks for user input
	System.out.println("Please input expression to differentiate.");
	
		//Creates a Function object named first - a totally arbitrary name.
	String equation = myScanner.next();
    Function first = new Function(equation);
    
    	//Initializes String variable derivative as the ~mathematical~ derivative.
    String postdiff = first.derive();
	System.out.println("Derivative of "+ equation +" is "+ postdiff);
	
		//close scanner.
	myScanner.close();
	}
	
}
