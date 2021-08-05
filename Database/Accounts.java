package Database;

public abstract class Accounts {

	private final int balance;

	Accounts(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void depositMoney(int amount) {
		newBalance(getBalance() + amount);
	}

	protected abstract void newBalance(int i);

	public void withdrawMoney(int amount) {
		newBalance(getBalance() - amount);
	}
}
