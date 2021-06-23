package com.company;

import java.awt.*;

public class Hook extends Entity{
    public boolean taken;

    public Hook(String name, int posX, int posY, Color color) {
        super(name, posX, posY, color);
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public void draw (Graphics2D g2) {
        g2.setColor(Color.GREEN);
        if (isTaken()) {
            g2.setColor(Color.lightGray);
        }
        g2.fillOval(getPosX(),getPosY(),15,15);
    }
}
