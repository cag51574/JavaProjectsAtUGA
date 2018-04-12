import java.util.Scanner;
class HumanPlayer extends Player {


    public HumanPlayer(){
        System.out.println("Hi, I am a human player");
    }

   /**
    * Human Player makes a move.
    */
    protected int[] makeMove(String piece, String otherPiece, String[][] squares){
        Scanner scanner = new Scanner(System.in); 
        int[] location = new int[2];
        try{
            for(int i = 0; i < 2;i++){
                location[i] = scanner.nextInt()-1;
            }
            if (!squares[location[0]][location[1]].equals("_")){
                printBoard(squares);
                System.out.println("That move was not a valid move.");
                System.out.println("Please try again.");
                System.out.print("Enter your move, " + piece + " player: ");    
		return makeMove(piece,otherPiece, squares);
            }
        }catch(Exception e){
           printBoard(squares);
           System.out.println("This is not a valid input. Please try again: ");
           System.out.print("Enter your move, " + piece + " player: ");    
           makeMove(piece,otherPiece, squares);
        }
	return location;
    }

    
    /*
     * Reprints board if user enters invalid input.
     */
    private void printBoard(String[][] squares){

        System.out.println("...\n");
        
        System.out.print("\n   ");
        for(int i = 1; i<= 8; i++){
            System.out.print(i+" ");
        }
        for(int i = 1; i <= 8; i++){

            System.out.print("\n " + i);
            for(int j = 1; j <= 8; j++){
                
                System.out.print(" " + squares[i-1][j-1]);
            }
        }
        System.out.println("\n");
    }
}

