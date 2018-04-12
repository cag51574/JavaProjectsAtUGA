import java.util.Random;

class RandomComputerPlayer extends ComputerPlayer {


     public RandomComputerPlayer(){
         System.out.println("Hi, I am a Random computer!");
         System.out.println("My randomness makes me stupid.");
     }

    protected int[] makeMove(String piece, String otherPiece, String[][] squares){
	think();

        Random random = new Random();
        for(int i = 0; i <  2; i++){
            int x = random.nextInt(8);
            int y = random.nextInt(8);
            if(squares[x][y] == "_"){
		squares[x][y] = piece;
                int mv[] = {x,y};
		System.out.println((x+1) + " " +(y+1));
                return mv;
            } else {
                i--;
            }
        }
	return null;
        
    }
    protected void think(){
        try {
             Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
             Thread.currentThread().interrupt();
        }
    }
}
