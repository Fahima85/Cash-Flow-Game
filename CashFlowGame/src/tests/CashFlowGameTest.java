package tests;

import main.java.be.vub.cashflow.game.Game;
import main.java.be.vub.cashflow.game.GameBoard;
import main.java.be.vub.cashflow.game.Player;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CashFlowGameTest {

    private Game game;
    private GameBoard gameBoard;
    private Player player;
    private static final int GRID_SIZE = 20;

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Before
    public void setUp() {
        // Initialize the game board
        this.gameBoard = new GameBoard(GRID_SIZE);
        // Create dynamic tiles
        this.gameBoard.createTiles();
        // Add players
        this.player = new Player("Shakil");
        this.game = new Game(this.gameBoard, this.player);

    }

}
