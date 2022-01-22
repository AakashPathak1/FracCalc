package fracCalc;

//Aakash Pathak (AakashPathak123) 
//Tested Github at home on 10/1

import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
    	@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        // TODO: Read the input from the user and call produceAnswer with an equation
    	System.out.println("Welcome to Fraction Calculator");
    	System.out.println("(Enter \"quit\" to quit the calculator)");
    	System.out.println();


    	
    	
    	System.out.println("Enter expression: ");
    	String expression = input.nextLine(); //take in input
    	
    	boolean noSpace = false; //error case
    	
		boolean hasLetters = false; //error case

   
    	
    	
    	while (!expression.equalsIgnoreCase("quit")) { //make sure user has not typed "quit"
    		
    		for (char ch : expression.toCharArray()) {
    		  if (Character.isLetter(ch)) {
    			  hasLetters = true;
//    			  System.out.println("found letters");
    		    break;
    		  }
    		}
    		
    	
    		
			if (expression.indexOf(' ') == -1) { //check if input has a space 
				noSpace = true; //checking invalid input
			} else {
				noSpace = false;
			}
    		expression += " "; //added space to be able to substring properly
    		int number = numberOfOperands(expression); //get the number of operands in the original expression
    		
    		
    		for(int i = 0; i < number - 1 && !noSpace && !hasLetters; i++) { //loop for total number of operands
    			String simpleExpression = expression.substring(0, indexOfThirdSpace(expression)); //simple expression with 2 operands
    			String restOfExpression = expression.substring(indexOfThirdSpace(expression)); //rest of expression saved for later
    			
        		String newExpression = produceAnswer(simpleExpression); //produce answer is called only with a substring of the original expression which has only 2 operands
        		
        		
        		expression = newExpression + restOfExpression; //re-join new operand and rest of expression
        	
    		}
    		
    		
    		
    		expression = expression.substring(0, expression.length() - 1); //get rid of the space at the end
    		
    		if (noSpace || hasLetters) { //checking invalid input
    			expression = "ERROR (Invalid Input)";
    		}
    		
        	System.out.println("Answer: " + expression); //print answer

    		
    		
        	System.out.println("Enter expression: ");
    		expression = input.nextLine(); //user inputs another expression
    	}
    	
    	System.out.print("Thanks for using the fraction calculator");
		
    	
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
    	
    		
    		
    		
    		
		
			int answerNumerator = 0; //for the final answer to be printed
	    	int answerDenominator = 0;
	    	int answerWholeNumber = 0;
			
	    	
			
	        // TODO: Implement this function to produce the solution to the input
	    	String first = "";  //first operand
	    	String operator = ""; //operator
	    	String second = ""; //second operand
	    	
	    	int firstNumerator = 0;
	    	int firstDenominator = 0; //all part of the first operand
	    	int firstWholeNumber = 0;
	    	
	    	int secondNumerator = 0;
	    	int secondDenominator = 0; //all part of the second operand
	    	int secondWholeNumber = 0;
	    	
	    	
	    	input = input + " "; //to make sure we can get the last character using .substring
	    	
	    	//getting the first operand, the operator and the second operand
	    	first = input.substring(0, input.indexOf(" ")); 
	    	operator = input.substring(input.indexOf(" ") + 1, input.indexOf(" ") + 2);
	    		    	
	    	if (input.charAt(input.indexOf(" ") + 2) != ' ') { //checks if user entered 1/4 ++ 3/9
	    		return "ERROR (Invalid Input)";
	    	}
	    	second = input.substring(input.indexOf(" ") + 3, input.length() - 1); 
	    	
	    	first += " "; //to make sure we can get the last character using .substring
	    	second += " ";//to make sure we can get the last character using .substring
	    	
	    	if (first.charAt(first.indexOf('/') + 1) == '/') { //check if user entered two slashes by mistake
	    		return "ERROR (Invalid Input)";
	    	}
	    	if (first.charAt(first.indexOf('_') + 1) == '_') {//check if user entered two underscores by mistake
	    		return "ERROR (Invalid Input)";
	    	}
	    	
	    	if (second.charAt(second.indexOf('/') + 1) == '/') {//check if user entered two slashes by mistake
	    		return "ERROR (Invalid Input)";
	    	}
	    	if (second.charAt(second.indexOf('_') + 1) == '_') {//check if user entered two underscores by mistake
	    		return "ERROR (Invalid Input)";
	    	}
	    	
	    	//FIRST - getting the numerator, whole number and denominator from first operand
	    	if (first.indexOf('_') != -1 && first.indexOf('/') != -1) {
	    		firstWholeNumber = Integer.parseInt(first.substring(0, first.indexOf('_')));
	    		firstNumerator = Integer.parseInt(first.substring(first.indexOf('_') + 1, first.indexOf('/')));
	    		firstDenominator = Integer.parseInt(first.substring(first.indexOf('/') + 1, first.length() - 1));
	    	} else if (first.indexOf('_') == -1 && first.indexOf('/') != -1) {
	    		firstWholeNumber = 0;
	    		firstNumerator = Integer.parseInt(first.substring(0, first.indexOf('/')));
	    		firstDenominator = Integer.parseInt(first.substring(first.indexOf('/') + 1, first.length() - 1));
	    	} else {
	    		firstWholeNumber = Integer.parseInt(first.substring(0, first.indexOf(" ")));
	    		firstNumerator = 0;
	    		firstDenominator = 1;
	    	}
	    	
//	    	System.out.println("first: " + first);
//	    	System.out.println("second: " + second);
	    	
	    	//SECOND - getting the numerator, whole number and denominator from second operand
	    	if (second.indexOf('_') != -1 && second.indexOf('/') != -1) {
	    		secondWholeNumber = Integer.parseInt(second.substring(0, second.indexOf('_')));
	    		secondNumerator = Integer.parseInt(second.substring(second.indexOf('_') + 1, second.indexOf('/')));
	    		secondDenominator = Integer.parseInt(second.substring(second.indexOf('/') + 1, second.length() - 1));
	    	} else if (second.indexOf('_') == -1 && second.indexOf('/') != -1) {
	    		secondWholeNumber = 0;
	    		secondNumerator = Integer.parseInt(second.substring(0, second.indexOf('/')));
	    		secondDenominator = Integer.parseInt(second.substring(second.indexOf('/') + 1, second.length() - 1));
	    	} else {
	    		secondWholeNumber = Integer.parseInt(second.substring(0, second.indexOf(" ")));
	    		secondNumerator = 0;
	    		secondDenominator = 1;
	    	}
	    	
	    	if (firstDenominator == 0 || secondDenominator == 0) {
	    		return "ERROR: cannot divide by zero";
	    	}
	    	
	    	
	    	
	    	if (firstNumerator > 0 && firstWholeNumber < 0) {
	    		firstNumerator *= -1;
	    	}
	    	
	    	if (secondNumerator > 0 && secondWholeNumber < 0) {
	    		secondNumerator *= -1;
	    	}
	    	
	    	//performing the calculations - covert to improper
	    	
	    	firstNumerator = firstDenominator * firstWholeNumber + firstNumerator;
	    	
	    	secondNumerator = secondDenominator * secondWholeNumber + secondNumerator;
	
	    	
	    	//performing math calculations
	    	if (operator.equals("+")) { //addition
	    		answerDenominator = firstDenominator * secondDenominator;
	    		answerNumerator = (firstNumerator * secondDenominator) + (secondNumerator * firstDenominator);
	//        	answerWholeNumber = firstWholeNumber + secondWholeNumber;
	
	    	}
	    	
	    	if (operator.equals("-")) { //subtraction 
	    		answerDenominator = firstDenominator * secondDenominator;
	    		answerNumerator = (firstNumerator * secondDenominator) - (secondNumerator * firstDenominator);
	//        	answerWholeNumber = firstWholeNumber - secondWholeNumber;
	
	    	}
	    	
	    	if (operator.equals("*")) { //multiplication
	    		answerNumerator = firstNumerator * secondNumerator;
	    		answerDenominator = firstDenominator * secondDenominator;
	//        	answerWholeNumber = firstWholeNumber * secondWholeNumber;
	
	    	}
	    	
	    	if (operator.equals("/")) { //division
	    		int placeholder = secondNumerator;
	    		secondNumerator = secondDenominator; //flipping the second fraction
	    		secondDenominator = placeholder;
	    		
	    		answerNumerator = firstNumerator * secondNumerator;
	    		answerDenominator = firstDenominator * secondDenominator; //normal multiplication code from previous if statement
	    		
	    	}
	    	
	    	if (answerDenominator < 0) {
	    		answerDenominator *= -1; //if denominator is negative, make denominator positive and numerator negative
	    		answerNumerator *= -1;
	
	    		
	    	}
	    	
	    	
	    	
	    	if (Math.abs(answerNumerator) > Math.abs(answerDenominator)) { //converting improper to mixed fraction
	    		answerWholeNumber = answerNumerator / answerDenominator;
	    		answerNumerator = Math.abs(answerNumerator - (answerWholeNumber * answerDenominator));
	    		
	    	}
	    	
	    	
	    	
	    	
	     	int min = Math.min(Math.abs(answerNumerator), Math.abs(answerDenominator)); //finding the lower number
	     	int factor = 1;
	     	
	
	
	     	
	     	for (int i = min; i > 0; i--) {
	     		if (answerNumerator % i == 0 && answerDenominator % i == 0) { //finding the greatest common factor
	     			factor = i;
	     			break;
	     		}
	     	} 
	     	
	     	
	     	answerNumerator /= factor;      //dividing to simplify
	     	answerDenominator /= factor;
     	
    	
    	
     	
     	//RETURNING THE ANSWER
     	
     	if (answerNumerator == 0) {
    		return "" + answerWholeNumber;
    	}
    	
     	if (answerWholeNumber == 0) {
     		if (answerDenominator == 1) {
         		return "" + answerNumerator;
         	}
     		return "" + answerNumerator + "/" + answerDenominator;
     	} 
     	
     	
        //returning the answer 
        return "" + answerWholeNumber + "_" + answerNumerator + "/" +  answerDenominator;
    }

    
    public static int numberOfOperands(String input) {
    	
    	int numberOfOperands = 0;
    	int numberOfSpaces = 0;
    	
    	for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ' ') {
				numberOfSpaces++;
			}
		}
		
		numberOfOperands = (numberOfSpaces / 2) + 1;
		
		return numberOfOperands;
    }
    
    public static int indexOfThirdSpace (String expression) {
    	
    	int counter = 0;
		int j;
		
		
    	for(j = 0; j < expression.length(); j++) {
			if (expression.charAt(j) == ' ') {
				counter++;
			}
			if (counter == 3) {
				break;
			}
		}
		
    	return j;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
