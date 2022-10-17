import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class addStudentController implements Initializable{

    @FXML
    private Button addStudent;
    @FXML
    private GridPane addStudentWindow;
    @FXML
    private TextField enteredBatch;
    @FXML
    private ChoiceBox<String> enteredDept;
    @FXML
    private ChoiceBox<String> enteredYear;
    @FXML
    private TextField enteredEmail;
    @FXML
    private TextField enteredName;
    @FXML
    private TextField enteredPassword;
    @FXML
    private TextField enteredPhoneNum;
    @FXML
    private TextField enteredRollNum;
    @FXML
    private TextField enteredUserName;
    @FXML
    private Label studentAddedNote;

    @FXML
    void addStudentAction(ActionEvent event) {
        String name = enteredName.getText();
        String userName = enteredUserName.getText();
        String password = enteredPassword.getText();
        String rollNum = enteredRollNum.getText();
        String phoneNumString = enteredPhoneNum.getText();
        String email = enteredEmail.getText();
        String batch = enteredBatch.getText();
        String dept = enteredDept.getValue();
        String year = enteredYear.getValue();
        
        if(name.length() == 0 || userName.length() == 0 || password.length() == 0 || email.length() == 0 || phoneNumString.length() == 0 || rollNum.length() == 0 || batch.length() == 0 || dept == null || year == null){
            studentAddedNote.setText("All fields must be filled");
            return;
        } year = year.substring(year.length() - 1);
        for(char ch : name.toCharArray()){
            if(ch != ' ' && !Character.isLetter(ch)){
                studentAddedNote.setText("Enter valid name");
                return;
            }
        } if(!email.endsWith("@iiitg.ac.in") && !email.endsWith("@gmail.com")){
            studentAddedNote.setText("Enter valid email");
            return;
        } if(phoneNumString.length() != 10){
            studentAddedNote.setText("Enter valid phone number");
            return;
        } else{
            String numFirstHalf = phoneNumString.substring(0, 5);
            String numSecondHalf = phoneNumString.substring(5);
            try{
                Integer.parseInt(numFirstHalf);
                Integer.parseInt(numSecondHalf);
            } catch(Exception e){
                studentAddedNote.setText("Enter valid phone number");
                return;
            }
        } if(rollNum.length() != 6){
            studentAddedNote.setText("Enter valid roll number");
            return;
        } else{
            try{
                Integer.parseInt(rollNum);
            } catch(Exception e){
                studentAddedNote.setText("Enter valid roll number");
                return;
            }
        } if(batch.length() != 4 || batch.charAt(0) != '2'){
            studentAddedNote.setText("Enter valid batch");
            return;
        } else{
            try{
                Integer.parseInt(batch);
            } catch(Exception e){
                studentAddedNote.setText("Enter valid batch");
                return;
            }
        } 

        Document newData = new Document("rollNum", rollNum);
        newData.append("name", name);
        newData.append("userName", userName);
        newData.append("password", password);
        newData.append("phoneNum", phoneNumString);
        newData.append("email", email);
        newData.append("batch", Integer.parseInt(batch));
        newData.append("dept", dept);
        newData.append("breakfast", true);
        newData.append("lunch", true);
        newData.append("dinner", true);
        newData.append("dues", "0");
        newData.append("year", year);
        mongo.collection.insertOne(newData);
        studentAddedNote.setText("Student Added");
        clearFields();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] depts = {"CSE", "ECE"};
        enteredDept.getItems().addAll(depts);
        String[] year = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredYear.getItems().addAll(year);

        mongo.connectStudents();
    }

    void clearFields(){
        enteredName.clear();
        enteredUserName.clear();
        enteredPassword.clear();
        enteredEmail.clear();
        enteredPhoneNum.clear();
        enteredRollNum.clear();
        enteredBatch.clear();
        enteredDept.getSelectionModel().clearSelection();
        enteredYear.getSelectionModel().clearSelection();
    }

}
