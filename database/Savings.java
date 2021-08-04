package database;

public class Savings extends MainAccount {
	private static final int INTEREST = 5; // constant for interest of 5%
	// creation of constructors in order to have the user information here
	public Savings(UserInfo userInfo) {
		super(userInfo);
	}
	protected boolean withdrawable(int amountOfMoney) {
		return getAccountBalance()+INTEREST>=amountOfMoney;
	}
}
