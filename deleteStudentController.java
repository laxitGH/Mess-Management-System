import java.net.URL;
import java.util.ResourceBundle;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import org.bson.Document;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class deleteStudentController implements Initializable{

    @FXML
    private Button deleteStu;
    @FXML
    private GridPane deleteStuWindow;
    @FXML
    private ChoiceBox<String> enteredBatch;
    @FXML
    private TextField enteredRollNum;
    @FXML
    private Label stuDeletedNote;

    @FXML
    void deleteStuAction(ActionEvent event) {
        String rollNum = enteredRollNum.getText();
        String batch = enteredBatch.getValue();
        if(batch == null){
            stuDeletedNote.setText("Select a batch");
            return;
        } if(rollNum.length() != 6){
            stuDeletedNote.setText("Enter a valid roll number");
            return;
        } else{
            try{
                Integer.parseInt(rollNum);
            } catch(Exception e){
                stuDeletedNote.setText("Enter a valid roll number");
                return;
            }
        } String year = batch.substring(batch.length() - 1);

        FindIterable<Document> iterable = mongo.collection.find(new Document("year", year));
        if(iterable == null){
            stuDeletedNote.setText("No such student found. Recheck credentials");
            return;
        } else{
            MongoCursor<Document> iterator = iterable.iterator();
            while(iterator.hasNext()){
                Document result = iterator.next();
                if(result.get("rollNum").toString().equals(rollNum)){
                    mongo.collection.deleteOne(result);
                    stuDeletedNote.setText("Student deleted from database");
                    clearFields();
                    return;
                }
            }
        } stuDeletedNote.setText("No such student found. Recheck credentials");
        
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        String[] batches = {"btechYear1", "btechYear2", "btechYear3", "btechYear4"};
        enteredBatch.getItems().addAll(batches);
        mongo.connectStudents(); 
    }

    public void clearFields(){
        enteredRollNum.clear();
        enteredBatch.getSelectionModel().clearSelection();
    }

}
