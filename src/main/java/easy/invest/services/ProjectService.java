package easy.invest.services;

import easy.invest.exceptions.TitleAlreadyExists;
import easy.invest.model.Project;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import static easy.invest.services.FileSystemService.getPathToFile;
public class ProjectService {

    private static ObjectRepository<Project> projectRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("easy-invest2.db").toFile())
                .openOrCreate("test", "test");

        projectRepository = database.getRepository(Project.class);
    }

    public static void addProject(String title, String description, String location, String funds, String username) throws TitleAlreadyExists {
        checkProjectDoesNotAlreadyExist(title);
        projectRepository.insert(new Project(title,description,location,funds,username));
    }

    private static void checkProjectDoesNotAlreadyExist(String title) throws TitleAlreadyExists {
        for (Project project : projectRepository.find()) {
            if (Objects.equals(title, project.getTitle()))
                throw new TitleAlreadyExists(title);
        }
    }

    public static Project[] verify() throws FileNotFoundException {
        Project[] projects = new Project[10];
        int contor = 0;
        for(Project project : projectRepository.find()) {
            Scanner scanner = null;
            String username = "";
            scanner = new Scanner(new File("log.txt"));
            username = scanner.next();
            if(username.equals(project.getUsername())){
                if (projects.length <= contor) {
                    Project[] aux = new Project[contor*2];
                    for(int i = 0; i < contor; i++) {
                        aux[i] = projects[i];
                        projects = aux;
                    }
                }
                projects[contor] = project;
                contor++;
            }
        }
        return projects;
    }

}
