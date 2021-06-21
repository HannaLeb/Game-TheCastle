package com.company;

import java.awt.*;

public class Entity {
    private String name;
    private int posX;
    private int posY;
    private Color color;

    public Entity(String name, int posX, int posY, Color color) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}