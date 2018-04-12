package cs1302.fxgame;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;

/**
 * This is the class for the text that displays current info about the game
 */
public class Banner extends Text{

    /**
     * The constructor for the Banner class
     */
    Banner(){
        setTranslateX(10);
        setTranslateY(20);
        setFill(Color.YELLOWGREEN);
    }
    
    /**
     * Updates the text with the current player lives and score
     * @param lives The number of lives the player has 
     * @param score The score that the player has 
     */
    protected void update(int lives, int score){
	   setText("Lives left: " + lives + "   Your score is: " + score);
    }
}
				       
