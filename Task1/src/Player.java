import java.util.Random;

public class Player {
    private Board board;
    private String color;
    private int position; // 正常位置
    private int homePosition;
    private int tailEntrance;  // 尾巴入口
    private int tailLenth;
    private boolean inTail = false; //初始不在尾巴中
    private int tailPosition = 0; //如果进入尾巴,位置
    private boolean isWin;
    private int moves; // 移动次数
    private int steps;

    public Player() {}

    public Player(Board board, String color, int homePosition, int tailLenth) {
        this.board = board;
        this.color = color;
        this.position = homePosition; //初始位置在家
        this.homePosition = homePosition;
        this.tailEntrance = homePosition - 1;
        if (homePosition == 1) this.tailEntrance = board.getBoardPositions();
        this.tailLenth = tailLenth;
        this.steps = 0;
    }

    public void move(int step) {
        int boardSize = board.getBoardPositions();
        if (isWin) return;

        if (inTail) { // 1. 已在尾巴中
            int prev = tailPosition;
            tailPosition += step;
            if (tailPosition >= tailLenth) {
                System.out.println(color + " moves from TAIL (Tail Position " + prev + ") to End");
                isWin = true;
            } else {
                System.out.println(color + " moves from TAIL (Tail Position " + prev + ") to TAIL (Tail Position " + tailPosition + ")");
            }
            return;
        }

        // 2/3. 在主轨上
        if (canEnterTail(position, step)) { // 进入尾巴
            // 还差多少步到入口
            int stepsToEntrance = stepsToTarget(position, tailEntrance, boardSize);
            // 进入尾巴后的position（1起）
            tailPosition = step - stepsToEntrance + 1;
            if (tailPosition >= tailLenth) {
                System.out.println(color + " moves from Position " + position + " to End");
                isWin = true;
            } else {
                inTail = true;
                System.out.println(color + " moves from Position " + position + " to TAIL (Tail Position " + tailPosition + ")");
            }
        } else { // 普通移动
            int prev = position;
            int newPosition = ((position - 1 + step) % boardSize) + 1; // 1..boardSize
            position = newPosition;
            System.out.println(color + " moves from Position " + prev + " to Position " + newPosition);
        }
    }

    private int stepsToTarget(int from, int target, int boardSize) {
        if (target >= from) {
            return target - from;
        } else {
            return (boardSize - from) + target;
        }
    }
    // 判断玩家是否可以进入该尾巴位置
    public boolean canEnterTail(int position, int moveStep) {
        int needStep = stepsToTarget(position, tailEntrance, board.getBoardPositions());
        // 如果当前玩家的位置是尾巴入口位置，允许进入尾巴
        if (moveStep > needStep) {
            return true;
        }

        return false;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getHomePosition() {
        return homePosition;
    }

    public void setHomePosition(int homePosition) {
        this.homePosition = homePosition;
    }

    public int getTailEntrance() {
        return tailEntrance;
    }

    public void setTailEntrance(int tailEntrance) {
        this.tailEntrance = tailEntrance;
    }

    public int getTailLenth() {
        return tailLenth;
    }

    public void setTailLenth(int tailLenth) {
        this.tailLenth = tailLenth;
    }
    public boolean getIntail() {
        return inTail;
    }
    public void setIntail(boolean intail) {
        this.inTail = intail;
    }

    public int getTailPosition() {
        return tailPosition;
    }

    public void setTailPosition(int tailPosition) {
        this.tailPosition = tailPosition;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }
}
