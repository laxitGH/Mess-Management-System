import java.net.URL;
import java.util.ResourceBundle;

import org.bson.Document;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class AppController implements Initializable{

    public static String validUser;

    @FXML
    private PasswordField enteredPassword;
    @FXML
    private TextField enteredUserName;
    @FXML
    private Label instituteTitle;
    @FXML
    private Button login;
    @FXML
    private Label wrongPasswordNote;
    @FXML
    private BorderPane appWindow;

    @FXML
    void loginAction(ActionEvent event) throws Exception {
        String username = enteredUserName.getText();
        String password = enteredPassword.getText();
        Document result = (Document) mongo.collection.find(new Document("userName", username)).first();

        if(result == null){
            wrongPasswordNote.setText("Wrong Credentials !! Please Try Again.");
        } else{
            String databasePassword = result.get("password").toString();
            if(databasePassword.equals(password)){
                validUser = username;
                BorderPane view = FXMLLoader.load(getClass().getResource("home.fxml"));
                Scene scene = ((Node)event.getSource()).getScene();
                scene.setRoot(view);
            } else{
                wrongPasswordNote.setText("Wrong Credentials !! Please Try Again.");
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        mongo.connectInstituteManagement();
    }

}
