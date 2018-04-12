
package cs1302.fxgame;

import com.michaelcotterell.game.Game;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main Driver class has boiler plate code for the game.
 */
public class Driver extends Application {

    /**
     * Starts the main game
     * @param primaryStage The main stage of the game
     */
    @Override
    public void start(Stage primaryStage) throws Exception { 
        Game game = new BrickBreaker(primaryStage);
        primaryStage.setTitle(game.getTitle());
        primaryStage.setScene(game.getScene());
        primaryStage.show();
        game.run();
    } // start
    

    /**
     * Launches the main game
     * @param args Any command line arguments (not used)
     */
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver

