package Controllers;

import Database.*;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
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

public class UserInfoViewController {

	@FXML
	private TextField UsernameInput;

	@FXML
	private Label ActionTextOutput;

	@FXML
	private Button ResetButton;

	@FXML
	private TextField PasswordInput;

	@FXML
	private Button EnterButton;

	@FXML
	void ResetButtonClicked(ActionEvent event) {
		UsernameInput.clear();
		PasswordInput.clear();
		ActionTextOutput.setText("Your information has been Reset, please enter information.");
	}

	/**
	 * Saves user input for username and password Changes Scene to access accounts
	 * with different functionalities
	 */
	@FXML
	void EnterButtonClicked(ActionEvent event) throws IOException {

		// Check whether Username and password are the same
		// If so, Prompts the user to try again
		if (UsernameInput.getText().equals(PasswordInput.getText()) && UsernameInput.getLength() > 0
				&& PasswordInput.getLength() > 0) {
			ActionTextOutput.setText("Your Username and Password are the same. Please make them different!");
		}

		// Checks if one of the boxes is empty, if so, prompts the user to fill in
		// remaining box
		else if (UsernameInput.getLength() == 0 || PasswordInput.getLength() == 0) {
			ActionTextOutput.setText("Either your Username or Password are empty. Please fill it out.");
		} else {
			// Kanishkas Work
			// Store UsernameInput and PasswordInput with corresponding varaibles
			// For Example: Username = Integer.parseInt(Username.getText())

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
	}

	/**
	 * links with tester so it can be run independently
	 */
	public void linkWithApplication(UserInfoViewTester userInfoViewTester) {

	}

	/**
	 * Links with main application named BankingApplication
	 */
	public void linkWithApplication(BankingApplication bankingApplication) {

	}
}
