package cs1302.fxgame;

import javafx.scene.text.*;
import com.michaelcotterell.game.Game;
import com.michaelcotterell.game.GameTime;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle.*;
import javafx.scene.shape.Circle.*;
import javafx.stage.Stage;
import java.lang.Math;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Main Game extends game
 */
public class BrickBreaker extends Game {
    final public static int WIDTH = 640;
    final public static int HEIGHT = 480;
    private int currentLevel = 1;

    private int score;

    Brick1[] level = Levels.getLevel1();

    // rectangle to hold the background
    private Rectangle bg = new Rectangle(0, 0, WIDTH, HEIGHT) {{ 
         setFill(Color.BLACK); 
    }};
    
    //x,y,raduis
    private Ball b = new Ball(100.0f,100.0f,10.0f);

    //x,y,width,hight
    private Player p = new Player(20, 440, 100, 10);

    // some text to display the time
    private Banner text = new Banner();

    /**
     * Constructs a new test game.
     * @param stage the primary stage
     */
    public BrickBreaker(Stage stage) {
        super(stage, "TestGame", 60, 640, 480);
        getSceneNodes().getChildren().addAll(bg);
        for(Brick1 i : level){
            getSceneNodes().getChildren().addAll(i);
        }
        getSceneNodes().getChildren().addAll(text,p,b);
    } // TestGame

    /**
     * Updates the game
     * @param game The main game class
     * @param gameTime the time in the game
     */
    @Override
    public void update(Game game, GameTime gameTime) {
        //Movement for player
        if (game.getKeyManager().isKeyPressed(KeyCode.LEFT) && p.getx() >= 0) p.setTranslateX(p.getTranslateX() - 8);
        if (game.getKeyManager().isKeyPressed(KeyCode.RIGHT)&& p.getx() + p.getw()  <= WIDTH) p.setTranslateX(p.getTranslateX() + 8);



        checkPlayerCollision();
        p.update();

        text.update(p.getLives(),score);



        //Updates the ball and checks lives
        if(b.update()){
            p.looseLife();
            if(p.getLives() < 0){
                gameOver();
            }else{
                b.setTranslateX(0);
                b.setTranslateY(0);
            }
        }

        //Loop through bricks and check collisions.
        int count = 0;
        for(Brick1 i : level){
            if(i.getExists()){
                count++;
                int n = i.collision(b.getx(),b.gety(),b.getr());
                if(n == 1)b.setdy(-b.getdy());
                if(n == 2)b.setdx(-b.getdx());
                if(n == 3){ b.setdy(-b.getdy()); b.setdx(-b.getdx()); }
                if(!i.getExists()){
                    score++;
                }
            }
        }
        if(count == 0){
            nextLevel();
        }
    } // update


    /**
     * Checks to see if the ball collided with the paddle
     */
    private void checkPlayerCollision(){
        float bx = b.getx();
        float by = b.gety();
        float r = b.getr();

        //If there is a collision, bounce the ball back in a direction
        //corresponding to where on the paddle the ball hit
        if(p.collision(b.getx(),b.gety(),b.getr())){
            b.setdy(-Math.abs(b.getdy()));
            float px = p.getx();
            float pw = p.getw();
            if(bx > px && bx <= px + pw/7) b.setdx(-4.0f);
            if(bx > px + (pw/7) && bx <= px + 2*(pw/7)) b.setdx(-2.0f); 
            if(bx > px + 2*(pw/7) && bx <= px + 3*(pw/7)) b.setdx(-1.0f); 
            if(bx > px + 3*(pw/7) && bx <= px + 4*(pw/7)) b.setdx(0.0f); 
            if(bx > px + 4*(pw/7) && bx <= px + 5*(pw/7)) b.setdx(1.0f); 
            if(bx > px + 5*(pw/7) && bx <= px + 6*(pw/7)) b.setdx(2.0f); 
            if(bx > px + 6*(pw/7) && bx <= px +pw) b.setdx(4.0f);
        }
    }

    /**
     * Moves to the next Level or calls the win method
     */
    private void nextLevel(){
        switch(currentLevel){
            case 1: 
                level = Levels.getLevel2();
                //increase ball speed by 1
                b.setdy(b.getdy() + 1);
                currentLevel++;
                p.gainLife();
                b.setTranslateX(0);
                b.setTranslateY(0);
                //prepare screen for next level
                getSceneNodes().getChildren().clear();
                getSceneNodes().getChildren().addAll(bg);
                for(Brick1 i : level){
                    getSceneNodes().getChildren().addAll(i);
                }
                getSceneNodes().getChildren().addAll(text,p,b);
                break;
            case 2: 
                level = Levels.getLevel3();
                currentLevel++;
                //increase ball speed by 1
                b.setdy(b.getdy() + 1);
                p.gainLife();
                b.setTranslateX(0);
                b.setTranslateY(0);
                //prepare screen for next level
                getSceneNodes().getChildren().clear();
                getSceneNodes().getChildren().addAll(bg);
                for(Brick1 i : level){
                    getSceneNodes().getChildren().addAll(i);
                }
                getSceneNodes().getChildren().addAll(text,p,b);
                break;
            case 3: 
                level = Levels.getLevel4();
                currentLevel++;
                //increase ball speed by 1
                b.setdy(b.getdy() + 1);
                p.gainLife();
                b.setTranslateX(0);
                b.setTranslateY(0);
                //prepare screen for next level
                getSceneNodes().getChildren().clear();
                getSceneNodes().getChildren().addAll(bg);
                for(Brick1 i : level){
                    getSceneNodes().getChildren().addAll(i);
                }
                getSceneNodes().getChildren().addAll(text,p,b);
                break;
            case 4: 
                win();
                break;

        }

    }

    /**
     * Called if the game is won. Changes screen to a you won screen.
     */
    private void win(){
        Text t1 = new Text("Congradulations!!");
        Text t2 = new Text("You Won The Game!");
        t1.setTranslateY(170);
        t2.setTranslateY(280);
        t1.setFill(Color.GREEN);
        t1.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        t2.setFill(Color.BLUE);
        t2.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        getSceneNodes().getChildren().clear();
        getSceneNodes().getChildren().addAll(t1,t2);

    }

    /**
     * Called if the game is over. Changes screen to a you lost screen.
     */
    private void gameOver(){
        Text t1 = new Text("Game Over!");
        Text t2 = new Text("You have lost.");
        t1.setTranslateY(170);
        t2.setTranslateY(280);
        t1.setFill(Color.RED);
        t1.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        t2.setFill(Color.RED);
        t2.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        getSceneNodes().getChildren().clear();
        getSceneNodes().getChildren().addAll(t1,t2);
        if(p.getLives() == -2){
            System.exit(0);
        }
    }
} // TestGame

