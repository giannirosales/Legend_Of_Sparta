package com.example.legend_of_sparta;
//Author Gianni Rosales
import javafx.scene.image.ImageView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
private ImageView playerImage = new ImageView();
private ImageView enemyImage = new ImageView();
private Player player = new Player(playerImage);
private Enemy enemy = new Enemy(enemyImage);
    @Test
    void attacked() {

        playerImage.setX(100);
        playerImage.setY(100);
        enemyImage.setX(120);
        enemyImage.setY(120);
        Player player = new Player(playerImage);
        Enemy enemy = new Enemy(enemyImage);
        assertEquals(true,enemy.attacked(player));
    }
}