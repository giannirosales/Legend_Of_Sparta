package com.example.legend_of_sparta;

public class GameConfigurator {
    private double playerMoveSpeed;
    private double enemyMoveSpeed;
    private String playerName;
    private int enemySpawnRate;
    private int enemyHealth;
    private int userAttackSpeed;
    private int enemyDamage;
    private int userAttackDamage;
    private int score;
    private int difficulty;
    private static GameConfigurator uniqueInstance;

    public static GameConfigurator getInstance() {
        if (uniqueInstance==null) {
            uniqueInstance = new GameConfigurator();
        }
        return uniqueInstance;
    }

    private GameConfigurator() {
        playerMoveSpeed =5;
        enemyMoveSpeed=3;
        enemyHealth = 6;
    }

    public double getPlayerMoveSpeed() {
        return playerMoveSpeed;
    }
    public double getEnemyMoveSpeed() {
        return enemyMoveSpeed;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }
}
