package easy.invest.controllers;

import easy.invest.exceptions.TitleAlreadyExists;
import easy.invest.services.ProjectService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CreateProjectController {
    @FXML
    private TextField titleField;
    @FXML
    private TextField descriptionField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField fundsField;
    @FXML
    public void create() throws IOException, TitleAlreadyExists {
        if (titleField.getText() == null || descriptionField.getText() == null || locationField.getText() == null || fundsField.getText() == null) {
            Parent mandatoryWindow = FXMLLoader.load(getClass().getResource("/mandatory.fxml"));
            Scene mandatoryScene = new Scene(mandatoryWindow);
            Stage window = new Stage();
            window.setScene(mandatoryScene);
            window.show();
        } else {
            Scanner scanner = null;
            String username = "";
            scanner = new Scanner(new File("log.txt"));
            username = scanner.next();
            ProjectService.addProject(titleField.getText(), descriptionField.getText(), (String) locationField.getText(), fundsField.getText(),username);
            Stage stage = (Stage)titleField.getScene().getWindow();
            stage.close();
        }
    }


    public void cancel() throws IOException {
        Parent modifyWindow = FXMLLoader.load(getClass().getResource("/modify_projects.fxml"));
        Scene modifyScene = new Scene(modifyWindow);
        Stage window = new Stage();
        window.setScene(modifyScene);
        window.show();
        Stage stage = (Stage)titleField.getScene().getWindow();
        stage.close();
    }
}