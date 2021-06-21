package com.company;

import javax.swing.*;

public class Board extends JFrame {
    public Board() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Kråkslottet");
        setLocation(400, 50);
        GameBoard gameBoard = new GameBoard();
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        addKeyListener(gameBoard);
        gameBoard.setPreferredSize(new java.awt.Dimension(640, 640));
        add(gameBoard);
        pack();
        setVisible(true);
    }
}

