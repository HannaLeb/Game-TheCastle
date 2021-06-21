package com.company;

import javax.swing.*;
import java.awt.*;

public class House {
    public House() {}

    public void draw (Graphics2D g2) {
        //The house
        g2.setColor(Color.black);
        //Exterior walls
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(80, 80, 80, 560);
        g2.drawLine(80, 80, 560, 80);
        g2.drawLine(560, 80, 560, 560);
        g2.drawLine(560, 560, 480, 560);
        g2.drawLine(440, 560, 80, 560);
        //Dorrway
        g2.drawLine(480, 570, 480, 550);
        g2.drawLine(440, 570, 440, 550);

        //Interior walls
        g2.setStroke(new BasicStroke(6));
        //Wall between working- and living room
        g2.drawLine(80, 320, 160, 320);
        //Doorway between working- and living room
        g2.drawLine(160, 310, 160, 330);
        g2.drawLine(200, 310, 200, 330);
        //Wall between kitchen and hall
        g2.drawLine(200, 320, 560, 320);
        //Wall between hall and living room
        g2.drawLine(320, 440, 320, 560);
        g2.drawLine(320, 400, 320, 280);
        //Doorway between hall and living room
        g2.drawLine(310, 400, 330, 400);
        g2.drawLine(310, 440, 330, 440);
        //Wall between working room and kitchen
        g2.drawLine(320, 240, 320, 80);
        //Doorway between working room and hall
        g2.drawLine(310, 240, 330, 240);
        g2.drawLine(310, 280, 330, 280);
    }
}
