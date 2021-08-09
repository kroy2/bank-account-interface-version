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
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LowRiskViewController {
	double balanceLowRisk = 0;
	Accounts LowRisk = new Accounts(balanceLowRisk);

	@FXML
	private Button GoBackButton;

	@FXML
	private TextField LowRiskDepositInput;

	@FXML
	private Label LowRiskTFSABalance;

	@FXML
	private Button LowRiskDepositButton;

	@FXML
	private Button LowestInvestmentOptionButton;

	@FXML
	private Button HighInvestmentOptionButton;

	@FXML
	private Label InvestmentOptionOutput;

	@FXML
	private Button MiddleInvestmentOptionButton;

	/**
	 * Sets balance of TFSA based on
	 * 
	 * @param amount while also rounding to 2 decimal places
	 */
	public void setBalanceLowRisk(double amount) {
		LowRiskTFSABalance.setText(String.format("%.2f", amount));
	}

	/**
	 * links with tester so it can be run independently
	 */
	public void LinkWithApplication(LowRiskViewTester lowRiskViewTester) {

	}

	// appropriately changes button's text to represent new balance values
	// including rounding to 2 decimal places
	public void setTextInvestmentOptionButton() {
		LowestInvestmentOptionButton.setText("$" + String.format("%.2f", balanceLowRisk * 0.025));
		MiddleInvestmentOptionButton.setText("$" + String.format("%.2f", balanceLowRisk * 0.0625));
		HighInvestmentOptionButton.setText("$" + String.format("%.2f", balanceLowRisk * 0.10));
	}

	/**
	 * Deposits inputed amount of money into TFSA
	 * Removes user input after
	 * @param event can be activated two ways:
	 * Clicking deposit
	 * Pressing Enter on keyboard
	 * Re-enables investment option buttons
	 * and adds text to them
	 */
	@FXML
	void LowRiskDepositButtonClicked(ActionEvent event) {
		// Deposit method invoked from accounts class
		balanceLowRisk = balanceLowRisk + Double.parseDouble(LowRiskDepositInput.getText());
		// Prints current balance in Low Risk
		setBalanceLowRisk(balanceLowRisk);
		// Removes previous User input
		LowRiskDepositInput.clear();
		
		// Reactivates option buttons after there is money in TFSA
		LowestInvestmentOptionButton.setDisable(false);
		MiddleInvestmentOptionButton.setDisable(false);
		HighInvestmentOptionButton.setDisable(false);

		//Resets Text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();
	}
	
	/**
	 * Represents an investment of 2.5 percent
	 * Displays text output
	 * Changes balance of TFSA
	 * Changes text of all 3 buttons appropriately
	 * based on current balance
	 */
	@FXML
	void LowInvestmentButtonClicked(ActionEvent event) {
		// Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 2.5 percent of your TFSA balance.");
		// Changes the balance displayed on screen
		setBalanceLowRisk(balanceLowRisk - balanceLowRisk * 0.025);
		// Actually changes the balance
		balanceLowRisk = balanceLowRisk - balanceLowRisk * 0.025;

		// Resets text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();
	}

	/**
	 * Represents an investment of 6.25 percent
	 * Displays text output
	 * Changes balance of TFSA
	 * Changes text of all 3 buttons appropriately
	 * based on current balance
	 */
	@FXML
	void MiddleInvestmentButtonClicked(ActionEvent event) {
		// Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 6.25 percent of your TFSA balance");
		// Changes the balance displayed on screen
		setBalanceLowRisk(balanceLowRisk - balanceLowRisk * 0.0625);
		// Actually changes the balance
		balanceLowRisk = balanceLowRisk - balanceLowRisk * 0.0625;

		// Resets text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();
	}

	/**
	 * Represents an investment of 10 percent
	 * Displays text output
	 * Changes balance of TFSA
	 * Changes text of all 3 buttons appropriately
	 * based on current balance
	 */
	@FXML
	void HighInvestmentButtonClicked(ActionEvent event) {
		// Displays amount used to invest
		InvestmentOptionOutput.setText("You have invested 10 percent of your TFSA balance");
		// Changes the balance displayed on screen
		setBalanceLowRisk(balanceLowRisk - balanceLowRisk * 0.10);
		// Actually changes the balance
		balanceLowRisk = balanceLowRisk - balanceLowRisk * 0.10;

		// Resets text in other buttons
		// while accounting for 2 decimal places
		setTextInvestmentOptionButton();
	}

	/**
	 * goes back to accounts tabs
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
		// Sets scene and show upon button press
		window.setScene(AccountViewScene);
		window.show();

	}

}
