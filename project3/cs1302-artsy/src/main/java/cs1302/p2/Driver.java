
import cs1302.effects.Artsy;
import cs1302.p2.MyArtsy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import java.net.URL;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.io.File;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;

import javafx.stage.FileChooser;
import javafx.scene.control.ButtonBar.ButtonData;

import java.awt.Desktop;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {
    private String imageLocation1 = "resources/default.png";
    private String imageLocation2 = "resources/default.png";
    private Image default1 = new Image("file:resources/default.png");
    private Image image1 = new Image("file:resources/default.png");
    private Image image2 = new Image("file:resources/default.png");
    private Image image3 = new Image("file:resources/default.png");
    
    private ImageView iv1 = new ImageView(default1);
    private ImageView iv2 = new ImageView(default1);
    private ImageView iv3 = new ImageView(default1);
    private Desktop desktop = Desktop.getDesktop();
    private Artsy a = new MyArtsy();

    @Override
    public void start(Stage stage) {

        MenuBar  menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().addAll(fileMenu);
        fileMenu.setMnemonicParsing(true);
        Menu open = new Menu("Open");
        MenuItem open1 = new MenuItem("Open Image 1");
        MenuItem open2 = new MenuItem("Open Image 2");
        
        final FileChooser fileChooser = new FileChooser();

        open.getItems().addAll(open1,open2);
        MenuItem save = new MenuItem("Save Result As");
        MenuItem exit = new MenuItem("Exit");

        save.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Rotate Image Options");
                alert.setContentText("Plese enter your angle, in degrees:");
                GridPane grid1 = new GridPane();
                Label label = new Label("What would you like to name the file?");
                TextField tf = new TextField();
                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);

                grid1.add(label,0,0);
                grid1.add(tf,0,1);
                ok.setText("Ok");

                ok.setOnAction(new EventHandler<ActionEvent>(){
                     @Override public void handle(ActionEvent e) {
                 try{
                     File file = new File(tf.getText() + ".png");
                     BufferedImage bImage = SwingFXUtils.fromFXImage(image3, null);
                     ImageIO.write(bImage, "png", file);
                 }catch(Exception ex){}
                     }
                    });
                alert.getDialogPane().setContent(grid1);

                 alert.showAndWait();
             }
        });



        exit.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 System.exit(0);

             }
        });
        fileMenu.getItems().addAll(open,save,exit);
       




        GridPane root = new GridPane();
        Scene scene = new Scene(root);

       root.add(menuBar,0,0);
        stage.setScene(scene);
        stage.setTitle("Artsy!");
        stage.sizeToScene();


        Button checkers= new Button("Checkers");
        Button hstripes = new Button("Horizontal Stripes");
        Button vstripes = new Button("Vertical Stripes");
        HBox hBox1 = HBoxBuilder.create()
           .spacing(30.0) //In case you are using HBoxBuilder
           .children(new Label(""),checkers, hstripes,vstripes)
           .build();
        root.add(hBox1,0,1);
        hBox1.setMargin(checkers, new Insets(4,0,0,0));
        hBox1.setMargin(hstripes, new Insets(4,0,0,0));
        hBox1.setMargin(vstripes, new Insets(4,0,0,0));

        checkers.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 
                 Label label1 = new Label("Plese enter a number of pixels");
                 Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Checkers Image Options");
                GridPane grid1 = new GridPane();
                TextField tf = new TextField();
                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                grid1.add(label1,0,0);
                grid1.add(tf,0,1);
                ok.setText("Ok");

                ok.setOnAction(new EventHandler<ActionEvent>(){
                     @Override public void handle(ActionEvent e) {
                        try{
                            image3 = a.doCheckers(image1,image2, Integer.parseInt(tf.getText()));
                            iv3.setImage(image3);
                        }catch(Exception ex){}
                     }
                    });
                alert.getDialogPane().setContent(grid1);

                 alert.showAndWait();
             }
        });

        hstripes.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 
                 Label label1 = new Label("Plese enter a number of pixels");
                 Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Horizontal Stripes Image Options");
                GridPane grid1 = new GridPane();
                TextField tf = new TextField();
                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                grid1.add(label1,0,0);
                grid1.add(tf,0,1);
                ok.setText("Ok");

                ok.setOnAction(new EventHandler<ActionEvent>(){
                     @Override public void handle(ActionEvent e) {
                        try{
                            image3 = a.doHorizontalStripes(image1,image2, Integer.parseInt(tf.getText()));
                            iv3.setImage(image3);
                        }catch(Exception ex){}
                     }
                    });
                alert.getDialogPane().setContent(grid1);

                 alert.showAndWait();
             }
        });

        vstripes.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 
                Label label1 = new Label("Plese enter a number of pixels");
                Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Vertical Stripes Image Options");
                GridPane grid1 = new GridPane();
                TextField tf = new TextField();
                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                grid1.add(label1,0,0);
                grid1.add(tf,0,1);
                ok.setText("Ok");

                ok.setOnAction(new EventHandler<ActionEvent>(){
                     @Override public void handle(ActionEvent e) {
                        try{
                            image3 = a.doVerticalStripes(image1,image2, Integer.parseInt(tf.getText()));
                            iv3.setImage(image3);
                        }catch(Exception ex){}
                     }
                    });
                alert.getDialogPane().setContent(grid1);

                alert.showAndWait();
             }
        });

        FlowPane labels = new FlowPane();
        Label label1 = new Label("Image 1: default.png");
        Label label2 = new Label("Image 2: default.png");
        Label label3 = new Label("Result: ");
        labels.getChildren().add(new Label("                          "));
        labels.getChildren().add(label1);
        labels.getChildren().add(new Label("                          "));
        labels.getChildren().add(new Label("                          "));
        labels.getChildren().add(label2);
        labels.getChildren().add(new Label("                             "));
        labels.getChildren().add(new Label("                             "));
        labels.getChildren().add(label3);
        root.add(labels,0,2);
        
        FlowPane pics = new FlowPane();
        

        pics.setPrefWrapLength(950);
        iv1.setFitWidth(300);
        iv1.setFitHeight(300);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);
        pics.getChildren().add(new Label("  "));
        pics.getChildren().add(iv1);
        pics.getChildren().add(new Label("  "));

        iv2.setFitWidth(300);
        iv2.setFitHeight(300);
        iv2.setPreserveRatio(true);
        iv2.setSmooth(true);
        iv2.setCache(true);
        pics.getChildren().add(iv2);
        pics.getChildren().add(new Label("  "));

        iv3.setFitWidth(300);
        iv3.setFitHeight(300);
        iv3.setPreserveRatio(true);
        iv3.setSmooth(true);
        iv3.setCache(true);
        pics.getChildren().add(iv3);

        root.add(pics,0,3);
        
        Button rotate1 = new Button("rotate");
        Button rotate2 = new Button("rotate");
        Button rotate3 = new Button("rotate");
        Button reset1 = new Button("reset");
        Button reset2 = new Button("reset");
        Button reset3 = new Button("reset");

        rotate1.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Rotate Image Options");
                Label label1 = new Label("Plese enter your angle, in degrees:");
                GridPane grid1 = new GridPane();
                TextField tf = new TextField();
                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                grid1.add(label1,0,0);
                grid1.add(tf,0,1);
                ok.setText("Ok");

                ok.setOnAction(new EventHandler<ActionEvent>(){
                     @Override public void handle(ActionEvent e) {
                        try{
                            image1 = a.doRotate(image1,Double.parseDouble(tf.getText()));
                            iv1.setImage(image1);
                        }catch(Exception ex){}
                     }
                    });
                alert.getDialogPane().setContent(grid1);

                 alert.showAndWait();
             }
        });
        rotate2.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Rotate Image Options");
                Label label1 = new Label("Plese enter your angle, in degrees:");
                GridPane grid1 = new GridPane();
                TextField tf = new TextField();
                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                alert.setContentText("Plese enter your angle, in degrees:");
                grid1.add(label1,0,0);
                grid1.add(tf,0,1);
                ok.setText("Ok");

                ok.setOnAction(new EventHandler<ActionEvent>(){
                     @Override public void handle(ActionEvent e) {
                        try{
                            image2 = a.doRotate(image2,Double.parseDouble(tf.getText()));
                            iv2.setImage(image2);
                        }catch(Exception ex){}
                     }
                    });
                alert.getDialogPane().setContent(grid1);

                 alert.showAndWait();
             }
        });
        rotate3.setOnAction(new EventHandler<ActionEvent>(){
             @Override public void handle(ActionEvent e) {
                 Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Rotate Image Options");
                GridPane grid1 = new GridPane();
                Label label1 = new Label("Plese enter your angle, in degrees:");
                TextField tf = new TextField();
                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button ok = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                grid1.add(label1,0,0);
                grid1.add(tf,0,1);
                ok.setText("Ok");

                ok.setOnAction(new EventHandler<ActionEvent>(){
                     @Override public void handle(ActionEvent e) {
                        try{
                            image3 = a.doRotate(image3,Double.parseDouble(tf.getText()));
                            iv3.setImage(image3);
                        }catch(Exception ex){}
                     }
                    });
                alert.getDialogPane().setContent(grid1);

                 alert.showAndWait();
             }
        });

        HBox hBox2 = HBoxBuilder.create()
           .spacing(50.0) 
           .children(new Label("      ")
                    ,rotate1
                    ,reset1
                    ,new Label(""),new Label("")
                    ,rotate2
                    ,reset2
                    ,new Label(""),new Label("")
                    ,rotate3
                    ,reset3)
           .build();
        hBox2.setMargin(rotate1, new Insets(9,0,9,0));
        hBox2.setMargin(rotate2, new Insets(9,0,9,0));
        hBox2.setMargin(rotate3, new Insets(9,0,9,0));
        hBox2.setMargin(reset1 , new Insets(9,0,9,0));
        hBox2.setMargin(reset2 , new Insets(9,0,9,0));
        hBox2.setMargin(reset3 , new Insets(9,0,9,0));
        root.add(hBox2,0,4);


        reset1.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                try{
                image1 = new Image("file:" + imageLocation1);
                iv1.setImage(image1);
                }catch(Exception ex){
                    image1 = default1;
                }
                
            }
        });

        reset2.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                try{
                image2 = new Image("file:" + imageLocation2);
                iv2.setImage(image2);
                }catch(Exception ex){
                    image2 = default1;
                }
            }
        });

        reset3.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                
                iv3.setImage(default1);
            }
        });

        open1.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                
                Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Open Picture 1");
                alert.setContentText("This is the content text");
                GridPane grid1 = new GridPane();

                TextField pathToPicture = new TextField("Enter a path from the file system here or clich \"Browse\"");
                pathToPicture.setPrefWidth(600);

                Button browse = new Button("Browse");

                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button openButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                openButton.setText("Open File");


                ToggleGroup group = new ToggleGroup();
                RadioButton local = new RadioButton("Local File");
              local.setSelected(true);
                        
                //local.setDefaultButton(true);
                RadioButton remote = new RadioButton("Remote File");
                local.setToggleGroup(group);
                remote.setToggleGroup(group);

                
                HBox hBox2 = HBoxBuilder.create()
                    .spacing(30.0) //In case you are using HBoxBuilder
                    .children(new Label(""),local,new Label(""),remote)
                    .build();

                grid1.add(hBox2,0,0);
                grid1.add(new Label("         "),1,1);
                grid1.add(pathToPicture,0,2);
                grid1.add(new Label("         "),1,2);
                grid1.add(browse,2,2);

                alert.getDialogPane().setPrefSize(800,200);
                alert.getDialogPane().setContent(grid1);

                local.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        openButton.setText("Open File");
                        pathToPicture.setText("Enter a path from the file system here or clich ''Browse''");
                        grid1.getChildren().clear();
                        grid1.add(hBox2,0,0);
                        grid1.add(new Label("         "),1,1);
                        grid1.add(pathToPicture,0,2);
                        grid1.add(new Label("         "),1,2);
                        grid1.add(browse,2,2);
                    }
                });

                browse.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        File file = fileChooser.showOpenDialog(stage);
                     pathToPicture.setText(file.getAbsolutePath());
                    }
                });

                remote.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        openButton.setText("Open URL");
                        pathToPicture.setText("Enter a URL");
                        grid1.getChildren().clear();
                        grid1.add(hBox2,0,0);
                        grid1.add(new Label("         "),1,1);
                        grid1.add(pathToPicture,0,2);
                        grid1.add(new Label("         "),1,2);

                    }
                });

                openButton.setOnAction(new EventHandler<ActionEvent>(){
                    @Override public void handle(ActionEvent e) {
                        if(local.isSelected()){
                            try{
                             setImage1(pathToPicture.getText());
                            }catch(Exception ex){System.exit(0);}
                        }
                    }
                });
                
                alert.showAndWait();
                               
            }
        });

        open2.setOnAction(new EventHandler<ActionEvent>(){
            @Override public void handle(ActionEvent e) {
                
                Alert alert = new Alert(AlertType.NONE);
                alert.setTitle("Open Picture 1");
                alert.setContentText("This is the content text");
                GridPane grid1 = new GridPane();

                TextField pathToPicture = new TextField("Enter a path from the file system here or clich \"Browse\"");
                pathToPicture.setPrefWidth(600);

                Button browse = new Button("Browse");

                alert.getButtonTypes().addAll(ButtonType.CLOSE);
                Button openButton = (Button) alert.getDialogPane().lookupButton(ButtonType.CLOSE);
                openButton.setText("Open File");


                ToggleGroup group = new ToggleGroup();
                RadioButton local = new RadioButton("Local File");
              local.setSelected(true);
                        
                //local.setDefaultButton(true);
                RadioButton remote = new RadioButton("Remote File");
                local.setToggleGroup(group);
                remote.setToggleGroup(group);

                
                HBox hBox2 = HBoxBuilder.create()
                    .spacing(30.0) //In case you are using HBoxBuilder
                    .children(new Label(""),local,new Label(""),remote)
                    .build();

                grid1.add(hBox2,0,0);
                grid1.add(new Label("         "),1,1);
                grid1.add(pathToPicture,0,2);
                grid1.add(new Label("         "),1,2);
                grid1.add(browse,2,2);

                alert.getDialogPane().setPrefSize(800,200);
                alert.getDialogPane().setContent(grid1);

                local.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        openButton.setText("Open File");
                        pathToPicture.setText("Enter a path from the file system here or clich ''Browse''");
                        grid1.getChildren().clear();
                        grid1.add(hBox2,0,0);
                        grid1.add(new Label("         "),1,1);
                        grid1.add(pathToPicture,0,2);
                        grid1.add(new Label("         "),1,2);
                        grid1.add(browse,2,2);
                    }
                });

                browse.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        File file = fileChooser.showOpenDialog(stage);
                     pathToPicture.setText(file.getAbsolutePath());
                    }
                });

                remote.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent e){
                        openButton.setText("Open URL");
                        pathToPicture.setText("Enter a URL");
                        grid1.getChildren().clear();
                        grid1.add(hBox2,0,0);
                        grid1.add(new Label("         "),1,1);
                        grid1.add(pathToPicture,0,2);
                        grid1.add(new Label("         "),1,2);

                    }
                });

                openButton.setOnAction(new EventHandler<ActionEvent>(){
                    @Override public void handle(ActionEvent e) {
                        if(local.isSelected()){
                            try{
                             setImage2(pathToPicture.getText());
                            }catch(Exception ex){System.exit(0);}
                        }
                    }
                });
                
                alert.showAndWait();
                               
            }
        });
        stage.show();

    } // createAndShowGUI

    public static void main(String[] args) {
        launch(args);
    } // main

    
    protected void setImage1(String file){
        imageLocation1 = file;
        image1 = new Image("file:" + file);
       iv1.setImage(image1);
    }


    
    protected void setImage2(String file){
        imageLocation2 = file;
       image2 = new Image("file:" + file);
       iv2.setImage(image2);
    }

} // Driver

