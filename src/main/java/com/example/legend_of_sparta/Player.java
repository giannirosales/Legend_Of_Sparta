package com.example.legend_of_sparta;

import javafx.scene.image.ImageView;

public class Player extends Entity
{
    private ImageView player;

    public Player(ImageView player)
    {
        this.player = player;
    }

    public void moveUP(double changePos)
    {
        player.setY(player.getY() - changePos);

    }
    public void moveDOWN(int changePos)
    {
        player.setY(player.getY() + changePos);

    }

    public void moveLEFT(int changePos)
    {
        player.setX(player.getX() - changePos);
    }

    public void moveRIGHT(int changePos)
    {
        player.setX(player.getX() + changePos);
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
