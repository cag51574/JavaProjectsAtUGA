interface Board{

    public abstract void printBoard(String[][] squares);
    public abstract void setPlayers(String pX, String p0);
    public abstract void markPossibleMoves();
    public abstract void reverseSquares(int i, int j);
    public abstract void gameLoop();
    public abstract void gameOver();
}
