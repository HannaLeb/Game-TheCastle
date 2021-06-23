package com.company;

import java.awt.*;

public class Player {

    //PLayer's position at start
    private int x = 7;
    private int y = 9;


    //Player's size
    private final int width = 30;
    private final int height = 25;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void draw(Graphics g) {
        ((Graphics2D) g).setStroke(new BasicStroke(1));
        //Player's body
        g.setColor(Color.RED);
        g.fillOval(x, y, 30, 20);
        //Player's eyes
        g.setColor(Color.WHITE);
        g.fillOval(x + width / 4, y + height / 8, width / 4, height / 4);
        g.fillOval(x + width - (width / 4), y + height / 8, width / 4, height / 4);
        g.setColor(Color.BLACK);
        g.drawOval(x + width / 4, y + height / 8, width / 4, height / 4);
        g.drawOval(x + width - (width / 4), y + height / 8, width / 4, height / 4);
        g.fillOval(x + width / 4 + width / 16, y + height / 5, width / 10, height / 10);
        g.fillOval(x + +width - (width / 4) + width / 16, y + height / 5, width / 10, height / 10);
        //Player's mouth
        g.drawLine(x + width / 8, y + height / 2 + height / 6, x + width - width / 8, y + height / 2 + height / 6);
    }
}
