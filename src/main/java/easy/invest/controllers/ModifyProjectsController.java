package easy.invest.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModifyProjectsController {
    public void goToCreate() throws Exception {
        Parent createWindow = FXMLLoader.load(getClass().getResource("/create_project.fxml"));
        Scene createScene = new Scene(createWindow);
        Stage window = new Stage();
        window.setScene(createScene);
        window.show();
    }

    public void goToEdit() throws Exception {
        Parent editWindow = FXMLLoader.load(getClass().getResource("/edit_project.fxml"));
        Scene editScene = new Scene(editWindow);
        Stage window = new Stage();
        window.setScene(editScene);
        window.show();
    }

    public void goToDelete() throws Exception {
        Parent deleteWindow = FXMLLoader.load(getClass().getResource("/delete_project.fxml"));
        Scene deleteScene = new Scene(deleteWindow);
        Stage window = new Stage();
        window.setScene(deleteScene);
        window.show();
    }
}