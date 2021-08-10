/**
 * @author Kwadwo Ohemeng 
 * Program to review Object Oriented Programming - InvestmentAccount.java (Programming Project 2)
 * @version 1.0
 * Date: October 16, 2020
 */
import java.lang.Math;

public class InvestmentAccount extends BankAccount {
	private String type;
	
/** sets owner,balance and type
*/
	   public InvestmentAccount(String owner,double balance,String type ) { // default constructor
		   super(owner,balance);
		   this.type = type;
		   
	   }
	   
   /** sets number, owner, balance and type
*/
	   
	   public InvestmentAccount(int number, String owner, double balance, String type) { // default constructor
		   super(number,owner, balance);
		   this.type = type;
	   }
	 
	   
   /** gets type of investment
* @return type: type of investment
*/
	   
		public String getType(){
		    return type;
		  }
		
		
 /** sets type of investment
 * @param t: type of investment
 */
		
		public void setType(String t){ 
			type = t;
			}
		
/** applies monthly interest fee
    * @return monthly interest
  	*/
		
	public double applyRisk(){
		double risk = Math.random();
		double rate = Math.random();
		double profitLoss;
		if (risk > 0.5) {
			profitLoss = ( balance * rate ) / 100;
		}
		else {
			profitLoss = - ( balance * rate) / 100;	
		}
			balance += profitLoss;
			return profitLoss;
		}
		

/** checks type of account
    * @return true/false
  	*/
		
		public boolean pass(String filter){
			if (filter.equals("Investment")) {
				return true;
			}
			else 
				return false;
		
			}
	   
/** printing the investment account information
 * @return output: investment account information
  	*/
			
			public String toString(){
				String output = "Investment" + "\t";
				output += super.toString();
				output += "\t" + type;
				return output;
			}
	   
	   
}// end of class
