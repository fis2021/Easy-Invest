package easy.invest.controllers;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MandatoryController {
    @FXML
    private Text title;
    @FXML
    public void ok() {
        Stage stage = (Stage) title.getScene().getWindow();
        stage.close();
    }
}
