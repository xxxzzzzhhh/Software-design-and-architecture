import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(18);
        Player p1 = new Player(board,"Red", 1, 3);
        Player p2 = new Player(board, "Blue", 10, 3);
        board.addPlayer(p1);
        board.addPlayer(p2);
        board.startGame();

    }
}