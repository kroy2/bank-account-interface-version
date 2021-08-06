package Database;

public class Accounts {

	private final double balance;
// creation of balance object
	public Accounts(double balance) {
		this.balance = balance;
	}
// method for balance to be called in later operation
	public double getBalance() {
		return balance;
	}
// method for money deposit, calling getBalance in operation to new updated balance
	public void depositMoney(int amount) {
		newBalance(getBalance() + amount);
	}
// newBalance to be called in withdrawal and deposit operations for updated balance
	protected void newBalance(double d) {
	}
// method for money withdrawal, calling getBalance in operation to new updated balance
	public void withdrawMoney(int amount) {
		newBalance(getBalance() - amount);
	}
}
