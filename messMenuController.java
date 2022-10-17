import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;
import org.bson.conversions.Bson;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class messMenuController implements Initializable{

    @FXML
    private Button changeMenu;
    @FXML
    private TextField friBreakfast1;
    @FXML
    private TextField friBreakfast2;
    @FXML
    private TextField friBreakfast3;
    @FXML
    private TextField friDinner1;
    @FXML
    private TextField friDinner2;
    @FXML
    private TextField friDinner3;
    @FXML
    private TextField friLunch1;
    @FXML
    private TextField friLunch2;
    @FXML
    private TextField friLunch3;
    @FXML
    private GridPane messMenuWindow;
    @FXML
    private TextField monBreakfast1;
    @FXML
    private TextField monBreakfast2;
    @FXML
    private TextField monBreakfast3;
    @FXML
    private TextField monDinner1;
    @FXML
    private TextField monDinner2;
    @FXML
    private TextField monDinner3;
    @FXML
    private TextField monLunch1;
    @FXML
    private TextField monLunch2;
    @FXML
    private TextField monLunch3;
    @FXML
    private TextField satBreakfast1;
    @FXML
    private TextField satBreakfast2;
    @FXML
    private TextField satBreakfast3;
    @FXML
    private TextField satDinner1;
    @FXML
    private TextField satDinner2;
    @FXML
    private TextField satDinner3;
    @FXML
    private TextField satLunch1;
    @FXML
    private TextField satLunch2;
    @FXML
    private TextField satLunch3;
    @FXML
    private TextField sunBreakfast1;
    @FXML
    private TextField sunBreakfast2;
    @FXML
    private TextField sunBreakfast3;
    @FXML
    private TextField sunDinner1;
    @FXML
    private TextField sunDinner2;
    @FXML
    private TextField sunDinner3;
    @FXML
    private TextField sunLunch1;
    @FXML
    private TextField sunLunch2;
    @FXML
    private TextField sunLunch3;
    @FXML
    private TextField thruBreakfast1;
    @FXML
    private TextField thruBreakfast2;
    @FXML
    private TextField thruBreakfast3;
    @FXML
    private TextField thruDinner1;
    @FXML
    private TextField thruDinner2;
    @FXML
    private TextField thruDinner3;
    @FXML
    private TextField thruLunch1;
    @FXML
    private TextField thruLunch2;
    @FXML
    private TextField thruLunch3;
    @FXML
    private TextField tueBreakfast1;
    @FXML
    private TextField tueBreakfast2;
    @FXML
    private TextField tueBreakfast3;
    @FXML
    private TextField tueDinner1;
    @FXML
    private TextField tueDinner2;
    @FXML
    private TextField tueDinner3;
    @FXML
    private TextField tueLunch1;
    @FXML
    private TextField tueLunch2;
    @FXML
    private TextField tueLunch3;
    @FXML
    private TextField wedBreakfast1;
    @FXML
    private TextField wedBreakfast2;
    @FXML
    private TextField wedBreakfast3;
    @FXML
    private TextField wedDinner1;
    @FXML
    private TextField wedDinner2;
    @FXML
    private TextField wedDinner3;
    @FXML
    private TextField wedLunch1;
    @FXML
    private TextField wedLunch2;
    @FXML
    private TextField wedLunch3;

    @FXML
    void changeMenuAction(ActionEvent event) throws IOException {
        Document result = (Document) mongo.collection.find(new Document("day", "monday")).first();
        String breakfast1 = monBreakfast1.getText();
        Bson update = new Document("$set", new Document("b1", breakfast1));
        mongo.collection.updateOne(result, update);
        String breakfast2 = monBreakfast2.getText();
        update = new Document("$set", new Document("b2", breakfast2));
        mongo.collection.updateOne(result, update);
        String breakfast3 = monBreakfast3.getText();
        update = new Document("$set", new Document("b3", breakfast3));
        mongo.collection.updateOne(result, update);
        String lunch1 = monLunch1.getText();
        update = new Document("$set", new Document("l1", lunch1));
        mongo.collection.updateOne(result, update);
        String lunch2 = monLunch2.getText();
        update = new Document("$set", new Document("l2", lunch2));
        mongo.collection.updateOne(result, update);
        String lunch3 = monLunch3.getText();
        update = new Document("$set", new Document("l3", lunch3));
        mongo.collection.updateOne(result, update);
        String dinner1 = monDinner1.getText();
        update = new Document("$set", new Document("d1", dinner1));
        mongo.collection.updateOne(result, update);
        String dinner2 = monDinner2.getText();
        update = new Document("$set", new Document("d2", dinner2));
        mongo.collection.updateOne(result, update);
        String dinner3 = monDinner3.getText();
        update = new Document("$set", new Document("d3", dinner3));
        mongo.collection.updateOne(result, update);


        result = (Document) mongo.collection.find(new Document("day", "tuesday")).first();
        breakfast1 = tueBreakfast1.getText();
        update = new Document("$set", new Document("b1", breakfast1));
        mongo.collection.updateOne(result, update);
        breakfast2 = tueBreakfast2.getText();
        update = new Document("$set", new Document("b2", breakfast2));
        mongo.collection.updateOne(result, update);
        breakfast3 = tueBreakfast3.getText();
        update = new Document("$set", new Document("b3", breakfast3));
        mongo.collection.updateOne(result, update);
        lunch1 = tueLunch1.getText();
        update = new Document("$set", new Document("l1", lunch1));
        mongo.collection.updateOne(result, update);
        lunch2 = tueLunch2.getText();
        update = new Document("$set", new Document("l2", lunch2));
        mongo.collection.updateOne(result, update);
        lunch3 = tueLunch3.getText();
        update = new Document("$set", new Document("l3", lunch3));
        mongo.collection.updateOne(result, update);
        dinner1 = tueDinner1.getText();
        update = new Document("$set", new Document("d1", dinner1));
        mongo.collection.updateOne(result, update);
        dinner2 = tueDinner2.getText();
        update = new Document("$set", new Document("d2", dinner2));
        mongo.collection.updateOne(result, update);
        dinner3 = tueDinner3.getText();
        update = new Document("$set", new Document("d3", dinner3));
        mongo.collection.updateOne(result, update);


        result = (Document) mongo.collection.find(new Document("day", "wednesday")).first();
        breakfast1 = wedBreakfast1.getText();
        update = new Document("$set", new Document("b1", breakfast1));
        mongo.collection.updateOne(result, update);
        breakfast2 = wedBreakfast2.getText();
        update = new Document("$set", new Document("b2", breakfast2));
        mongo.collection.updateOne(result, update);
        breakfast3 = wedBreakfast3.getText();
        update = new Document("$set", new Document("b3", breakfast3));
        mongo.collection.updateOne(result, update);
        lunch1 = wedLunch1.getText();
        update = new Document("$set", new Document("l1", lunch1));
        mongo.collection.updateOne(result, update);
        lunch2 = wedLunch2.getText();
        update = new Document("$set", new Document("l2", lunch2));
        mongo.collection.updateOne(result, update);
        lunch3 = wedLunch3.getText();
        update = new Document("$set", new Document("l3", lunch3));
        mongo.collection.updateOne(result, update);
        dinner1 = wedDinner1.getText();
        update = new Document("$set", new Document("d1", dinner1));
        mongo.collection.updateOne(result, update);
        dinner2 = wedDinner2.getText();
        update = new Document("$set", new Document("d2", dinner2));
        mongo.collection.updateOne(result, update);
        dinner3 = wedDinner3.getText();
        update = new Document("$set", new Document("d3", dinner3));
        mongo.collection.updateOne(result, update);


        result = (Document) mongo.collection.find(new Document("day", "thrusday")).first();
        breakfast1 = thruBreakfast1.getText();
        update = new Document("$set", new Document("b1", breakfast1));
        mongo.collection.updateOne(result, update);
        breakfast2 = thruBreakfast2.getText();
        update = new Document("$set", new Document("b2", breakfast2));
        mongo.collection.updateOne(result, update);
        breakfast3 = thruBreakfast3.getText();
        update = new Document("$set", new Document("b3", breakfast3));
        mongo.collection.updateOne(result, update);
        lunch1 = thruLunch1.getText();
        update = new Document("$set", new Document("l1", lunch1));
        mongo.collection.updateOne(result, update);
        lunch2 = thruLunch2.getText();
        update = new Document("$set", new Document("l2", lunch2));
        mongo.collection.updateOne(result, update);
        lunch3 = thruLunch3.getText();
        update = new Document("$set", new Document("l3", lunch3));
        mongo.collection.updateOne(result, update);
        dinner1 = thruDinner1.getText();
        update = new Document("$set", new Document("d1", dinner1));
        mongo.collection.updateOne(result, update);
        dinner2 = thruDinner2.getText();
        update = new Document("$set", new Document("d2", dinner2));
        mongo.collection.updateOne(result, update);
        dinner3 = thruDinner3.getText();
        update = new Document("$set", new Document("d3", dinner3));
        mongo.collection.updateOne(result, update);


        result = (Document) mongo.collection.find(new Document("day", "friday")).first();
        breakfast1 = friBreakfast1.getText();
        update = new Document("$set", new Document("b1", breakfast1));
        mongo.collection.updateOne(result, update);
        breakfast2 = friBreakfast2.getText();
        update = new Document("$set", new Document("b2", breakfast2));
        mongo.collection.updateOne(result, update);
        breakfast3 = friBreakfast3.getText();
        update = new Document("$set", new Document("b3", breakfast3));
        mongo.collection.updateOne(result, update);
        lunch1 = friLunch1.getText();
        update = new Document("$set", new Document("l1", lunch1));
        mongo.collection.updateOne(result, update);
        lunch2 = friLunch2.getText();
        update = new Document("$set", new Document("l2", lunch2));
        mongo.collection.updateOne(result, update);
        lunch3 = friLunch3.getText();
        update = new Document("$set", new Document("l3", lunch3));
        mongo.collection.updateOne(result, update);
        dinner1 = friDinner1.getText();
        update = new Document("$set", new Document("d1", dinner1));
        mongo.collection.updateOne(result, update);
        dinner2 = friDinner2.getText();
        update = new Document("$set", new Document("d2", dinner2));
        mongo.collection.updateOne(result, update);
        dinner3 = friDinner3.getText();
        update = new Document("$set", new Document("d3", dinner3));
        mongo.collection.updateOne(result, update);


        result = (Document) mongo.collection.find(new Document("day", "saturday")).first();
        breakfast1 = satBreakfast1.getText();
        update = new Document("$set", new Document("b1", breakfast1));
        mongo.collection.updateOne(result, update);
        breakfast2 = satBreakfast2.getText();
        update = new Document("$set", new Document("b2", breakfast2));
        mongo.collection.updateOne(result, update);
        breakfast3 = satBreakfast3.getText();
        update = new Document("$set", new Document("b3", breakfast3));
        mongo.collection.updateOne(result, update);
        lunch1 = satLunch1.getText();
        update = new Document("$set", new Document("l1", lunch1));
        mongo.collection.updateOne(result, update);
        lunch2 = satLunch2.getText();
        update = new Document("$set", new Document("l2", lunch2));
        mongo.collection.updateOne(result, update);
        lunch3 = satLunch3.getText();
        update = new Document("$set", new Document("l3", lunch3));
        mongo.collection.updateOne(result, update);
        dinner1 = satDinner1.getText();
        update = new Document("$set", new Document("d1", dinner1));
        mongo.collection.updateOne(result, update);
        dinner2 = satDinner2.getText();
        update = new Document("$set", new Document("d2", dinner2));
        mongo.collection.updateOne(result, update);
        dinner3 = satDinner3.getText();
        update = new Document("$set", new Document("d3", dinner3));
        mongo.collection.updateOne(result, update);


        result = (Document) mongo.collection.find(new Document("day", "sunday")).first();
        breakfast1 = sunBreakfast1.getText();
        update = new Document("$set", new Document("b1", breakfast1));
        mongo.collection.updateOne(result, update);
        breakfast2 = sunBreakfast2.getText();
        update = new Document("$set", new Document("b2", breakfast2));
        mongo.collection.updateOne(result, update);
        breakfast3 = sunBreakfast3.getText();
        update = new Document("$set", new Document("b3", breakfast3));
        mongo.collection.updateOne(result, update);
        lunch1 = sunLunch1.getText();
        update = new Document("$set", new Document("l1", lunch1));
        mongo.collection.updateOne(result, update);
        lunch2 = sunLunch2.getText();
        update = new Document("$set", new Document("l2", lunch2));
        mongo.collection.updateOne(result, update);
        lunch3 = sunLunch3.getText();
        update = new Document("$set", new Document("l3", lunch3));
        mongo.collection.updateOne(result, update);
        dinner1 = sunDinner1.getText();
        update = new Document("$set", new Document("d1", dinner1));
        mongo.collection.updateOne(result, update);
        dinner2 = sunDinner2.getText();
        update = new Document("$set", new Document("d2", dinner2));
        mongo.collection.updateOne(result, update);
        dinner3 = sunDinner3.getText();
        update = new Document("$set", new Document("d3", dinner3));
        mongo.collection.updateOne(result, update);


        BorderPane view = FXMLLoader.load(getClass().getResource("home.fxml"));
        Scene scene = ((Node)event.getSource()).getScene();
        scene.setRoot(view);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        mongo.connectMessMenu();

        Document result = (Document) mongo.collection.find(new Document("day", "monday")).first();
        String breakfast1 = result.get("b1").toString();
        String breakfast2 = result.get("b2").toString();
        String breakfast3 = result.get("b3").toString();
        String lunch1 = result.get("l1").toString();
        String lunch2 = result.get("l2").toString();
        String lunch3 = result.get("l3").toString();
        String dinner1 = result.get("d1").toString();
        String dinner2 = result.get("d2").toString();
        String dinner3 = result.get("d3").toString();
        monBreakfast1.setText(breakfast1);
        monBreakfast2.setText(breakfast2);
        monBreakfast3.setText(breakfast3);
        monLunch1.setText(lunch1);
        monLunch2.setText(lunch2);
        monLunch3.setText(lunch3);
        monDinner1.setText(dinner1);
        monDinner2.setText(dinner2);
        monDinner3.setText(dinner3);

        result = (Document) mongo.collection.find(new Document("day", "tuesday")).first();
        breakfast1 = result.get("b1").toString();
        breakfast2 = result.get("b2").toString();
        breakfast3 = result.get("b3").toString();
        lunch1 = result.get("l1").toString();
        lunch2 = result.get("l2").toString();
        lunch3 = result.get("l3").toString();
        dinner1 = result.get("d1").toString();
        dinner2 = result.get("d2").toString();
        dinner3 = result.get("d3").toString();
        tueBreakfast1.setText(breakfast1);
        tueBreakfast2.setText(breakfast2);
        tueBreakfast3.setText(breakfast3);
        tueLunch1.setText(lunch1);
        tueLunch2.setText(lunch2);
        tueLunch3.setText(lunch3);
        tueDinner1.setText(dinner1);
        tueDinner2.setText(dinner2);
        tueDinner3.setText(dinner3);

        result = (Document) mongo.collection.find(new Document("day", "wednesday")).first();
        breakfast1 = result.get("b1").toString();
        breakfast2 = result.get("b2").toString();
        breakfast3 = result.get("b3").toString();
        lunch1 = result.get("l1").toString();
        lunch2 = result.get("l2").toString();
        lunch3 = result.get("l3").toString();
        dinner1 = result.get("d1").toString();
        dinner2 = result.get("d2").toString();
        dinner3 = result.get("d3").toString();
        wedBreakfast1.setText(breakfast1);
        wedBreakfast2.setText(breakfast2);
        wedBreakfast3.setText(breakfast3);
        wedLunch1.setText(lunch1);
        wedLunch2.setText(lunch2);
        wedLunch3.setText(lunch3);
        wedDinner1.setText(dinner1);
        wedDinner2.setText(dinner2);
        wedDinner3.setText(dinner3);

        result = (Document) mongo.collection.find(new Document("day", "thrusday")).first();
        breakfast1 = result.get("b1").toString();
        breakfast2 = result.get("b2").toString();
        breakfast3 = result.get("b3").toString();
        lunch1 = result.get("l1").toString();
        lunch2 = result.get("l2").toString();
        lunch3 = result.get("l3").toString();
        dinner1 = result.get("d1").toString();
        dinner2 = result.get("d2").toString();
        dinner3 = result.get("d3").toString();
        thruBreakfast1.setText(breakfast1);
        thruBreakfast2.setText(breakfast2);
        thruBreakfast3.setText(breakfast3);
        thruLunch1.setText(lunch1);
        thruLunch2.setText(lunch2);
        thruLunch3.setText(lunch3);
        thruDinner1.setText(dinner1);
        thruDinner2.setText(dinner2);
        thruDinner3.setText(dinner3);

        result = (Document) mongo.collection.find(new Document("day", "friday")).first();
        breakfast1 = result.get("b1").toString();
        breakfast2 = result.get("b2").toString();
        breakfast3 = result.get("b3").toString();
        lunch1 = result.get("l1").toString();
        lunch2 = result.get("l2").toString();
        lunch3 = result.get("l3").toString();
        dinner1 = result.get("d1").toString();
        dinner2 = result.get("d2").toString();
        dinner3 = result.get("d3").toString();
        friBreakfast1.setText(breakfast1);
        friBreakfast2.setText(breakfast2);
        friBreakfast3.setText(breakfast3);
        friLunch1.setText(lunch1);
        friLunch2.setText(lunch2);
        friLunch3.setText(lunch3);
        friDinner1.setText(dinner1);
        friDinner2.setText(dinner2);
        friDinner3.setText(dinner3);

        result = (Document) mongo.collection.find(new Document("day", "saturday")).first();
        breakfast1 = result.get("b1").toString();
        breakfast2 = result.get("b2").toString();
        breakfast3 = result.get("b3").toString();
        lunch1 = result.get("l1").toString();
        lunch2 = result.get("l2").toString();
        lunch3 = result.get("l3").toString();
        dinner1 = result.get("d1").toString();
        dinner2 = result.get("d2").toString();
        dinner3 = result.get("d3").toString();
        satBreakfast1.setText(breakfast1);
        satBreakfast2.setText(breakfast2);
        satBreakfast3.setText(breakfast3);
        satLunch1.setText(lunch1);
        satLunch2.setText(lunch2);
        satLunch3.setText(lunch3);
        satDinner1.setText(dinner1);
        satDinner2.setText(dinner2);
        satDinner3.setText(dinner3);

        result = (Document) mongo.collection.find(new Document("day", "sunday")).first();
        breakfast1 = result.get("b1").toString();
        breakfast2 = result.get("b2").toString();
        breakfast3 = result.get("b3").toString();
        lunch1 = result.get("l1").toString();
        lunch2 = result.get("l2").toString();
        lunch3 = result.get("l3").toString();
        dinner1 = result.get("d1").toString();
        dinner2 = result.get("d2").toString();
        dinner3 = result.get("d3").toString();
        sunBreakfast1.setText(breakfast1);
        sunBreakfast2.setText(breakfast2);
        sunBreakfast3.setText(breakfast3);
        sunLunch1.setText(lunch1);
        sunLunch2.setText(lunch2);
        sunLunch3.setText(lunch3);
        sunDinner1.setText(dinner1);
        sunDinner2.setText(dinner2);
        sunDinner3.setText(dinner3);
    }

}
