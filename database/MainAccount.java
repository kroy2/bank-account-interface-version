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
	
	// method for depositing money, calling newBalance method for updated balance
	public void depositMoney(int amountOfMoney) { 
		newBalance(getAccountBalance()+amountOfMoney);
	}
	
	// method for withdrawing money, calling newBalance method for updated balance
	public boolean withdrawMoney(int amountOfMoney) { 
		if(withdrawable(amountOfMoney)) {
			newBalance(getAccountBalance()-amountOfMoney);
			return true;
	}else {
		return false; 
}
	}

	protected boolean withdrawable(int amountOfMoney) { // protected so it can be overrided
		return getAccountBalance()>=amountOfMoney;
	}
	public int getAccountBalance() {
		return userInfo.getAccountBalance();				
	}
	private void newBalance(int updatedAccountBalance) {
		userInfo = new UserInfo(userInfo.getBankNumber(), userInfo.getUsername(), userInfo.getPassword(), updatedAccountBalance);
	}
}
