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

import java.io.FileWriter;

public class LoginController {
    public static Stage stg;
    @FXML
    private Text loginMessage;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public static String user;

    public void goToRegistration() throws Exception {
        Parent registrationWindow = FXMLLoader.load(getClass().getResource("/register.fxml"));
        Scene registrationScene = new Scene(registrationWindow);
        Stage window = new Stage();
        window.setScene(registrationScene);
        window.show();
        Stage stage = (Stage) loginMessage.getScene().getWindow();
        stage.close();
    }

    public void login() throws Exception {
        if (UserService.verify(username.getText(), password.getText()) == 1) {
            loginMessage.setText("successful login!");
            String file = "log.txt";
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(username.getText()+" "+"Project Manager");
            fileWriter.close();
            Parent modifyWindow = FXMLLoader.load(getClass().getResource("/modify_projects.fxml"));
            Scene modifyScene = new Scene(modifyWindow);
            Stage window = new Stage();
            window.setScene(modifyScene);
            window.show();
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            stage.close();
            return;
        }
        if (UserService.verify(username.getText(), password.getText()) == 2) {
            //go to investor first screen
            loginMessage.setText("successful login!");
            String file = "log.txt";
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(username.getText()+" "+"Investor");
            fileWriter.close();
            Stage stage = (Stage) loginMessage.getScene().getWindow();
            stage.close();
            return;
        }
        if (UserService.verify(username.getText(), password.getText()) == 0) {
            loginMessage.setText("Incorrect password!");
            return;
        }
        loginMessage.setText("There is no account with that username!");
    }
}

