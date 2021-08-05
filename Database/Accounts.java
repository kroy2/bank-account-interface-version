package Database;

public abstract class Accounts {

// assigned balance variable that cannot be altered upon creation to be called into getter method
	private final int balance;

	Accounts(int balance) {
		this.balance = balance;
	}

// getter method set for balance to be called in for updated balance/new balance in deposit and withdraw methods
	public int getBalance() {
		return balance;
	}
// method for depositing money assigning newBalance to operation 
	public void depositMoney(int amount) {
		newBalance(getBalance() + amount);
	}
// newBalance abstract method set for updated balance in depositing and withdrawing
	protected abstract void newBalance(int i);
// method for withdrawing money assigning newBalance to operation
	public void withdrawMoney(int amount) {
		newBalance(getBalance() - amount);
		 {			
		}
	}
}
