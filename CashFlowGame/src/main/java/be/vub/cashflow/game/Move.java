package main.java.be.vub.cashflow.game;

public enum Move implements Command {

    K("Up", "Move UP one step."),
    L("Right", "Move RIGHT one step."),
    J("Down", "Move DOWN one step."),
    H("Left", "Move LEFT one step.");

    private final String name;
    private final String description;

    Move(String name, String description) {
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
