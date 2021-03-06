import java.util.Random;

class IntelligentComputerPlayer extends ComputerPlayer {

     public IntelligentComputerPlayer(){
            System.out.println("Hi, I am an Intelligent computer!");
            System.out.println("Prepare to be annihilated.");
     }

    protected int[] makeMove(String piece, String otherPiece, String[][] squares){
        think();
        int[] x = findMaxMove( piece, otherPiece, squares);
        return x;
    }

    
    protected void think(){
        try {
             Thread.sleep(1000);                 //1000 milliseconds is one second.
        } catch(InterruptedException ex) {
             Thread.currentThread().interrupt();
        }
    }

    private int[] findMaxMove(String piece, String otherPiece, String[][] squares){

        int[] mv = new int[2];
        int max = 0;
        for(int x = 0; x < 8;x++){
            for(int y = 0; y < 8;y++){
                if(squares[x][y] == "_"){
                    if((x == 0 && y == 0) || (x == 7 && y == 7) || (x == 7 && y == 0) || (x == 0 && y == 7)){
                        mv[0] = x;
                        mv[1] = y;
	                System.out.println(mv[0] + " " + mv[1]);
                        return mv;
                    }
                }
            }
        }
        for(int x = 0; x <8;x++){
            for(int y = 0; y <8;y++){
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = m;
                                    mv[1] = n;
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = m;
                                    mv[1] = n;
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = m;
                                    mv[1] = n;
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = m;
                                    mv[1] = n;
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = m;
                                    mv[1] = y;
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = x;
                                    mv[1] = n;
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = m;
                                    mv[1] = y;
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
                                else if(squares[m][n]!= piece && count > max){
                                    max = count;
                                    mv[0] = x;
                                    mv[1] = n;
                                    flag = false;
                                } else{flag = false;}
                            }catch(Exception e){flag = false;}
                        }else{flag = false;}
                    }
                }
            }
        }
	System.out.println(mv[0] + " " + mv[1]);
        return mv;
    }

    
}
