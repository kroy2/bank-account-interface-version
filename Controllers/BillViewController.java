package Controllers;

import java.io.IOException;

import Database.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class BillViewController {
	
	
	@FXML
	private Button GoBackButton;
	
	@FXML
	private TextField BillFrequencyInput;
	@FXML
	private TextField BillNameInput;
	@FXML
	private Button ResetButton;
	@FXML
	private Button SubmitButton;
	@FXML
	private TextField BillCostInput;
	@FXML
	private TableView<Bill> tableView;
	@FXML
	private TableColumn<Bill, String> BillNameColumn;
	@FXML
	private TableColumn<Bill, String> BillPriceColumn;
	@FXML
	private TableColumn<Bill, Double> BillFrequencyColumn;
	
	
	/**
	 * Sets up Table View
	 */
	public void setTableView() {
		// set up columns in the table
		BillNameColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("Billname"));
		BillPriceColumn.setCellValueFactory(new PropertyValueFactory<Bill, String>("cost"));
		BillFrequencyColumn.setCellValueFactory(new PropertyValueFactory<Bill, Double>("frequency"));
		
		// load data
		tableView.setItems(getBill());
		
		
	}

	/**
	 * Creates Observable List that gets populated
	 * with data from type Bill in Database
	 * 
	 */
	public ObservableList<Bill> getBill(){
		// creating new observable list
		ObservableList<Bill> bill = FXCollections.observableArrayList();
		// adding elements
		bill.add(new Bill(BillNameInput.getText(), Double.parseDouble(BillCostInput.getText()), Double.parseDouble(BillFrequencyInput.getText())));
		return bill;
		
	}
	/**
	 * links with tester so it can be run independantly
	 */
	public void linkWithApplication(BillViewTester billViewTester) {
		
	}

	/**
	 * Clears User inputs
	 */
	@FXML
	void ResetButtonClicked(ActionEvent event) {
		
	}
	
	/**
	 * 
	 * linking submit with creating new table element
	 */
	@FXML
	void SubmitButtonClicked(ActionEvent event) {
		ObservableList<Bill> bill = FXCollections.observableArrayList();
		bill.add(new Bill(BillNameInput.getText(), Double.parseDouble(BillCostInput.getText()), Double.parseDouble(BillFrequencyInput.getText())));
	}
	
	/**
	 * Goes back to AccountsView
	 * @throws IOException 
	 */
	@FXML
	void GoBackButtonClicked(ActionEvent event) throws IOException {
		// creates a new loader
		FXMLLoader loader = new FXMLLoader();
		// sets the location of new loader to AccountsView
		loader.setLocation(getClass().getResource("/Views/AccountsView.fxml"));
		// loads loader so methods can be accessed
		Parent AccountViewParent = loader.load();

		// sets scene
		Scene AccountViewScene = new Scene(AccountViewParent);

		// access AccountsViewController
		AccountsViewController accounts = loader.getController();

		// sets balance to previous amounts
		accounts.setBalanceChequing(accounts.getChequingBalance());
		accounts.setBalanceSavings(accounts.getSavingsBalance());

		// sets username to previous name
		accounts.setUsername(accounts.getUsername());

		// Gets the Stage information
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		// Sets Scene and shows upon button press
		window.setScene(AccountViewScene);
		window.show();
	}


}
