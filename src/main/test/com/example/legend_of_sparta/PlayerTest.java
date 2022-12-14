package com.example.legend_of_sparta;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/* Author: Alana
 *
 * Testing players movements of X and values along the scene.
 * Verifies that each movement function ( UP/DOWN/LEFT/RIGHT ) is returning correct direction, x and y values
 * based input value of change position.
 *
 */
public class PlayerTest
{
    @FXML
    private ImageView player = new ImageView(); //decoy player
    @Test
    void moveUP()
    {
        Player p1 = new Player(player); //creates decoy player
        // sets player's initial x and y position on screen: (450, 250) on scene builder
        player.setX(450);
        player.setY(250);

       //Player changes position up 5, y position decrements 5
        p1.moveUP(5); // y - 5 spaces: Player (450, 245)

        assertEquals(450.0,  p1.getPosX()); // should stay same
        assertEquals(245.0,  p1.getPosY()); // should be 245
        //new current pos: (450, 245)

        //Player changes position up 10, y position decrements 10
        p1.moveUP(10); // y - 10 spaces: Player @ (450, 245)

        assertEquals(450.0, p1.getPosX()); //should stay same
        assertEquals(235.0, p1.getPosY()); // should be 235
    }

    @Test
    void moveDOWN()
    {
        Player p2 = new Player(player); //creates decoy player
        //sets player's initial x and y position on screen: (450, 250) on scene builder
        player.setX(450);
        player.setY(250);

        //Player changes position down 5, y position increments 5
        p2.moveDOWN(5); // y + 5 spaces: Player (450, 255)

        assertEquals(450.0,  p2.getPosX()); // should stay same
        assertEquals(255.0,  p2.getPosY()); // should be 255
        //new current pos: (450, 255)

        //Player changes position down 10, y position increments 10
        p2.moveDOWN(10); // y + 10 spaces: Player @ (450, 255)

        assertEquals(450.0, p2.getPosX()); //should stay same
        assertEquals(265.0, p2.getPosY()); //should be 265

    }

    @Test
    void moveLEFT()
    {
        //sets player's initial x and y position on screen: (450, 250) on scene builder
        player.setX(450);
        player.setY(250);
        Player p3 = new Player(player); //creates decoy player

        //Player changes position left 5, x position decrements 5
        p3.moveLEFT(5); // x - 5 spaces: Player (450, 245)

        assertEquals(445.0,  p3.getPosX()); // should stay same
        assertEquals(250.0,  p3.getPosY()); // should be 250
        //new current pos: (445, 250)

        //Player changes position left 10, x position decrements 10
        p3.moveLEFT(10); // x - 10 spaces: Player @ (435, 250)

        assertEquals(435.0, p3.getPosX()); //should be 435
        assertEquals(250.0, p3.getPosY()); //should stay same
    }

    @Test
    void moveRIGHT()
    {
        //sets player's initial x and y position on screen: (450, 250) on scene builder
        player.setX(450);
        player.setY(250);
        Player p4 = new Player(player); //creates decoy player

        //Player changes position right 5, x position increments 5
        p4.moveRIGHT(5); // x + 5 spaces: Player (455, 245)

        assertEquals(455.0,  p4.getPosX()); // should be 455
        assertEquals(250.0,  p4.getPosY()); // should stay same
        //new current pos: (455, 250)

        //Player changes position right 10, y position increments 10
        p4.moveRIGHT(10); // x + 10 spaces: Player @ (455, 250)

        assertEquals(465.0, p4.getPosX()); //should be 465
        assertEquals(250.0, p4.getPosY()); //should stay same

    }


}