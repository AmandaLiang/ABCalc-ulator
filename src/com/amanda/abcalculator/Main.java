package com.amanda.abcalculator;
import java.util.*;

//importing JS.
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class Main extends Calculus {

	//Currently only works for power rule and with single term derivations. 
	public static void main(String[]args) {
		
			//Creates a scanner that takes in the entire line. 
			//bug: memory leak? //fixed by splitting into two lines.
		Scanner myScanner = new Scanner(System.in);
		myScanner.useDelimiter("\\n");

			//Asks for user input
		System.out.println("Please input expression to differentiate.");
	
			//Creates a Function object named first - a totally arbitrary name.
		String equation = myScanner.next();
    	Function first = new Function(equation);
    
    	//Readability
    	System.out.println();
    	
    		//Initializes String variable derivative as the ~mathematical~ derivative.
    	String postdiff = first.derive();
		System.out.println("Derivative of "+ equation +" is "+ postdiff);
	
			//parses with js engine in order to simplify
		postdiff.replaceAll("\\s+","");
		ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");
	    
	    if (!postdiff.contains("x")){
	    System.out.println("Which simplifies into:");
	    try {
			System.out.println(engine.eval(postdiff));
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }
	    else {System.out.println("Which simplifies into:");
	    	System.out.println(postdiff);}
	    
	    //Readability, adds new line
	    System.out.println();
	    
	    System.out.println("Do you have another expression to differentiate? (Y/N)");
	    if (myScanner.next().equalsIgnoreCase("yes")) {
	    	
	    	//Readability, adds new line
	    	System.out.println();
	    	main(args);
	    }
	    else{
	    	myScanner.close();
	    }
	}
}
