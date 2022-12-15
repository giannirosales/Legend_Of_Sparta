package com.example.legend_of_sparta;

import javafx.scene.image.ImageView;

public class Entity
{
    public double xPos, yPos;

    public void setPosition(double x,double Y) {
        xPos = x;
        yPos = Y;
    }
    public double getX() {
        return xPos;
    }

}
