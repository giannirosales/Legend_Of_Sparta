package com.example.legend_of_sparta;

import javafx.scene.image.ImageView;

public class Player extends Entity
{
    private ImageView player;

    public Player(ImageView player)
    {
        this.player = player;
    }

    public void moveUP(double posChange)
    {
        player.setY(player.getY() - posChange);

    }
    public void moveDOWN(int posChange)
    {
        player.setY(player.getY() + posChange);

    }

    public void moveLEFT(int posChange)
    {
        player.setX(player.getX() - posChange);

    }

    public void moveRIGHT(int posChange)
    {
        player.setX(player.getX() + posChange);

    }
    public double getPosX()
    {
        xPos = player.getX();
        return xPos;
    }
    public double getPosY()
    {
        yPos = player.getY();
        return yPos;
    }

    public void playerPosPrint()
    {
        System.out.printf("Current Position (x,y): (%.1f,%.1f) \n", getPosX(), getPosY());
    }

}
