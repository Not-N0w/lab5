package ticketController.commands;

public abstract class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    public String name() {
        return name();
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract void execute();
}
