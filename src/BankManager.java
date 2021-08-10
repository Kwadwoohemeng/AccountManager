 
/**
 * @author Kwadwo Ohemeng 
 * Program to review Object Oriented Programming - Bank.java (Programming Project 2)
 * @version 1.0
 * Date: October 16, 2020
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

	public class BankManager {
		public static void main (String[]args){
		Scanner keyboard =  new Scanner(System.in);
		Bank.monthlyfee = 20.0;
		String file = "accounts.txt";
		Bank myBank = new Bank("LEHIGH UNIVERSITY BANK","Bethlehem",500,file);
		int accountNumber = 0;
		int mA = 0;
		double depositAmount;
		double withdrawAmount;
		int operation = 0;
		int count = 0;
		String filter = " ";
		String response = " ";
		
		do {
			operation = getOperation(keyboard);
			try {
			switch(operation) {
			case 1: // manageAccount
				System.out.println("Enter account number: ");
				  accountNumber = keyboard.nextInt();
				  checkAccountNumber(accountNumber);
				  BankAccount desiredAccount = myBank.getAccount(accountNumber);
					if (desiredAccount != null) {
					do  {
					mA = manageAccount(keyboard);
					switch(mA){
					case 1://View Balance
						System.out.print("The account balance: $" );
						System.out.printf("%6.2f", desiredAccount.getBalance());
						break;
					case 2://Deposit
						System.out.println("Enter amount you wish to deposit: ");	
						depositAmount = keyboard.nextDouble();
						keyboard.nextLine();
						desiredAccount.deposit(depositAmount);
						System.out.print("New balance of account: $" );
						System.out.printf("%6.2f", desiredAccount.getBalance());
						break;
					case 3://Withdrawal
						System.out.println("Enter amount you wish to withdraw: ");
						withdrawAmount = keyboard.nextDouble();
						keyboard.nextLine();
						desiredAccount.withdraw(withdrawAmount);
						System.out.print("New balance of account: $" );
						System.out.printf("%6.2f", desiredAccount.getBalance());
						break;
					case 4:// View the monthly interest
						if ( desiredAccount instanceof  SavingsAccount ){
							SavingsAccount SA =  (SavingsAccount) (desiredAccount);
							double Interest = SA.applyMonthlyInterest();
							System.out.print("Monthly Interest = $");
							System.out.printf("%6.2f", Interest);
						}
						else 
						System.out.println("Account is not a savings account.");
						break;
					case 5:// View the current profit/loss
						if ( desiredAccount instanceof  InvestmentAccount ){
							InvestmentAccount SA =  (InvestmentAccount) (desiredAccount);
							double Profit = SA.applyRisk();
							if (Profit > 0) {
								System.out.print("Profit = $");
								System.out.printf("%6.2f", Profit);
							}
							else {
								System.out.print("Loss = $");
								System.out.printf("%6.2f", -Profit);
							}
						}
						else 
						System.out.println("Account is not an investment account.");
						break;
						}
					} while (mA !=6);
					}
					break;
		
				case 2:
					System.out.println("Bank name: LEHIGH UNIVERSITY BANK Bank branch: Bethlehem ");
					System.out.printf("%-10s\t%-8s\t%-20s\t%-7s\t\t%-10s\n","Type" ,"Account Number", "Owner","Balance","Interest/Investment Type");
					myBank.viewAllAccounts();
					break;
				case 3:
					myBank.applyMonthlyFee();
					break;
				case 4:
					myBank.sortAccounts();
					break;
				case 5:
					System.out.println("Enter enter the type of account you wish  to run the filter on (Checking, Savings, or Investment): ");
					keyboard.nextLine();
					filter = keyboard.nextLine();
					BankAccount[] filtered = myBank.filterAccounts(filter);
					if (filtered == null){
						System.out.println("No accounts found.");
					}
					else {
					System.out.println("Number of accounts found = " + filtered.length );
					System.out.println("Do you wish to see the list of accounts?");
					response = keyboard.nextLine();
					if (response.equals("yes")){
					for (int i = 0;i < filtered.length;i++) {
					System.out.println(filtered[i].toString());
						}
					}
					}
					break;
				case 6:
					myBank.saveToFile(file);
					break;
				}
			}
			catch (InvalidAccountNumber e) { // From specific to general 
				System.out.println(e.getMessage());
			}
			
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
			}
			
		} while (operation != 6);
		
		System.out.println("Exiting Program...");
		System.out.println("Thank you for using LEHIGH UNIVERSITY BANK.");
		
		}// end of main method
		
		
/** displays the menu and return the selected operation
* @param input: Scanner object to read the selected operation
* @return value entered by the user
*/
		
		public static int getOperation(Scanner input) {
			int op = 0;
			do {
				System.out.println("\nSelect an operation: ");
				System.out.println(" 1: Manage Existing Account");
				System.out.println(" 2: View all accounts");
				System.out.println(" 3: Apply Monthly Fee");
				System.out.println(" 4: Sort Accounts");
				System.out.println(" 5: Filter Accounts");
				System.out.println(" 6: Exit");
				if (input.hasNextInt()){
					op = input.nextInt();
					if (op >= 1 && op <= 6)
						break;
					else
						System.out.println("Invalid operation. Must be an integer from 1 to 6.");
				}
				else{
					input.nextLine();
					System.out.println("Invalid operation. Must be an integer.");
				}
			}
			while (true);
			return op;
		}
		
		
/** displays the menu and return the selected operation
* @param input: Scanner object to read the selected operation
* @return value entered by the user
*/

		public static int manageAccount(Scanner input) {
			int op = 0;
			do {
				System.out.println("\nSelect an operation: ");
				System.out.println(" 1: View Balance");
				System.out.println(" 2: Deposit");
				System.out.println(" 3: Withdraw");
				System.out.println(" 4: View the monthly interest (Savings account only)");
				System.out.println(" 5: View the current profit/loss (Investment account only)");
				System.out.println(" 6: Return to main menu");
				if (input.hasNextInt()){
					op = input.nextInt();
					if (op >= 1 && op <= 6)
						break;
					else
						System.out.println("Invalid operation. Must be an integer from 1 to 5.");
				}
				else{
					input.nextLine();
					System.out.println("Invalid operation. Must be an integer.");
				}
			}
			while (true);
			return op;
		}
	
/** ensures Account number is in a correct format.
* This method is an accessor.
* @param accountNumber: account number being checked
* no return value.
*/

public static void checkAccountNumber (int accountNumber ) throws InvalidAccountNumber {
	Integer An =  accountNumber;  //auto-boxing
	if (!(An >= 100000 && An <= 999999) ){
		throw new InvalidAccountNumber("Invalid Account Number. Must be a 6 - Digit number.");
	}
}


		
		
	}// end of class 


