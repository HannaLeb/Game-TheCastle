package com.company;

import java.awt.*;

public class Obstacle extends Entity {

    public boolean taken;

    public Obstacle(String name, int posX, int posY, Color color) {
        super(name, posX, posY, color);
     }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}



