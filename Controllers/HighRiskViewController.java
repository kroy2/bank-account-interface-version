package Controllers;

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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import Database.*;
public class HighRiskViewController {
	double balanceHighRisk = 0;
	Accounts HighRisk = new Accounts(balanceHighRisk);

	@FXML
	private Button GoBackButton;

	@FXML
	private TextField HighRiskDepositInput;

	@FXML
	private Button LowestInvestmentOptionButton;

	@FXML
	private Button HighInvestmentOptionButton;

	@FXML
	private Button HighRiskDepositButton;

	@FXML
	private Label InvestmentOptionOutput;

	@FXML
	private Button MiddleInvestmentOptionButton;

	@FXML
	private Label HighRiskTFSABalance;
	
	
	/**
	 * Deposits inputed amount of money into TFSA
	 * Removes user input after
	 * @param event can be activated two ways:
	 * Clicking deposit
	 * Pressing Enter on Keyboard
	 * Re-enables investment option buttons
	 * and adds text to them
	 * 
	 */
	@FXML
	void HighRiskDepositButtonClicked(ActionEvent event) {
		// Deposit method invoked from accounts class
		balanceHighRisk = balanceHighRisk + Double.parseDouble(HighRiskDepositInput.getText());
		// Prints current balance in High Risk
		setBalanceHighRisk(balanceHighRisk);
		// Removes previous User input
		HighRiskDepositInput.clear();
		
		// Reactivates option buttons after there is money in TFSA
		LowestInvestmentOptionButton.setDisable(false);
		MiddleInvestmentOptionButton.setDisable(false);
		HighInvestmentOptionButton.setDisable(false);
		
		// Adds text to buttons which represent amount invested
		LowestInvestmentOptionButton.setText("$" + balanceHighRisk*0.12);
		MiddleInvestmentOptionButton.setText("$" + balanceHighRisk*0.18);
		HighInvestmentOptionButton.setText("$" + balanceHighRisk*0.24);
		
		
	}

	/**
	 * Represents an investment of 12 percent
	 * Displays text output 
	 * Changes balance of TFSA 
	 * Changes Text of all 3 buttons appropriately
	 * based on current balance
	 */
	@FXML
	void LowInvestmentButtonClicked(ActionEvent event) {
		// Displays Amount used to invest
		InvestmentOptionOutput.setText("You have invested 12 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceHighRisk(balanceHighRisk - balanceHighRisk*0.12);
		// Actually changes the balance
		balanceHighRisk = balanceHighRisk - balanceHighRisk*0.12;
		
		// Appropriately changes buttons text to represent new balance values
		// including rounding to 2 decimal places
		LowestInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.12));
		MiddleInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.18));
		HighInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.24));
	}
	
	/**
	 * Represents an investment of 18 percent
	 * Displays text output 
	 * Changes balance of TFSA 
	 * Changes Text of all 3 buttons appropriately
	 * based on current balance
	 */
	@FXML
	void MiddleInvestmentButtonClicked(ActionEvent event) {
		// Displays Amount used to invest
		InvestmentOptionOutput.setText("You have invested 18 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceHighRisk(balanceHighRisk - balanceHighRisk*0.18);
		// Actually changes the balance
		balanceHighRisk = balanceHighRisk - balanceHighRisk*0.18;
		
		// Appropriately changes buttons text to represent new balance values
		// including rounding to 2 decimal places
		LowestInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.12));
		MiddleInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.18));
		HighInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.24));
	}
	
	/**
	 * Represents an investment of 24 percent
	 * Displays text output 
	 * Changes balance of TFSA 
	 * Changes Text of all 3 buttons appropriately
	 * based on current balance
	 */
	@FXML 
	void HighInvestmentButtonClicked(ActionEvent event){
		//Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 24 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceHighRisk(balanceHighRisk - balanceHighRisk*0.24);
		// Actually changes the balance
		balanceHighRisk = balanceHighRisk - balanceHighRisk*0.24;
		
		//Appropriately changes buttons text to represent new balance values
		// including rounding to 2 decimal places
		LowestInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.12));
		MiddleInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.18));
		HighInvestmentOptionButton.setText("$" + String.format("%.2f",balanceHighRisk*0.24));
	}
	
	/**
	 * Goes back to accounts tabs
	 */
	@FXML
	void GoBackButtonClicked(ActionEvent event) throws FileNotFoundException, IOException {
		FXMLLoader loader = new FXMLLoader();
		// Access AccountView fxml file to set new scene
		Parent AccountViewParent = (Parent) loader.load(new FileInputStream("src/Views/AccountsView.fxml"));

		// Sets scene
		Scene AccountViewScene = new Scene(AccountViewParent);

		// This line gets the stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Sets scene and shows upon button press
		window.setScene(AccountViewScene);
		window.show();

	}
	/**
	 * Sets balance of TFSA based on
	 * @param amount while also rounding to 
	 * 2 decimal places
	 */
	public void setBalanceHighRisk(double amount) {
		// Rounds to 2 decimal places
		HighRiskTFSABalance.setText(String.format("%.2f", amount));
	}
	
	/**
	 * links with tester so can be run independently
	 */
	public void linkWithApplication(HighRiskViewTester highRiskViewTester) {
		
	}
}
