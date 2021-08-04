package database;

import java.util.HashMap;
import java.util.Map;

public class BankTransactions {
	private Map<Integer, MainAccount> bankAccounts =  new HashMap<>(); // map used to map stored list of accounts Integer and MainAccount
	
	public ApplicationOutput<UserInfo> searchBankAccountByName(String name){ // method that allows user to search bank account by associated name
		MainAccount mainAccount = bankAccounts.get(name);
		
		if (mainAccount!=null) {
			return ApplicationOutput.success(mainAccount.getUserInfo()); // success functionality called from ApplicationOutput class if conditions are met
		}else {
			return ApplicationOutput.fail("There is no account with this name associated with it: " + name); // fail/error message called in from ApplicationOutput class if conditions are not met
		}
	}
	public ApplicationOutput<UserInfo> depositMoney(UserInfo userInfo, int amountOfMoney){
		MainAccount mainAccount = bankAccounts.get(userInfo.getName());
		mainAccount.depositMoney(amountOfMoney); // this operation will occur since it is calling the depositMoney method from MainAccount
		return ApplicationOutput.success(mainAccount.getUserInfo()); // returning new account data since account data is updated after deposit		
	}
	public ApplicationOutput<UserInfo> withdrawMoney(UserInfo userInfo, int amountOfMoney){
		MainAccount mainAccount = bankAccounts.get(userInfo.getName());
		boolean canDeposit = mainAccount.withdrawMoney(amountOfMoney);
		
		if (canDeposit) {
			return ApplicationOutput.success(mainAccount.getUserInfo());
		}else {
			return ApplicationOutput.fail("This withdrawal transaction has failed: " + amountOfMoney + ". This account has: " + mainAccount.getAccountBalance());
		}
	}
}
