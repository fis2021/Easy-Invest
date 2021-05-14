package easy.invest.controllers;

import easy.invest.services.ProjectService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
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
    private Text errorMessage;
    public void create() {
        if (titleField.getText() == null || descriptionField.getText() == null || locationField.getText() == null || fundsField.getText() == null) {
            errorMessage.setVisible(true);
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
            } catch (Exception e) {
                errorMessage.setText(e.getMessage());
                errorMessage.setVisible(true);
            }
        }
    }


}