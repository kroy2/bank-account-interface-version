package database;

import database.UserInfo;
import database.BankTransactions;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Application {
	private final BankTransactions bankSystem;
	private UserInfo userInfo = null;

	public Application(BankTransactions bankSystem) {
		this.bankSystem = bankSystem;
	}

	public void enterName(String name) {
		Test(()->bankSystem.searchBankAccountByName(name), info -> userInfo = info);
	}
	
	public void depositMoney(int amountOfMoney) {
		if(userInfo!=null) { // first check if user info is present
			Test(()->bankSystem.depositMoney(userInfo, amountOfMoney), info->userInfo=info);
		}
	}
	
	public void withdrawMoney(int amountOfMoney) {
		if(userInfo!=null) { // first check if user info is present
			
		}
	}
	
	public void exitProgram() {
		if (userInfo!=null) { // first check if user info is present
			userInfo = null; // reset to null upon exit
		}
		
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
