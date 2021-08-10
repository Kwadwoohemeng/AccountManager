import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Kwadwo Ohemeng 
 * Program to review Object Oriented Programming - Bank.java (Programming Project 2)
 * @version 1.0
 * Date: October 16, 2020
 */

public class Bank{
	private String name;
	private String branch;
	private BankAccount[] bankAccounts;
	public static double monthlyfee;
	private int accounts;

/** sets name and branch and creates an array of 10 bankAccount elements and sets accounts to 0.
 * no return value
*/
			
	public Bank(String name,String branch){ // Default Constructor
		this.name = name; this.branch = branch; 
		bankAccounts = new BankAccount [10]; 
		accounts = 0;
		}
		
/** sets name to name, branch to branch, creates an array of 10 bankAccount elements and sets accounts to 0.
 * no return value
	*/
	
	public Bank(String name, String branch,int capacity, String filename){ // Constructor
		   this.name = name; this.branch = branch; 
		   bankAccounts = new BankAccount [capacity];
		   accounts = 0;
		   readFile(filename);
	}

/** reads information from a desired text file
 * This method is a mutator.
 * @param: filename: name of desired text file
 * no return value.
	*/
	
	private void readFile(String filename){
		
		File file = new File(filename);
		Scanner readFile = null;
		try {
			readFile =  new Scanner(file);
			}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			System.exit(0);
		}
		
		while (readFile.hasNext()){//  only change things that follow in here
				String type = readFile.next();
				String owner = readFile.next();
				int number = readFile.nextInt();
				double balance = readFile.nextDouble();
			if (type.equals("Savings")) {
				double interestRate = readFile.nextDouble();
				bankAccounts[accounts] = new SavingsAccount(number,owner,balance,interestRate);
				accounts++;
			}
			else if(type.equals("Investment")){
				String iType = readFile.next();
				bankAccounts[accounts] = new InvestmentAccount(number,owner,balance,iType);
				accounts++;
			}
			else {
			bankAccounts[accounts] = new CheckingAccount(number,owner,balance);
			accounts++;
			}
		}
		readFile.close();
		
	}
	
/** Allows data to be written to the a file
* This method is a mutator.
* @param filename: name of file to be written to.
* no return value.
*/

	public void saveToFile(String filename){ 
		File file = new File (filename);
		PrintWriter writeFile = null;
		try {
			 writeFile = new PrintWriter(file); 
		}
		catch (FileNotFoundException e){
			
		}
		for (int i = 0; i < accounts; i++) {// change here if anything
			if (bankAccounts[i] instanceof CheckingAccount) {
				writeFile.println("Checking "+ bankAccounts[i].getOwner() + " " + bankAccounts[i].getNumber() + " " + bankAccounts[i].getBalance());
			}
			else if (bankAccounts[i] instanceof SavingsAccount) {
				writeFile.println("Savings "+ bankAccounts[i].getOwner() + " " + bankAccounts[i].getNumber() + " " + bankAccounts[i].getBalance() + " " + ((SavingsAccount) bankAccounts[i]).getInterestRate());
			}
			else if (bankAccounts[i] instanceof InvestmentAccount) {
				writeFile.println("Investment "+ bankAccounts[i].getOwner() + " " + bankAccounts[i].getNumber() + " " + bankAccounts[i].getBalance() + " " + ((InvestmentAccount) bankAccounts[i]).getType());
			}
		}
		writeFile.close();// close or nothing will be written into the file.
	}
	
/** Deducts the value of the static member monthlyFee from the balance of all the bank accounts
 * no return value
	*/
			public void applyMonthlyFee(){ 
				for (int i = 0; i < accounts; i++){
					bankAccounts[i].withdraw(monthlyfee); 
						}
				}

/** returns reference to object account
 * @param number: account number to be looked for
 * @return bankaccounts[number] or null: desired account number.
	*/
		
	public BankAccount getAccount(int number){
		for (int i = 0; i< accounts; i++){
			if ( bankAccounts[i].getNumber() == number) {
				return bankAccounts[i];
			}
		}
				System.out.println("Account not found.");
		return null;
}
		
/** prints out all existing accounts
 * This method is an accessor.
 * no parameter values.
 * no return values.
	*/
			
	public void viewAllAccounts(){
		for (int i = 0; i< accounts ; i++){
		System.out.println(bankAccounts[i].toString()); 		
		}			
	}
			
/** filters all existing accounts
 * This method is an accessor.
 * @param filter: type of account
 * @return finalFilter: filtered bank account array
	*/
		
		public BankAccount[] filterAccounts(String filter){
			int index = 0;
			BankAccount[] Filter = new BankAccount[accounts];
			for (int i = 0; i< accounts ; i++){
				if (bankAccounts[i].pass(filter)){
					Filter[index] = bankAccounts[i];
					index++;
					}
				}
			if (index == 0) {
				return null;
			}
			BankAccount[]finalFilter = new BankAccount[index];
			for (int i = 0; i< index ; i++){
					finalFilter[i] = Filter[i];
				}
			return finalFilter;
}
		
/** sorts accounts in account array.
 * This method is an accessor.
 * no parameter values.
 * no return values.
	*/
				
	public void sortAccounts(){
		java.util.Arrays.sort(bankAccounts);
		
}
	
}//end of class