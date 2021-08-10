/**
 * @author Kwadwo Ohemeng 
 * Program to review Object Oriented Programming - InvalidAccountNumber.java (Programming Project 2)
 * @version 1.0
 * Date: October 16, 2020
 */


import java.util.InputMismatchException;
 
public class InvalidAccountNumber extends Exception {
	/** Default constructor from Exception;
	*/
	public InvalidAccountNumber() {
		super();
	}
	
	/** Constructor
	*/
	
	public InvalidAccountNumber(String message) {
		super(message);
	}

}
