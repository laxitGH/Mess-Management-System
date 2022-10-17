import java.net.URL;
import java.util.ResourceBundle;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import org.bson.Document;
import org.bson.conversions.Bson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class moneyDepositController implements Initializable{

    @FXML
    private Button depositMoney;
    @FXML
    private GridPane depositMoneyWindow;
    @FXML
    private Label duesLeftNote;
    @FXML
    private TextField enteredAmount;
    @FXML
    private ChoiceBox<String> enteredBatch;
    @FXML
    private TextField enteredRollNum;
    @FXML
    private Label moneyDepositedNote;

    @FXML
    void depositMoneyAction(ActionEvent event) {
        moneyDepositedNote.setText("");
        duesLeftNote.setText("");

        String batch = enteredBatch.getValue();
        String rollNum = enteredRollNum.getText();
        String amount = enteredAmount.getText();

        if(batch == null || rollNum.length() == 0 || amount.length() == 0){
            moneyDepositedNote.setText("All fields must be filled");
            return;
        } if(rollNum.length() != 6){
            moneyDepositedNote.setText("Enter valid roll number");
            return;
        } else{
            try{
                Integer.parseInt(rollNum);
            } catch(Exception e){
                moneyDepositedNote.setText("Enter valid roll number");
                return;
            }
        } try{
            Integer.parseInt(amount);
        } catch(Exception e){
            moneyDepositedNote.setText("Enter valid money amount");
            return;
        } String year = batch.substring(batch.length() - 1);

        FindIterable<Document> iterable = mongo.collection.find(new Document("year", year));
        if(iterable == null){
            moneyDepositedNote.setText("No such student found. Recheck credentials");
            return;
        } else{
            MongoCursor<Document> iterator = iterable.iterator();
            while(iterator.hasNext()){
                Document result = iterator.next();
                if(result.get("rollNum").toString().equals(rollNum)){
                    int dues = Integer.parseInt(result.get("dues").toString());
                    dues -= Integer.parseInt(amount);

                    Bson update = new Document("$set", new Document("dues", "" + dues));
                    mongo.collection.updateOne(result, update);

                    duesLeftNote.setText("" + dues);
                    moneyDepositedNote.setText("Money Deposited");
                    clearFields();
                    return;
                }
            }
        } moneyDepositedNote.setText("No such student found. Recheck credentials");
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] batches = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredBatch.getItems().addAll(batches);
        mongo.connectStudents();
    }

    void clearFields(){
        enteredBatch.getSelectionModel().clearSelection();
        enteredAmount.clear();
        enteredRollNum.clear();
    }

}
