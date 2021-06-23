package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class GameBoard extends JPanel implements ActionListener, KeyListener {

    private int BOX_WIDTH = 40;
    private boolean gameStarted = false;
    private int score = 0;
    private final int delay = 4;
    // Player speed at start
    int velX = 0;
    int velY = 0;


    House house = new House();
    Player player = new Player(445, 540);
    Hook hook = new Hook("Hook", 390, 460, Color.green);
    Obstacle obstacle = new Obstacle("obstacle", 250, 250, Color.red);
    ArrayList<Obstacle> obst = new ArrayList<Obstacle>();

    public GameBoard() {
        addKeyListener(this);
        Timer timer = new Timer(delay, this);
        timer.start();

        obst.add(new Obstacle("obstacle", 370, 520, Color.red));
        obst.add(new Obstacle("obstacle", 400, 480, Color.red));
        obst.add(new Obstacle("obstacle", 420, 380, Color.red));
        obst.add(new Obstacle("obstacle", 440, 490, Color.red));
        obst.add(new Obstacle("obstacle", 500, 400, Color.red));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                g.drawRect(i * BOX_WIDTH, j * BOX_WIDTH, BOX_WIDTH, BOX_WIDTH);
            }
        }

        //Obstacle
        for(int i = 0; i < obst.size(); i++) {
            g2.setColor(Color.red);
            if (obst.get(i).isTaken()) {
                g2.setColor(Color.lightGray);
            }
            g2.fillOval(obst.get(i).getPosX(),obst.get(i).getPosY(),15,15);
        }

        house.draw(g2);
        player.draw(g);
        hook.draw(g2);

        // Scores
        g2.setColor(Color.black);
        g2.setFont(new Font("serif",Font.BOLD, 30));
        g2.drawString("Scores : "+score,260,40);

        //Start the game
        g2.setFont(new Font("serif",Font.BOLD, 18));
        g2.drawString("Please, press enter to start the game  ", 190,60);
    }

    public void actionPerformed(ActionEvent e)
    {

        if(gameStarted){
            //detecting intersections- here with the key and the player
            if (new Rectangle(hook.getPosX(), hook.getPosY(), 10, 10).intersects(player.getX(), player.getY(), 10, 10)
                    && hook.isTaken()==false)
            {
                score +=3;
                hook.setTaken(true);
            }
        }

        if(gameStarted){
            //detecting intersections- here with the obstacle and the player
            for(int i = 0; i < obst.size(); i++) {
                if (new Rectangle(obst.get(i).getPosX(), obst.get(i).getPosY(), 10, 10).intersects(player.getX(), player.getY(), 10, 10)
                    && obst.get(i).isTaken()==false) {
                    score -= 5;
                    obst.get(i).setTaken(true);
                }
            }
        }

        if (player.getX() < 80) // To avoid player moving outside of the screen in x direction
        {
            velX = 0;
            player.setX(80);
        }

        if (player.getX() > 540) // To avoid moving outside of the screen in x direction
        {
            velX = 0;
            player.setX(540);
        }

        if (player.getY() < 80)
        {
            velY = 0;
            player.setY(80);
        }

        if (player.getY() > 540)
        {
            velY = 0;
            player.setY(540);
        }

        player.setX(player.getX() + velX);
        player.setY(player.getY() + velY);
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if (c == KeyEvent.VK_LEFT) {  //keyarrow pointing left gives movement to left
            velX = -1;
            velY = 0;
        }
        if (c == KeyEvent.VK_UP) {
            velX = 0;
            velY = -1;
        }
        if (c == KeyEvent.VK_RIGHT) {
            velX = 1;
            velY = 0;
        }
        if (c == KeyEvent.VK_DOWN) {
            velX = 0;
            velY = 1;
        }
        if(c == KeyEvent.VK_ENTER){
            if(!gameStarted){
                gameStarted = true;
                player.setX(445);
                player.setY(540);
                hook.setPosX( ThreadLocalRandom.current().nextInt(360,560));
                hook.setPosY(ThreadLocalRandom.current().nextInt(360,560));
                repaint();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        velX = 0;
        velY = 0;
    }

    public void keyTyped(KeyEvent e) {}
}
