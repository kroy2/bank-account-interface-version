package database;

public abstract class MainAccount {

	private UserInfo userInfo;
	
	// creation of a constructor linking userInfo class
	public MainAccount(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	// getter method
	public UserInfo getUserInfo() {
		return userInfo;
	}
	
	public void depositMoney(int amountOfMoney) { // need to implement
		
	}
	
	public boolean withdrawMoney(int amountOfMoney) { // need to implement
		if(withdrawable(amountOfMoney)) {
	}
		return false; 
}

	private boolean withdrawable(int amountOfMoney) {
		return userInfo.getAccountBalance()>=amountOfMoney;
	}
	public int getAccountBalance() {
		return userInfo.getAccountBalance();				
	}
	private void newBalance(int updatedAccountBalance) {
		userInfo = new UserInfo(userInfo.getName(), userInfo.getUsername(), userInfo.getPassword(), updatedAccountBalance);
	}
}
