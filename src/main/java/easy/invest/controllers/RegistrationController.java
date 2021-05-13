package easy.invest.controllers;

import easy.invest.exceptions.UsernameAlreadyExists;
import easy.invest.services.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegistrationController {
    @FXML
    private Text registrationMessage;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    private ChoiceBox role;

    @FXML
    public void initialize() {
        role.getItems().addAll("Project Manager", "Investor");
    }
    @FXML
    public void handleRegisterAction() {
        try {
            UserService.addUser(usernameField.getText(), passwordField.getText(), (String) role.getValue());
            registrationMessage.setText("Account created successfully!");
        }catch (UsernameAlreadyExists e) {
            registrationMessage.setText(e.getMessage());
        }
    }

    public void goToLogin() throws Exception {
        Parent loginWindow = FXMLLoader.load(getClass().getResource("/login.fxml"));
        Scene loginScene = new Scene(loginWindow);
        Stage window = new Stage();
        window.setScene(loginScene);
        window.show();
    }

}
