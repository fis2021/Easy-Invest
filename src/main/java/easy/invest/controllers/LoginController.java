package easy.invest.controllers;

import easy.invest.services.UserService;
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
        Parent registrationWindow = FXMLLoader.load(getClass().getResource("/register.fxml"));
        Scene registrationScene = new Scene(registrationWindow);
        Stage window = new Stage();
        window.setScene(registrationScene);
        window.show();
    }

    public void login() throws Exception {
        if (UserService.verify(username.getText(), password.getText()) == 1) { //go to project manager first screen
            return;
        }
        if (UserService.verify(username.getText(), password.getText()) == 2) { //go to sponsor first screen
            return;
        }
        if (UserService.verify(username.getText(), password.getText()) == 0) {
            loginMessage.setText("Incorrect password!");
            return;
        }
        loginMessage.setText("There is no account with that username!");
    }
}

