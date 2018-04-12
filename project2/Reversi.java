
class Reversi {
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

}
