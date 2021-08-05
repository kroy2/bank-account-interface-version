package Controllers;

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

public class AccountsViewController {

	@FXML
	private TextField WithdrawMoneyInputChequing;

	@FXML
	private Label UsernameLabel2;

	@FXML
	private Label SavingsAccountBalanceLabel1;

	@FXML
	private Button LogOutButton;

	@FXML
	private Button DepositButtonChequing;

	@FXML
	private Label UsernameLabel;

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
	void DepositButtonClickedChequing(ActionEvent event) {
		// Deposit method invoked

		//
	}

	@FXML
	void WithdrawButtonClickedChequing(ActionEvent event) {
		// Withdraw method invoked
	}

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
