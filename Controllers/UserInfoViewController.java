package Controllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    @FXML
    void EnterButtonClicked(ActionEvent event) {

    }

	public void linkWithApplication(UserInfoViewTester userInfoViewTester) {
		
	}


}
