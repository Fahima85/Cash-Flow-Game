package main.java.be.vub.cashflow.game.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * Pool to parse and return the correct command.
 */
public class CommandPool {
    private static final Map<String, ICommand> commandMap = new HashMap<>();

    static {
        commandMap.put("go", new GoCommand());
        commandMap.put("look", new LookCommand());
        commandMap.put("take", new TakeCommand());
        commandMap.put("drop", new DropCommand());
        commandMap.put("inventory", new InventoryCommand());
        commandMap.put("help", new HelpCommand());
    }

    public static ICommand getCommand(String action) {
        return commandMap.getOrDefault(action.toLowerCase(), new UnknownCommand());
    }
}
