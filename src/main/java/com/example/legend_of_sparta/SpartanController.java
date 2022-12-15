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
    private GameConfigurator gameConfig;
    //boolean bindings for input keys pressed for player movement
    private BooleanProperty wPressed = new SimpleBooleanProperty();
    private BooleanProperty aPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanProperty spacePressed = new SimpleBooleanProperty();
    private BooleanProperty escapePressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = wPressed.or(aPressed).or(sPressed).or(dPressed).or(spacePressed);



    @FXML
    private ImageView player; //#player tag to image from scene builder
    @FXML
    private ImageView playerWeapon;
    @FXML
    private ImageView Enemy;
    @FXML
    private ImageView Enemy1;
    @FXML
    private ImageView Enemy2;
    private int time = 0; // game frame time

    @FXML
    private AnchorPane mapGrid; //#mapGrid tag to anchorpane from scene builder, used as a reference grid

    private Player playerComponent;
    private Enemy enemyComponent;
    private Enemy enemyComponent1;
    private Enemy enemyComponent2;

    // animation timer that runs every frame
    AnimationTimer gameLoop = new AnimationTimer() {
        @Override
        public void handle(long l) {
            update();// calls update

            //Determines movement based on input key
            if(wPressed.get()) {
                playerComponent.moveUP(gameConfig.getPlayerMoveSpeed());
            }

            else if(sPressed.get()){
                playerComponent.moveDOWN((int)gameConfig.getPlayerMoveSpeed());
            }

           else if(aPressed.get()){
                playerComponent.moveLEFT((int)gameConfig.getPlayerMoveSpeed());
            }

            else if(dPressed.get()){
                playerComponent.moveRIGHT((int)gameConfig.getPlayerMoveSpeed());

            }



        }
    };
    @Override
    // starting or initializing game
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameConfig = GameConfigurator.getInstance();
        playerComponent = new Player(player);
        playerComponent.equipWeapon(playerWeapon);
        enemyComponent = new Enemy(Enemy);
        enemyComponent1 = new Enemy(Enemy1);
        enemyComponent2 = new Enemy(Enemy2);
        gameLoop.start();
        keyPressed.addListener(((observableValue, aBoolean, t1) -> {
            gameLoop.start();
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
        else if(event.getCode() == KeyCode.SPACE) {
            playerComponent.attack();
            enemyComponent.attacked(playerComponent);
            enemyComponent1.attacked(playerComponent);
            enemyComponent2.attacked(playerComponent);
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
        else if(event.getCode() == KeyCode.SPACE) {
            playerComponent.readyAttack();
        }
    }

    //called for every frame of game
    private void update()
    {
        time++;
        enemyComponent.move();
        enemyComponent2.move();
        enemyComponent1.move();
        //System.out.print("Game thread loop"); //game loop test
    }

    private void load()
    {

    }
}