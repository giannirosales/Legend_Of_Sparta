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
    public void moveDOWN(double posChange)
    {
        player.setY(player.getY() + posChange);

    }

    public void moveLEFT(double posChange)
    {
        player.setX(player.getX() - posChange);

    }

    public void moveRIGHT(double posChange)
    {
        player.setX(player.getX() + posChange);

    }


}
