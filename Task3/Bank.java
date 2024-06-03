package CodeSoft;

import java.util.Scanner;

public class Bank {

	public static Scanner x;
	
	class ATM{
		
		UserAccount user;
		
		ATM(UserAccount user){
			this.user = user;
		}
		
		public void startATM() {
			
			while(true) {
				System.out.println("---------------------------");
				System.out.println("Welcome to the ATM!");
	            System.out.println("1. Check Balance");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Exit");
	            System.out.println("---------------------------");
	            System.out.print("Please choose an option: ");

	            int choice = x.nextInt();
	            
	            switch(choice) {
	            	
	            	case 1:
	            		user.checkBalance();
	            		break;
	            	case 2:
	            		System.out.print("Enter the amount of deposite: ");
	            		user.deposite(x.nextDouble());
	            		break;
	            	case 3:
	            		System.out.print("Enter the amount of withdrawn: ");
	            		user.withDraw(x.nextDouble());
	            		break;
	            	case 4:
	            		System.out.println("Thank you for visit");
	            		return;
	            	default:
	            		System.out.println("Please Enter correct option");
	            }
			}
		
		}
		
	}
	public static void main(String[] args) {
		
		x = new Scanner(System.in);
		UserAccount user = new UserAccount();
		
		System.out.println("Your initial balance is 500");
//		double initial_balance = x.nextDouble(); 
		user.setInitialBalance(500);
		Bank bank = new Bank();
		ATM atm = bank.new ATM(user);
		atm.startATM();
	}
}
