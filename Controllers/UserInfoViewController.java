package Controllers;

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
	private Label ResetTextOutput;

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
		ResetTextOutput.setText("Your information has been Reset, please enter information.");
	}

	/**
	 * Saves user input for username and password Changes Scene to access accounts
	 * with different functionalities
	 */
	@FXML
	void EnterButtonClicked(ActionEvent event) throws IOException {
		// Kanishkas Work
		// Store UsernameInput and PasswordInput with corresponding varaibles

		FXMLLoader loader = new FXMLLoader();
		// Access other fxml file to set new scene
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
	 * links with tester so it can be run independently
	 * 
	 */
	public void linkWithApplication(UserInfoViewTester userInfoViewTester) {

	}

}
