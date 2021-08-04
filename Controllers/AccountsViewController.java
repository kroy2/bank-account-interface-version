package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AccountsViewController {

	@FXML
	private TextField WithdrawMoneyInputChequing;

	@FXML
	private Label SavingsAccountBalanceLabel1;

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
	private Label SavingsAccountBalanceLabel;

	@FXML
	private Button DepositButtonChequing;

	@FXML
	private Label ChequingAccountBalanceLabel;

	@FXML
	private TextField DepositMoneyInputChequing;

	@FXML
	void DepositButtonClickedChequing(ActionEvent event) {

	}

	@FXML
	void WithdrawButtonClickedChequing(ActionEvent event) {

	}

	@FXML
	void DepositButtonClickedSavings(ActionEvent event) {

	}

	@FXML
	void WithdrawButtonClickedSavings(ActionEvent event) {

	}

	/**
	 * Links with Tester
	 * 
	 */
	public void linkWithApplication(AccountsViewTester accountsViewTester) {
		
	}

}
