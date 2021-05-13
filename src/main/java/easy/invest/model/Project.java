package easy.invest.model;

public class Project {
    private String title, description, location;
    int funds;
    public Project(String title, String description, String location, String funds) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.funds = Integer.parseInt(funds);
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFunds(String funds) {
        this.funds = Integer.parseInt(funds);
    }

}
