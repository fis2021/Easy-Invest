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
import java.io.FileNotFoundException;
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
            try {
                Scanner scanner = null;
                String username = "";
                try {
                    scanner = new Scanner(new File("log.txt"));
                    username = scanner.next();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                ProjectService.addProject(titleField.getText(), descriptionField.getText(), (String) locationField.getText(), fundsField.getText(),username);
                Parent modifyWindow = FXMLLoader.load(getClass().getResource("/modify_projects.fxml"));
                Scene modifyScene = new Scene(modifyWindow);
                Stage window = new Stage();
                window.setScene(modifyScene);
                window.show();
                Stage stage = (Stage) errorMessage.getScene().getWindow();
                stage.close();
            } catch (Exception e) {
                errorMessage.setVisible(true);
                errorMessage.setText(e.getMessage());
            }
        }
    }


    public void cancel() throws IOException {
        Parent modifyWindow = FXMLLoader.load(getClass().getResource("/modify_projects.fxml"));
        Scene modifyScene = new Scene(modifyWindow);
        Stage window = new Stage();
        window.setScene(modifyScene);
        window.show();
        Stage stage = (Stage) errorMessage.getScene().getWindow();
        stage.close();
    }
}