package cs1302.fxgame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * The class that the bricks use
 */
public class Brick1 extends ImageView{
    //private Image stage1 = new Image();
    int w = 60;
    int h = 20;
    int x = 0;
    int y = 0;
    int stage = 2;
    Boolean exists= true;


   /**
    * The constructor for the brick class
    * @param x The starting x location
    * @param y The starting y location
    */
    Brick1(int x,int y){
        super("file:resources/Brick1.png");
        this.x = x;
        this.y = y;
        setTranslateX(x);
        setTranslateY(y);
    }


   /**
    * The constructor for the brick class
    * @param cx The balls current x location
    * @param cy The balls current y location
    * @param r The radius of the ball
    */
    protected int collision(float cx, float cy, float r){
        if(exists){
            float centerX = x + w/2;
            float centerY = y + h/2;
            float distX = Math.abs((int)cx - centerX);
            float distY = Math.abs((int)cy - centerY);
            if(distX > w/2 + r) return 0;
            if(distY > h/2 + r) return 0;
            if(distX <= w/2){
                nextStage();
                return 1;
            }
            if(distY <= h/2){
                nextStage();
                return 2;
            }
            if(((cx+ w/2)*(cx+ w/2)) + ((cy + h/2) *(cy + h/2))  <= r*r){
                stage--;
                nextStage();
                return 3;
            }
        }
        return 0;
    }


    /**
     * Changes the stage of the brick after a collision has been detected
     */
    private void nextStage(){
        stage--;
        if(stage < 0){
            setImage(new Image("file:resources/Brick4.png"));
            exists = false;
        }
        if(stage == 0) setImage(new Image("file:resources/Brick3.png"));
        if(stage == 1) setImage(new Image("file:resources/Brick2.png"));
    }

    /**
     * Checks to see if the brick exists
     * @return exists whether or not the brick exists
     */
    protected Boolean getExists(){
        return exists;
    }

}
