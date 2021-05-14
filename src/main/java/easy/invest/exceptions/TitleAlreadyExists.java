package easy.invest.exceptions;

public class TitleAlreadyExists extends Exception{
    private final String title;

    public TitleAlreadyExists(String title) {
        super(String.format("A project with the title %s already exists!", title));
        this.title = title;
    }
    public String getUsername() {
        return title;
    }
}
