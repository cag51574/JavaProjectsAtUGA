import java.io.File;
import java.util.Random;
import java.util.Scanner;
/**
 * This class represents a ReversiBoard game.
 *
 * @author Cameron Garratt <cag51574@uga.edu>
 * @author Travis Kelly <@uga.edu>
 */
public class ReversiBoard implements Board{

    public static void main(String[] args) {
        ReversiBoard game = null;
        try {
            String pX = args[0];
            String p0 = args[1];
            game = new ReversiBoard();
            game.setPlayers(pX, p0);
            game.run();
        } catch (NumberFormatException nfe) { 
            System.out.print("Usage: java ReversiBoard [pX] [pX]");
            System.exit(0);
        } // try

    } // Main
    private Player pX;
    private Player p0;
    private int flag1 = 0;
    private int round = 0;
    private int rows = 8;
    private int cols = 8;
    private String[][] squares = new String[rows][cols];
    private int score = 0;
    private String piece = "X";
    private String otherPiece = "0";
    //True means it is pX's turn
    Boolean turn = true;


    public ReversiBoard(){ // ReversiBoard

        // Human or Computer Player

        
        for(int i = rows-1; i>=0; i--){
            for(int j = cols-1; j>=0; j--){
                squares[i][j] = ".";
            }
        }

        //Mark starting squares
        squares[3][3] = "0";
        squares[4][4] = "0";
        squares[4][3] = "X";
        squares[3][4] = "X";
    }

    /**
     * Starts the game and execute the game loop.
     */
    public void run() {gameLoop();} // run 

    /**
     * This is the main game loop responsible for running the game.
     */

    public void gameLoop(){

        Scanner scanner = new Scanner(System.in); 
        String input1,input2;
        //Print initial board
        printBoard(squares);
        
        do{
            int[] move = new int[2];
            if (turn == true && checkPossibleMoves() != 0){
                move = pX.makeMove(piece, otherPiece, squares);
                squares[move[0]][move[1]] = piece;
                reverseSquares(move[0],move[1]);
            }else if(turn == false && checkPossibleMoves() != 0){
                move = p0.makeMove(piece, otherPiece, squares);
                squares[move[0]][move[1]] = piece;
                reverseSquares(move[0],move[1]);
            }

            checkWin();
            switchTurn();
            printBoard(squares);

            if(checkPossibleMoves() == 0){
                switchTurn();
		markPossibleMoves();
                if(checkPossibleMoves() == 0){
                    gameOver();
                }
            }
        }while (flag1 == 0);
        scanner.close();
        System.exit(0);
    }

    /*
     * Prints the game board
     */

    public void printBoard(String[][] squares){
        clearPossibleMoves();
        markPossibleMoves();
        System.out.println("...\n");
        System.out.print("\n   ");
        for(int i = 1; i<= cols; i++){
            System.out.print(i+" ");
        }
        for(int i = 1; i <= rows; i++){

            System.out.print("\n " + i);
            for(int j = 1; j <= cols; j++){
                
                System.out.print(" " + squares[i-1][j-1]);

            }
        }
        System.out.println("\n");
        System.out.print("Enter your move, " + piece + " player: ");    
    }
    
    public void setPlayers(String pX, String p0){

        pX = pX.toLowerCase();
        p0 = p0.toLowerCase();
        switch(pX){
        case "human":
            this.pX = new HumanPlayer();
            break;
        case "intelligentcomputerplayer":
            this.pX = new IntelligentComputerPlayer();
            break;
        case "randomcomputerplayer":
            this.pX = new RandomComputerPlayer();
            break;
        default:
            System.out.println("This was invalid input.");
            break;
        }
        switch(p0){
        case "human":
            this.p0 = new HumanPlayer();
            break;
        case "intelligentcomputerplayer":
            this.p0 = new IntelligentComputerPlayer();
            break;
        case "randomcomputerplayer":
            this.p0 = new RandomComputerPlayer();
            break;
        default:
            System.out.println("This was invalid input.");
            break;
        }
    }
        
   /*
    *This is only called when the game is over. :(
    */
    public void gameOver(){
        System.out.println("```");
        System.out.println("");
        System.out.println("The game has ended.");
        System.out.println("Player 1 score: " + pX.getScore() );
        System.out.println("Player 2 score: " + p0.getScore() );
        if(pX.getScore() > p0.getScore()){
            System.out.println("Congratulations player X, you win!");
        }else if(pX.getScore() < p0.getScore()){
            System.out.println("Congratulations player 0, you win!");
        }else{
            System.out.println("It was a tie!!!");
        }
        System.out.println("");
        System.out.println("```");
        flag1 = 1;
        System.exit(0);
    }

    /**
     * Reverses the squares when a move is made.
     */

    public void reverseSquares(int x, int y) {
       int m = x;
       int n = y;
       boolean flag = true;
       int count = 0;


       while(flag == true){
           m--; n--;
           if(m >= 0 && n >= 0){
               if(squares[m][n]==piece){
                   for(int i = 0;i <=count; i++){
		       if((x-i != -1) && (y-i!=-1)){
                           squares[x-i][y-i] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[m][n] == otherPiece){
                       count++;
               }else{flag = false;}
           }else{flag = false;}
       }
       flag = true;
       m = x;
       n = y;
       count = 0;


       while(flag == true){
           m++; n--;
           if(m < 8 && n >= 0){
               if(squares[m][n]==piece){
                   for(int i = 0;i <=count; i++){
		       if((x+i != 8) && (y-i!=-1)){
                           squares[x+1][y-1] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[m][n] == otherPiece){
                       count++;
               }else{flag = false;}
           }else{flag = false;}
       }
       flag = true;
       m = x;
       n = y;
       count = 0;


       while(flag == true){
           m--; n++;
           if(m >= 0 && n < 8){
               if(squares[m][n]==piece){
                   for(int i = 0;i <=count; i++){
		       if((x-i > -1) && (y+i<8)){
                           squares[x-i][y+i] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[m][n] == otherPiece){
                       count++;
               }else{flag = false;}
           }else{flag = false;}
       }
       flag = true;
       m = x;
       n = y;
       count = 0;


       while(flag == true){
           m++; n++;
           if(m < 8 && n < 8){
               if(squares[m][n]==piece){
                   for(int i = 0;i <=count; i++){
		       if((x+i < 8) && (y+i < 8)){
                           squares[x+i][y+i] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[m][n] == otherPiece){
                       count++;
               }else{flag = false;}
           }else{flag = false;}
       }
       flag = true;
       m = x;
       n = y;
       count = 0;
       

       while(flag == true){
           m--;
           if(m >= 0){
               if(squares[m][y]==piece){
                   for(int i = 0;i <=count; i++){
		       if(x-i > -1){
                           squares[x-i][y] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[m][y] == otherPiece){
                       count++;
               }else{flag = false;}
           }else{flag = false;}
       }
       flag = true;
       m = x;
       n = y;
       count = 0;


       while(flag == true){
           n--;
           if(n >= 0){
               if(squares[x][n]==piece){
                   for(int i = 0;i <=count; i++){
		       if(y-i >-1){
                           squares[x][y-i] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[x][n] == otherPiece){
                           count++;
               }else{flag = false;}
           }else{flag = false;}
       }
       flag = true;
       m = x;
       n = y;
       count = 0;


       while(flag == true){
           m++;
           if(m < 8){
               if(squares[m][y]==piece){
                   for(int i = 0;i <=count; i++){
		       if(x+i < 8){
                           squares[x+i][y] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[m][y] == otherPiece){
                           count++;
               }else{flag = false;}
           }else{flag = false;}
       }
       flag = true;
       m = x;
       n = y;
       count = 0;


       while(flag == true){
           n++;
           if(n < 8){
               if(squares[x][n]==piece){
                   for(int i = 0;i <=count; i++){
		       if(y+i < 8){
                           squares[x][y+i] = piece;
		       }
                   }
                   flag = false;
               }else if(squares[x][n] == otherPiece){
                   count++;
               }else{flag = false;}
           }else{flag = false;}
       }
    }


    /**
     * Marks the board with "_" for every possible move for that player.
     */
    public void markPossibleMoves(){
        for(int x = 0; x <rows;x++){
            for(int y = 0; y <cols;y++){
                if(squares[x][y] == piece){
                    int m = x;
                    int n = y;
                    boolean flag = true;
                    int count = 1;
                    while(flag == true){
                        m--; n--;
                        if(m >= 0 || n >= 0){
			    try{
                                if(squares[m][n] == otherPiece){count++;}
                                else if(squares[m][n] == "." && count > 1){
                                    squares[m][n] = "_";
                                    flag = false;
                                } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                    flag = true;
                    m = x;
                    n = y;
                    count = 1;
                    while(flag == true){
                        m++; n--;
                        if(m < 8 || n >= 0){
			    try{
                                if(squares[m][n] == otherPiece){count++;}
                                else if(squares[m][n] == "." && count > 1){
                                    squares[m][n] = "_";
                                    flag = false;
                                } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                    flag = true;
                    m = x;
                    n = y;
                    count = 1;
                    while(flag == true){
                        m--; n++;
                        if(m >= 0 || n < 8){
			    try{
                                if(squares[m][n] == otherPiece){count++;}
                                else if(squares[m][n] == "." && count > 1){
                                    squares[m][n] = "_";
                                    flag = false;
                                } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                    flag = true;
                    m = x;
                    n = y;
                    count = 1;
                    while(flag == true){
                        m++; n++;
                        if(m < 8 || n < 8){
			    try{
                                if(squares[m][n] == otherPiece){count++;}
                                else if(squares[m][n] == "." && count > 1){
                                    squares[m][n] = "_";
                                    flag = false;
                                } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                    flag = true;
                    m = x;
                    n = y;
                    count = 1;
                    while(flag == true){
                        m--;
                        if(m >= 0){
			    try{
                                if(squares[m][y] == otherPiece){count++;}
                                else if(squares[m][y] == "." && count > 1){
                                    squares[m][y] = "_";
                                    flag = false;
                                } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                    flag = true;
                    m = x;
                    n = y;
                    count = 1;
                    while(flag == true){
                        n--;
                        if(n >= 0){
			    try{
                                if(squares[x][n] == otherPiece){count++;}
                                else if(squares[x][n] == "." && count > 1){
                                    squares[x][n] = "_";
                                    flag = false;
                                } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                    flag = true;
                    m = x;
                    n = y;
                    count = 1;
                    while(flag == true){
                        m++;
                        if(m < 8){
			    try{
                                 if(squares[m][y] == otherPiece){count++;}
                                 else if(squares[m][y] == "." && count > 1){
                                     squares[m][y] = "_";
                                     flag = false;
                                 } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                    flag = true;
                    m = x;
                    n = y;
                    count = 1;
                    while(flag == true){
                        n++;
                        if(n < 8){
			    try{
                                if(squares[x][n] == otherPiece){count++;}
                                else if(squares[x][n] == "." && count > 1){
                                    squares[x][n] = "_";
                                    flag = false;
                                } else{flag = false;}
			    }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                }
            }
        }
    }

    private void clearPossibleMoves() {
       for(int i = 0; i <rows;i++){
          for(int j = 0; j <cols;j++){
             if(squares[i][j] == "_"){
                 squares[i][j] = ".";
             }
          }
       }
    }

    private void switchTurn(){
        if(piece == "X"){
            piece = "0";
        } else if (piece == "0"){
            piece = "X";
        }
        if(otherPiece == "X"){
            otherPiece = "0";
        } else if (otherPiece == "0"){
            otherPiece = "X";
        }
        if(turn == true){
            turn = false;
        }else if ( turn == false) {
            turn = true;
        }
    }

    private void checkWin(){
        int countX = 0;
        int count0 = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(squares[i][j] == "X"){
                    countX++;
                }
                if(squares[i][j] == "0"){
                    count0++;
                }
            }
        }
        pX.setScore(countX);
        p0.setScore(count0);
    }

    private int checkPossibleMoves(){
        int count_ = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(squares[i][j] == "_"){
                    count_++;
                }
            }
        }
        return count_;
    }
} // ReversiBoard
