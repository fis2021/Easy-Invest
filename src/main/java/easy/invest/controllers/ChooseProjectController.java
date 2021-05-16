package easy.invest.controllers;

import easy.invest.model.Project;
import easy.invest.services.ProjectService;
import javafx.fxml.FXML;

public class ChooseProjectController {
    @FXML
    public void select_projects() throws Exception {
        Project[] projects = new Project[1000];
        projects = ProjectService.verify();


    }
}
