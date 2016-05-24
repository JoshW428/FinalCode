package rocket.app.view;

import java.awt.Button;
import java.awt.TextField;

import com.sun.glass.ui.MenuItem;
import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpenses;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private ComboBox<String> Term;
	@FXML
	private Label Income;
	@FXML
	private Label monthlyExp;
	@FXML
	private Label creditS;
	@FXML
	private Label houseC;
	@FXML
	private Label mortgage;
	@FXML
	private Button calc;
	@FXML
	private String fift = "15 Yr";
	@FXML
	private String thirt = "30 Yr";
	
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	//	TODO - RocketClient.RocketMainController
	//			Call this when btnPayment is pressed, calculate the payment
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		
		Object message = null;
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		lq.setiCreditScore((int)Double.parseDouble(txtCreditScore.getText()));
		//	TODO - RocketClient.RocketMainController
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq
		if (Term.getValue()=="15 Yr") {
			lq.setiTerm(15*12);
		}
		else if(Term.getValue() == "30 Yr") {
			lq.setiTerm(30*12);
		}
		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		double pay = lRequest.getdPayment();
		if (pay<= 0.36*(lRequest.getIncome()/12) && pay <= (0.28*(lRequest.getIncome()/12 - lRequest.getExpenses()))) {
			System.out.printf("%.2f", pay);
		}
	}
	@FXML
	private void dropMenu() {
		ObservableList<String> str = FXCollections.observableArrayList(fift,thirt);
		Term.setItems(str);
	}

}
