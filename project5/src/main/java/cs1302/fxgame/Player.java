package cs1302.fxgame;
import java.util.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Circle.*;
import javafx.scene.input.KeyCode;
import com.michaelcotterell.game.Game;

/**
 * The class for the main paddle that bounces the ball
 */
public class Player extends Rectangle{
    private int lives = 2;
    private int x,y,w,h;

    /**
     * The constructor for the player class
     * @param x The starting x location for the player
     * @param y The starting y location for the player
     * @param width The width of the player 
     * @param height The height of the player
     */
    Player(int x,int y,int width, int hight){
    super(x,y,width,hight);
    this.x = x;
    this.y = y;
    this.w = width;
    this.h = hight;
    setFill(Color.BLUE);
    }
    
    /**
     * Updates the players location
     */
    protected void update(){
        x = (int)getTranslateX() + (int)getX();
        y = (int)getTranslateY() + (int)getY();
    }


    /**
     * Checks to see if there was a collision between the ball and the player
     * @param cx The current x location of the ball
     * @param cy The current y location of the ball
     * @param r The radius of the ball
     * @return Returns true if a collision happend
     */
    protected Boolean collision(float cx, float cy, float r){
        float centerX = x + w/2;
        float centerY = y + h/2;
        float distX = Math.abs((int)cx - centerX);
        float distY = Math.abs((int)cy - centerY);
        if(distX > w/2 + r) return false;
        if(distY > h/2 + r) return false;
        if(distX <= w/2) return true;
        if(distY <= h/2) return true;
        return (((cx+ w/2)*(cx+ w/2)) + ((cy + h/2) *(cy + h/2))  <= r*r);
        //return false;
    }

    /**
     * The player lost a life.
     */
    protected void looseLife(){
        lives--;
    }

    /**
     * The player beat a level and gained a life.
     */
    protected void gainLife(){
        lives++;
    }
           
    /**
     * Returns the current x location of the player
     * @return x
     */
    protected int getx(){
        return x;
    }

    /**
     * Returns the current y location of the player
     * @return y
     */
    protected int gety(){
        return y;
    }

    /**
     * Returns the current width of the player
     * @return w
     */
    protected int getw(){
        return w;
    }
    
    /**
     * Returns the current height of the player
     * @return h
     */
    protected int geth(){
        return h;
    }

    /**
     * Returns the number of lives a player has
     * @return lives 
     */
    protected int getLives(){
        return lives;
    }

}
                       
