package cs1302.fxgame;
import java.util.*;
import java.lang.Math;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Circle.*;

/**
 * The Ball in the game extends a circle
 */
public class Ball extends Circle{
    float x = 0;
    float y = 0;
    float dx = 3;
    float dy = 5;
    float ddx = 0.1f;
    float ddy = 0.1f;
    float r = 10;



   /**
    * The constructor for the ball class
    * @param x The starting x coordinate for the ball
    * @param y The starting y coordinate for the ball
    * @param r The radius of the ball
    */
    Ball(float x,float y, float r){
        this.x = x;
        this.y = y;
        this.r = r;
        setFill(Color.PURPLE);
        setCenterX(y);
        setCenterY(x);
        setRadius(r);
    }
    
   /**
    * Updates the ball locaton and checks to see if you died
    */
    protected Boolean update(){
        move();
        if(checkDeath())return true;
        return false;
    }

   /**
    * Updates the ball locaton
    */
    protected void move(){
        //dx = dx + ddx;
        //dy = dy + ddy;
        x  = (float)getCenterX() + (float)getTranslateX()+ dx;
        y  = (float)getCenterY() + (float)getTranslateY()+ dy;
        setTranslateX(getTranslateX() + dx);
        setTranslateY(getTranslateY() + dy);
        if (x > BrickBreaker.WIDTH - r) dx = -Math.abs(dx);
        if (x < 0 + r) dx = Math.abs(dx);
        if (y < 0 + r) dy = Math.abs(dy);
    }

   /**
    * Checks to see if you died
    */
    private Boolean checkDeath(){
        if (y > BrickBreaker.HEIGHT + r){ 
            x = (float)getCenterX();
            y = (float)getCenterY();
            setTranslateX(0);
            setTranslateY(0);
         
            dx = 5; dy = 3;
            return true;
        }
        return false;
    }

   /**
    * @return current x location
    */
    protected float getx(){
        return x;
    }

   /**
    * @return current y location
    */
    protected float gety(){
        return y;
    }

   /**
    * @return current radius
    */
    protected float getr(){
        return r;
    }

   /**
    * @return current change in x 
    */
    protected float getdx(){
        return dx;
    }

   /**
    * @return current change in y 
    */
    protected float getdy(){
        return dy;
    }

   /**
    * Sets the current x speed
    * @param dx new x speed
    */
    protected void setdx(float dx){
        this.dx = dx;
    }

   /**
    * Sets the current y speed
    * @param dy new y speed
    */
    protected void setdy(float dy){
        this.dy = dy;
    }
}
                       
