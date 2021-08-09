package Controllers;

import Database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountsViewController extends UserInfoViewController {
	double balanceChequing = 0;
	double balanceSavings = 0;
	Accounts Chequing = new Accounts(balanceChequing);
	Accounts Savings = new Accounts(balanceSavings);

	@FXML
	private TextField WithdrawMoneyInputChequing;

	@FXML
	public Label UsernameLabel2;
	
	@FXML
	private Label SavingsAccountBalanceLabel1;

	@FXML
	private Button LogOutButton;

	@FXML
	private Button DepositButtonChequing;

	@FXML
	public Label UsernameLabel;
	
	@FXML
	public Label SavingsOutput;
	
	@FXML
	private Label ChequingAccountBalanceLabel;

	@FXML
	private Button LogOutButton2;

	@FXML
	private TextField DepositMoneyInputSavings;

	@FXML
	private TextField WithdrawMoneyInputSavings;

	@FXML
	private Button DepositButtonSavings;

	@FXML
	private Button WithdrawButtonSavings;

	@FXML
	private Button WithdrawButtonChequing;

	@FXML
	private Button LogOutButton3;

	@FXML
	private TextField DepositMoneyInputChequing;
	
	@FXML
	private Button HighRiskButton;
	
	@FXML
	private Button LowRiskButton;

	
	/**
	 * Access Accounts Class from Database package and 
	 * Deposits money into account
	 * Two ways to call:
	 * First: Press Button
	 * Second: User presses enter 
	 */
	@FXML
	void DepositButtonClickedChequing(ActionEvent event) {
		// Deposit method invoked from Accounts class
		balanceChequing = balanceChequing + Double.parseDouble(DepositMoneyInputChequing.getText());
		// Prints current balance in chequing
		setBalanceChequing(balanceChequing);
		// Removes user previous input
		DepositMoneyInputChequing.clear();
	}
	/**
	 * Access Accounts Class from Database package and 
	 * Withdraws money from account
	 * Two ways to call:
	 * First: Press Button
	 * Second: User presses enter 
	 */
	@FXML
	void WithdrawButtonClickedChequing(ActionEvent event) {
		// Withdraw method invoked from Accounts Class
		balanceChequing = balanceChequing - Double.parseDouble(WithdrawMoneyInputChequing.getText());
		// Prints current balance in chequing
		setBalanceChequing(balanceChequing);
		// removes user previous input
		WithdrawMoneyInputChequing.clear();
	}

	/**
	 * Goes back to User Info Screen
	 */
	@FXML
	void LogOut(ActionEvent event) throws FileNotFoundException, IOException {
		FXMLLoader loader = new FXMLLoader();
		// Access UserInfoView fxml file to set new scene
		Parent UserInfoViewParent = (Parent) loader.load(new FileInputStream("src/Views/UserInfoView.fxml"));

		// Sets scene
		Scene UserInfoViewScene = new Scene(UserInfoViewParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Sets scene and shows upon button press
		window.setScene(UserInfoViewScene);
		window.show();
	}
	
	/**
	 * Access Accounts Class from Database package and 
	 * Deposits money into account
	 * Two ways to call:
	 * First: Press Button
	 * Second: User presses enter 
	 */
	@FXML
	void DepositButtonClickedSavings(ActionEvent event) {
		// Deposit method invoked from Accounts class
		balanceSavings = balanceSavings + Double.parseDouble(DepositMoneyInputSavings.getText());
		// Prints current balance in savings
		setBalanceSavings(balanceSavings);
		// Removes user previous input
		DepositMoneyInputSavings.clear();
	}
	
	/**
	 * Access Accounts Class from Database package and 
	 * Withdraws money from account
	 * Two ways to call:
	 * First: Press Button
	 * Second: User presses enter 
	 */
	@FXML
	void WithdrawButtonClickedSavings(ActionEvent event) {
		// Withdraw method invoked from Accounts class
		// Every time withdraw is called, add 5% interest, then withdraw
		balanceSavings = balanceSavings*1.05 - Double.parseDouble(WithdrawMoneyInputSavings.getText());
		// Prints current balance in savings
		setBalanceSavings(balanceSavings);
		// Removes user previous input
		WithdrawMoneyInputSavings.clear();
		// Displays that Interest was applied
		SavingsOutput.setText("5% interest was applied to the balance before withdrawing.");
	}

	/**
	 * Links with Tester
	 */
	public void linkWithApplication(AccountsViewTester accountsViewTester) {

	}

	/**
	 * Method that updates balance label every time a transaction is made
	 * used for Chequing. Always rounds to 2 decimal places.
	 */
	public void setBalanceChequing(double amount) {
		// Rounds to 2 decimal places
		ChequingAccountBalanceLabel.setText(String.format("%.2f", amount));
	}

	/**
	 * Method that updates balance label every time a transaction is made used for
	 * Savings. Always rounds to 2 decimal places
	 */
	public void setBalanceSavings(double amount) {
		// Rounds to 2 decimal places
		SavingsAccountBalanceLabel1.setText(String.format("%.2f", amount));
	}

	/**
	 * Changes Screen to Low Risk page
	 */
	@FXML
	void LowRiskButtonClicked(ActionEvent event) throws FileNotFoundException, IOException{
		FXMLLoader loader = new FXMLLoader();
		
		Parent LowRiskViewParent = (Parent) loader.load(new FileInputStream("src/Views/LowRiskView.fxml")); 
		
		Scene LowRiskViewScene = new Scene(LowRiskViewParent);
		
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(LowRiskViewScene);
		window.show();		
	}
	
	/**
	 * Changes Screen to High Risk page
	 */
	@FXML
	void HighRiskButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
		FXMLLoader loader = new FXMLLoader();
		// Access AccountView fxml file to set new scene
		Parent HighRiskViewParent = (Parent) loader.load(new FileInputStream("src/Views/HighRiskView.fxml"));

		// Sets scene
		Scene HighRiskViewScene = new Scene(HighRiskViewParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Sets scene and shows upon button press
		window.setScene(HighRiskViewScene);
		window.show();
		
		
	}
	
}
