package main.java.be.vub.cashflow.game;

public enum General implements Command {

    EXIT("Exit", "Get out of the game."),
    HELP("Help", "Obviously you already know this one."),
    STATUS("Status", "Show status of yourself, including HP and item inventory."),
    ;

    private final String name;
    private final String description;

    General(String name, String description) {
        this.name = name;
        this.description = description;
    }


    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getName() {
        return name;
    }
}
