package easy.invest.controllers;

import easy.invest.model.Project;
import easy.invest.services.ProjectService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ChooseProjectController {
    @FXML
    private ListView project_list;
    @FXML

    public void initialize() throws FileNotFoundException {
        List<Project> projects = new ArrayList<Project>();
        projects = ProjectService.verify();
        for (Project project : projects) {
            project_list.getItems().add(project.getTitle());
        }
    }
}
