import java.util.ArrayList;
import java.util.Random;

public class Board {
    private int boardPositions;
    private ArrayList<Player> players;
    private int turnCount; //回合数\\\\\
    private int currentPlayerIndex;

    public Board() {}

    public Board(int boardPositions) {
        this.boardPositions = boardPositions;
        players = new ArrayList<>();
        this.currentPlayerIndex = 0;  // 从第一个玩家开始
        this.turnCount = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public int rollDice(){
        return new Random().nextInt(12) + 1;
    }

    public void startGame() {
        while (true){
            //玩家轮换
            currentPlayerIndex = currentPlayerIndex % players.size();
            Player currentPlayer = players.get(currentPlayerIndex);

            int stepNumber = rollDice();
            currentPlayer.move(stepNumber);
            currentPlayer.setMoves(currentPlayer.getMoves() + 1);

            if (currentPlayer.isWin()){
                System.out.println(currentPlayer.getColor() + " wins in " + currentPlayer.getMoves() + " moves!");
                break;
            }
            //下一个玩家
            currentPlayerIndex++;
            //回合数 + 1
            turnCount++;
        }
        System.out.println("Total plays " + turnCount);
    }

    public int getBoardPositions() {
        return boardPositions;
    }

    public void setBoardPositions(int boardPositions) {
        this.boardPositions = boardPositions;
    }
}
