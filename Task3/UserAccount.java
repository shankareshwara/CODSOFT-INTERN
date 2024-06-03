package CodeSoft;

public class UserAccount {

	private double balance;

	public void setInitialBalance(double balance) {
		if(balance >=0) {
			this.balance = balance;
		}
		else {
			System.out.println("Initial balance can't be negative . setting balance to zero.");
			this.balance = balance;
		}
	}
	
	public void deposite(double amount) {
		
		if(amount > 0) {
			this.balance += amount;
			System.out.println("successfully deposited "+amount);
		}
		else {
			System.out.println("Negative amount can't be deposite");
		}
		checkBalance();
	}
	
	public double checkBalance() {
		System.out.println("Your current bank balance is : "+balance);
		return balance;
	}
	
	public void withDraw(double amount) {
		
		if(this.balance < amount) {
			System.out.println("Insufficient balance!");
		}
		else {
			System.out.println("successfully WithDrawn "+amount);
			this.balance -= amount;
		}
		checkBalance();
	}

}
