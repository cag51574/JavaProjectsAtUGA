public abstract class Player{

    private int score = 0;
//     abstract Player();

    protected int getScore() { 
        return score;
    }

    protected void setScore(int score){
        this.score = score;
    }

	
     
    abstract int[] makeMove(String piece, String otherPiece, String[][] squares);
}
