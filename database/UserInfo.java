package database;

public class UserInfo {

	// immutable structures so they cannot be altered upon creation
	private final int bankNumber;
	private final String username;
	private final String password;	
	private final int accountBalance;
	
	// creation of a constructor
	UserInfo(int bankNumber, String username, String password, int accountBalance) {
		this.bankNumber = bankNumber;
		this.username = username;
		this.password = password;
		this.accountBalance = accountBalance;
	}
	
	// getter methods for basic functionalities of previously assigned database variables
	public int getBankNumber() {
		return bankNumber;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public String toString() {
		return "bankNumber: " + bankNumber + '\n' + "Username: " + username + '\n' + "Password: " + password + '\n' + "Account Balance: " + accountBalance;
	}
}
