package cs1302.calc;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.*;
import java.io.IOException;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.*;
 
public class Driver extends Application {

    public static void main(String[] args) {
        launch(args);
    } // main
    
    @Override
    public void start(Stage primaryStage) {

        Parent root = null;
        //Konami k = new Konami(primaryStage);
        try {
            root = FXMLLoader.load(getClass().getResource("/mainThing.fxml"));
        } catch (IOException e) {
            System.out.println(e);
            System.exit(1);
        } // try

        primaryStage.setTitle("CalcFX!");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();

    } // start

} // Driver


