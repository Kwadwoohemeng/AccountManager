/**
 * @author Kwadwo Ohemeng 
 * Program to review Object Oriented Programming - SavingsAccount.java (Programming Project 2)
 * @version 1.0
 * Date: October 16, 2020
 */

public class SavingsAccount extends BankAccount {
	private double yearlyInterest;
	
/** sets owner,balance and rate
*/
	   public SavingsAccount(String owner,double balance,double yi) { // default constructor
		   super(owner,balance);
		   this.yearlyInterest = yi;
		   
	   }
	   
   /** sets number, owner, balance and rate
*/
	   
	   public SavingsAccount(int number, String owner, double balance, double yi){ // default constructor
		   super(number,owner, balance);
		   this.yearlyInterest = yi;
	   }
	   
	   
   /** gets interest rate
* @return yearlyInterest: rate of interest
*/
	   
		public double getInterestRate(){
		    return yearlyInterest;
		  }
		
		
 /** sets yearly interest rate 
 * @param r: rate of interest
 */
		
		public void setInterestRate(double yi){ 
			yearlyInterest = yi;
			}
		
/** applies monthly interest fee
    * @return monthly interest
  	*/
		
		public double applyMonthlyInterest(){
			double monthlyInterest;
			monthlyInterest = (( balance * yearlyInterest) / 12 ) / 100;
			balance += monthlyInterest;
			return monthlyInterest;
			}
		
/** checks type of account
    * @return true/false
  	*/
		
		public boolean pass(String filter){
			if (filter.equals("Savings")) {
				return true;
			}
			else 
				return false;
		
			}
	   
/** printing the savings account information
 * @return output: savings account information
  	*/
			
			public String toString() {
				String output = "Savings" + "\t\t";
				output += super.toString();
				output += "\t" + yearlyInterest + "%";
				return output;
			}
	   
	   
}// end of class
