package Database;

public abstract class Accounts {
	private AccountBalance accountBalance;

	public Accounts(AccountBalance accountBalance) {
		this.accountBalance=accountBalance;
	}
	public AccountBalance getAccountBalance() {
		return accountBalance;
	}
	
	private void newBalance(int updatedBalance) {
		accountBalance = new AccountBalance(updatedBalance);
	}
	
	public void depositMoney(int amount) {
		newBalance(getAccountBalance()+amount);
	}
	public boolean withdrawMoney(int amount) {
		if()
	}
}

