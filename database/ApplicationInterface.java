package application;
import database.BankTransactions;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class ApplicationInterface extends Application {
	
	private TextField spaceForText = new TextField();
	private BankApplication BankApplication = new BankApplication(new BankTransactions());
	
	private Parent interfaceElements() {
		VBox verticalBox = new VBox();
		verticalBox.setPrefSize(400, 400);
		
		TextArea text = new TextArea();
		
		Button buttonEnter = new Button("Enter");
		buttonEnter.setOnAction(e->{int bankNumber = Integer.parseInt(spaceForText.getText()); BankApplication.enterInfo(bankNumber); text.setText(BankApplication.toString());});
		
		Button buttonDepositAmount = new Button("Deposit Amount");
		buttonDepositAmount.setOnAction(e->{int amountOfMoney = Integer.parseInt(spaceForText.getText()); BankApplication.depositMoney(amountOfMoney); text.setText(BankApplication.toString());});
		
		Button buttonWithdrawAmount = new Button("Withdraw Amount");
		buttonWithdrawAmount.setOnAction(e->{int amountOfMoney = Integer.parseInt(spaceForText.getText()); BankApplication.withdrawMoney(amountOfMoney); text.setText(BankApplication.toString());});
		
		Button buttonExit = new Button("Exit");
		buttonExit.setOnAction(e->{BankApplication.exitProgram();text.setText(BankApplication.toString());});
		

		verticalBox.getChildren().addAll(spaceForText, buttonEnter, buttonDepositAmount, buttonWithdrawAmount, buttonExit);
		return verticalBox;
	}

	public void start(Stage interfaceStage) throws Exception{
		interfaceStage.setScene(new Scene(interfaceElements()));
		interfaceStage.show();
	}
	public static void main (String[]args) {
		launch(args);
	}
}
