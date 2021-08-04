package application;

import database.UserInfo;
import database.BankTransactions;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BankApplication {
	private final BankTransactions bankSystem;
	private UserInfo userInfo = null;

	public BankApplication(BankTransactions bankSystem) {
		this.bankSystem = bankSystem;
	}
	
	private Consumer<UserInfo> updatedInfo = info ->{
		userInfo = info;
	};

	public void enterInfo(int bankNumber) {
		Test(()->bankSystem.searchBankAccountByBankNumber(bankNumber), updatedInfo);
	}
	
	public void depositMoney(int amountOfMoney) {
		if(userInfo!=null) { // first check if user info is present
			Test(()->bankSystem.depositMoney(userInfo, amountOfMoney), updatedInfo);
		}
	}
	
	public void withdrawMoney(int amountOfMoney) {
		if(userInfo!=null) { // first check if user info is present
			Test(()->bankSystem.depositMoney(userInfo, amountOfMoney), updatedInfo);
		}
	}
	
	public void exitProgram() {
		if (userInfo!=null) { // first check if user info is present
			userInfo = null; // reset to null upon exit
		}
		
	}
	
	public String toString() {
		return userInfo != null? userInfo.toString() : "There is no data";
	}
	
	private <obj>void Test(Supplier<ApplicationOutput<obj>> action, Consumer<obj> afterAction) { // Test method that tests called methods and passes or fails based on conditions met
		try {
			ApplicationOutput<obj> output = action.get();
			if(output.successfulInfo()) {
				obj info = output.getInfo();
				afterAction.accept(info);
				
			}else {	
				String error = output.getError();
				throw new RuntimeException(error);
			}}
			catch (Exception e) {
				System.out.println("There is an error: " + e.getMessage()); // printing error in command line if conditions are not met
			}
		}
	}
