package com.example.legend_of_sparta;

import javafx.scene.image.ImageView;

public class Player extends Entity
{
    private ImageView weapon;
    private int directionFacing; //0-3 clockwise
    private boolean attackReady;
    private ImageView player;
    public Player(ImageView player)
    {
        this.player = player;

    }

    public void moveUP(double changePos)
    {
        player.setY(player.getY() - changePos);
        weapon.setY(player.getY()-changePos-45);
        weapon.setX(player.getX());
        weapon.setRotate(0);
        directionFacing =0;

    }
    public void moveDOWN(int changePos)
    {
        player.setY(player.getY() + changePos);
        weapon.setY(player.getY() + changePos + 45);
        weapon.setX(player.getX());
        weapon.setRotate(180);
        directionFacing =2;


    }

    public void moveLEFT(int changePos)
    {
        player.setX(player.getX() - changePos);
        weapon.setX(player.getX() - changePos-45);
        weapon.setY(player.getY());
        weapon.setRotate(270);
        directionFacing =3;
    }

    public void moveRIGHT(int changePos)
    {
        player.setX(player.getX() + changePos);
        weapon.setX(player.getX() + changePos + 45);
        weapon.setY(player.getY());
        weapon.setRotate(90);
        directionFacing =1;
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
    public void attack() {
       if(attackReady) {
           weapon.setOpacity(1);
       }
        attackReady=false;

    }
    public void readyAttack() {
        attackReady=true;
        weapon.setOpacity(0);
    }
    public boolean getAttackStatus() {
        return attackReady;
    }
    public void equipWeapon(ImageView weapon) {
        this.weapon = weapon;
        weapon.setOpacity(0);

    }
    public int getDirectionFacing() {
        return directionFacing;
    }
}
