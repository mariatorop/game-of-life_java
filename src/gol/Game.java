package gol;

public class Game {

    private static final int[][] NEIGHBOURS = {
            {-1, -1}, {-1, 0}, {-1, +1},
            { 0, -1},          { 0, +1},
            {+1, -1}, {+1, 0}, {+1, +1}};

    int row = 15;
    int col = 20;
    boolean[][] board = new boolean[row][col];

    public void markAlive(int x, int y) {
        board[x][y] = true;
    }

    public boolean isAlive(int x, int y) {
        if (x < 0 || x >= row){
            return false;
        }if (y < 0 || y >= col){
            return false;
        }
        return board[x][y];
    }

    public void toggle(int x, int y) {
        if (!board[x][y]){
            board[x][y] = true;
        }else if (board[x][y]){
            board[x][y] = false;
        }
    }

    public Integer getNeighbourCount(int x, int y) {
        int count = 0;
        for (int[] neig : NEIGHBOURS) {
            if (isAlive(x + neig[0], y + neig[1])){
                count++;
            }
        }
        return count;
    }

    public void nextFrame() {
        boolean[][] newBoard = new boolean[row][col];

        for (int y = 0; y < col; y++) {
            for (int x = 0; x < row; x++) {
                int neighbours = getNeighbourCount(x, y);
                boolean isLiving = isAlive(x, y);
                newBoard[x][y] = nextState(isLiving, neighbours);
            }
        }this.board = newBoard;
    }

    public void clear() {
        for (int y = 0; y < col; y++) {
            for (int x = 0; x < row; x++) {
                board[x][y] = false;
            }
        }
    }

    public boolean nextState(boolean isLiving, int neighborCount) {
        if (isLiving && (neighborCount == 2 || neighborCount == 3)){
            return true;
        }else {
            return !isLiving && neighborCount == 3;
        }
    }

}
