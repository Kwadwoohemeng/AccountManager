/**
 * @author Kwadwo Ohemeng 
 * Program to review Object Oriented Programming - BankAccount.java (Programming Project 2)
 * @version 1.0
 * Date: October 16, 2020
 */

import java.util.Random;

public abstract class BankAccount implements Comparable <BankAccount>,Filter {
	private int number;
	private String owner;
	protected double balance;
	Random rand = new Random(); 
	

/** sets number,owner and balance.
 * no return value.
*/
		
	protected BankAccount(int n, String o, double b){ 
		this.number = n; this.owner = o; this.balance = b;
		}
	
/** assigns the parameters o and b to the data members owner and balance. It assigns a random integer composed of 6 digits to number.
 *no return value.
*/
	
	protected BankAccount(String o, double b){ 
		this.owner = o; this.balance = b; this.number = rand.nextInt( (10000000 - 100000) + 1 ) + 100000;
	}
	
/** gets account number
 * @return number: account number
	*/
			
public int getNumber(){ // accessor
	return number; 
	}
	
/** gets name of the account owner.
* @return owner: name of the account owner
*/
	
	public String getOwner(){ // accessor
		return owner;
		}
			
/** gets balance of the BankAccount
 * @return balance: balance of account number
	*/
	
	public double getBalance(){ // accessor
		return balance; 
		}
	
/** adds amount to the account balance
	 * no return value
		*/
			
	public void deposit(double amount){ // accessor
			balance += amount;
		}

/** subtracts an amount of money from the account
 * @return true/false if there is enough money or not
	*/

	public boolean withdraw(double amount){ // accessor
		if (balance < amount) {
			return false;
		}
		else {
		balance -= amount; 
		return true;
		}
	}

 /** printing the bank account information
 * @return output: bank account information
  */
			
	public String toString(){
		String output; 
		output = String.format("%-8d\t%-20s\t%-8.2f\t",number,owner,balance);
		return output;
	}
	
/** compares bankAccount balances
   * @param: ba: bank account being compared
  * @return 0,1,-1 depending on relation
  */

	  public int compareTo(BankAccount ba) {
	  	 if (getBalance() == ba.getBalance()){
	  		 return 0;
	  	 }
	  	 else if (getBalance() > ba.getBalance()) {
	  		 return 1;
	  	 }
	  	 else 
	  		 return -1;
	  }
	
/** compares bank account numbers
 * @param obj: object in question
 * @return eq: whether or not variables are equal.
  	*/
  
  
  public boolean equals(Object o){
	  BankAccount ba = (BankAccount) o;
	  if (getNumber() == ba.getNumber()) {
	  		 return true;
	  	 }
	  else 
	  		 return false;
}
 
  /** abstract method checking account type
   * @param: filer: string filter
  * @return 0,1,-1 depending on relation
  */

  public abstract boolean pass(String filter);
	
}//end of class
	