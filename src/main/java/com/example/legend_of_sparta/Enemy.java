package com.example.legend_of_sparta;
import java.util.Random;
import javafx.scene.image.ImageView;
public class Enemy extends Entity {
    int health = 6;
    int xDirection = 1;
    int yDirection = 1;
    int speed;
    private ImageView enemy;
    Random rand = new Random();
    public Enemy(ImageView enemy) {
        this.enemy = enemy;
        enemy.setX(rand.nextInt(800));
        speed = 3 + rand.nextInt(2);
        if(rand.nextBoolean()) {
            if(rand.nextBoolean()) {
                xDirection =1;
            }
            else {
                xDirection = -1;
            }
        }
        else if (rand.nextBoolean()) {
            if(rand.nextBoolean()) {
                yDirection = 1;
            }
            else {
                yDirection = -1;
            }
        }
    }
    void attacked(Player player) {
        boolean hitHorizontal = false;
        boolean hitVertical = false;
        double playerX = player.getPosX()+(double)435;
        double playerY = player.getPosY()+(double)250;
        if (playerX > enemy.getX() && playerX-140<enemy.getX()) {
          //  System.out.println("Hit");
            hitHorizontal = true;
        }
        else if(playerX < enemy.getX() && playerX+120>enemy.getX()) {
           // System.out.println("Hit");
            hitHorizontal = true;
        }
        if(playerY>enemy.getY() && playerY-130 < enemy.getY()) {
            hitVertical = true;
        }
        else if (playerY<enemy.getY() && playerY+130 > enemy.getY()) {
            hitVertical=true;
        }
        if (hitHorizontal&&hitVertical) {
            health--;
        }



        if(health==0) {
            enemy.setOpacity(0);
        }
    }
    void move() {
        enemy.setX(enemy.getX()+(speed*xDirection));
        enemy.setY(enemy.getY()+(speed*yDirection));
        if (enemy.getX()+5>800) {
            xDirection = -1;
        }
        if (enemy.getX()+5<0) {
            xDirection = 1;
        }
        if (enemy.getY() +5 > 520) {
            yDirection = -1;
        }
        if (enemy.getY() +5 < 0) {
            yDirection = 1;
        }

    }

    void setImage(ImageView image) {
        enemy = image;
    }
}
