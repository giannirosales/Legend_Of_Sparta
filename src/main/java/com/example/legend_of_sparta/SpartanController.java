package com.example.legend_of_sparta;

import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class SpartanController implements Initializable
{

    //boolean bindings for input keys pressed for player movement
    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed);



    @FXML
    private ImageView player; //player from scene builder

    private int time = 0; // game frame time

    @FXML
    private AnchorPane mapGrid; //AnchorPane from scene builder, used as a reference grid

    private Player playerComponent;

    // animation timer that runs every frame
    AnimationTimer gameLoop = new AnimationTimer() {
        @Override
        public void handle(long l) {
            update();// calls update

            //Determines movement based on input key
            if(wPressed.get()) {
                playerComponent.moveUP(5);
            }

            else if(sPressed.get()){
                playerComponent.moveDOWN(5);
            }

           else if(aPressed.get()){
                playerComponent.moveLEFT(5);
            }

            else if(dPressed.get()){
                playerComponent.moveRIGHT(5);
            }
            playerComponent.playerPosPrint();

        }
    };
    @Override
    // starting or initializing game
    public void initialize(URL url, ResourceBundle resourceBundle) {

        playerComponent = new Player(player);


        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            if(!aBoolean){
                gameLoop.start();
            } else {
                gameLoop.stop();
            }
        }));

        load();


    }

    // key pressed and key released section allows player to hold down
    // a key and change position incrementally while key is held down
    @FXML
    //  #pressed: tag id used on Anchor Pane from scene builder
      public void pressed(KeyEvent event) {    //does key pressed boolean logic

        if(event.getCode() == KeyCode.W) {
            wPressed.set(true);
        }
        else if(event.getCode() == KeyCode.S) {
            sPressed.set(true);
        }
        else if(event.getCode() == KeyCode.A) {
            aPressed.set(true);
        }
        else if(event.getCode() == KeyCode.D) {
            dPressed.set(true);
        }
    }
    @FXML
    //  #released: tag id used on Anchor Pane from scene builder
    public void released(KeyEvent event){  //does key released boolean logic
        if(event.getCode() == KeyCode.W)
        {
            wPressed.set(false);
        }
        else if(event.getCode() == KeyCode.S)
        {
            sPressed.set(false);

        }
        else if(event.getCode() == KeyCode.A)
        {
            aPressed.set(false);

        }
        else if(event.getCode() == KeyCode.D)
        {
            dPressed.set(false);

        }
    }

    //called for every frame of game
    private void update()
    {
        time++;
        //System.out.print("Game thread loop"); //game loop test
    }

    private void load()
    {

    }
}