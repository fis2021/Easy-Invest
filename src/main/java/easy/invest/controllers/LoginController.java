package easy.invest.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {
    public static Stage stg;
    @FXML
    private Text loginMessage;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    public void goToRegistration() throws Exception {
        Parent registrationWindow = FXMLLoader.load(getClass().getResource("register.fxml"));
        Scene registrationScene = new Scene(registrationWindow);
        Stage window = new Stage();
        window.setScene(registrationScene);
        window.show();
    }
}

