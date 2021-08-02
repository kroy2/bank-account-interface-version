package database;

public class UserInfo {

	// immutable structures so they cannot be altered upon creation
	private final String name;
	private final String username;
	private final int password;	
	private final int accountBalance;
	
	// creation of a constructor
	public UserInfo(String name, String username, int password, int accountBalance) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.accountBalance = accountBalance;
	}
	
	// getter methods for basic functionalities of previously assigned database variables
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public int getPassword() {
		return password;
	}
	public int accountBalance() {
		return accountBalance;
	}
}

