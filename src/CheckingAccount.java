/**
 * @author Kwadwo Ohemeng 
 * Program to review Object Oriented Programming - CheckingAccount.java (Programming Project 2)
 * @version 1.0
 * Date: October 16, 2020
 */

public class CheckingAccount extends BankAccount {
	
/** sets owner and balance.
*/
	   public CheckingAccount(String owner,double balance) { // default constructor
		   super(owner,balance);
		   
	   }
	   
   /** sets number, owner and balance 
*/
	   
	   public CheckingAccount(int number, String owner, double balance) { // default constructor
		   super(number,owner, balance);
	   }
	  
	/** checks type of account
    * @return true/false
  	*/
		
		public boolean pass(String filter){
			if (filter.equals("Checking")) {
				return true;
			}
			else 
				return false;
		
			}
	   
/** printing the checking account information
 * @return output: checking account information
  	*/
			
		public String toString(){
			String output = "Checking" + "\t";
			output += super.toString();
			return output;
		}
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
}// end of class
