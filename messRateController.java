import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;
import org.bson.conversions.Bson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class messRateController implements Initializable{

    @FXML
    private TextField breakfastRate;
    @FXML
    private Button changeRates;
    @FXML
    private TextField dinnerRate;
    @FXML
    private TextField lunchRate;
    @FXML
    private GridPane messRatesWindow;
    @FXML
    private Label ratesChangedNote;

    @FXML
    void changeRatesAction(ActionEvent event) {
        String breakFast = breakfastRate.getText();
        String lunch = lunchRate.getText();
        String dinner = dinnerRate.getText();

        try{
            Integer.parseInt(breakFast);
            Integer.parseInt(lunch);
            Integer.parseInt(dinner);
        } catch(Exception e){
            ratesChangedNote.setText("Enter valid rates");
            return;
        }

        Document result = (Document) mongo.collection.find(new Document("meal", "breakfast")).first();
        Bson update = new Document("$set", new Document("rate", Integer.parseInt(breakFast)));
        mongo.collection.updateOne(result, update);
        result = (Document) mongo.collection.find(new Document("meal", "lunch")).first();
        update = new Document("$set", new Document("rate", Integer.parseInt(lunch)));
        mongo.collection.updateOne(result, update);
        result = (Document) mongo.collection.find(new Document("meal", "dinner")).first();
        update = new Document("$set", new Document("rate", Integer.parseInt(dinner)));
        mongo.collection.updateOne(result, update);
        ratesChangedNote.setText("Rates changed");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        mongo.connectMessRates();
        Document result = (Document) mongo.collection.find(new Document("meal", "breakfast")).first();
        String rate = result.get("rate").toString();
        breakfastRate.setText(rate);

        result = (Document) mongo.collection.find(new Document("meal", "lunch")).first();
        rate = result.get("rate").toString();
        lunchRate.setText(rate);

        result = (Document) mongo.collection.find(new Document("meal", "dinner")).first();
        rate = result.get("rate").toString();
        dinnerRate.setText(rate);
    }

}
