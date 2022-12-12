package com.example.legend_of_sparta;

import javafx.animation.AnimationTimer;
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
    AnimationTimer gameLoop;

    @FXML
    private ImageView player; //player from scenebuilder

    private int time = 0; // game frame time

    @FXML
    private AnchorPane mapGrid; //AnchorPane from scene builder, used as a reference grid

    private Player playerComponent;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        playerComponent = new Player(player);

        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                update();
            }
        };

        load();

        gameLoop.start();
    }

    @FXML
    void pressed(KeyEvent event) {
        if(event.getCode() == KeyCode.W)
        {
            playerComponent.moveUP(20);
        }
        else if(event.getCode() == KeyCode.S)
        {
            playerComponent.moveDOWN(20);
        }
        else if(event.getCode() == KeyCode.A)
        {
            playerComponent.moveLEFT(20);
        }
        else if(event.getCode() == KeyCode.D)
        {
            playerComponent.moveRIGHT(20);
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