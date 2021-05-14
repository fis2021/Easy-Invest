package easy.invest.model;

public class Project {
    private String title, description, location;
    private final String username;
    int funds;
    public Project(String title, String description, String location, String funds, String username) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.funds = Integer.parseInt(funds);
        this.username = username;
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

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public int getFunds() {
        return this.funds;
    }

    public String getUsername() {
        return this.username;
    }
}
