package main.java.be.vub.cashflow.game;

public class Character {
    private String name;
    private String message;

    public Character(String name) {
        this.name = name;
    }

    public Character(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
