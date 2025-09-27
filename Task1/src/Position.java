public class Position {
    private int positionNumber;
    private Player occupyingPlayer;  // 记录占用该位置的玩家

    public Position(int positionNumber) {
        this.positionNumber = positionNumber;
        this.occupyingPlayer = null;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

    public boolean isOccupied() {
        return occupyingPlayer != null;  // 判断位置是否被占用
    }

    public void setOccupied(Player player) {
        this.occupyingPlayer = player;
    }

    public void removeOccupant() {
        this.occupyingPlayer = null;  // 清空占用该位置的玩家
    }

    public Player getOccupyingPlayer() {
        return occupyingPlayer;
    }
}
