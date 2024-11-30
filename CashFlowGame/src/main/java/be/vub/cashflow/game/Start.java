package main.java.be.vub.cashflow.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();  // Reads a full line
        Player player2 = new Player(124, "");   // Another player

        Game game = new Game(player2);



        //scanner.close();

    }
}
