package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Color;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public class Reward extends CanvasEntity {

    public Reward() {
        colour = Color.YELLOW;
        asciiArt = new char[] {'$'};
//        asciiSize = 40;
        xCoordMultiplier = 0.25f;
        yCoordMultiplier = 0.25f;
    }
    protected void updatePosition() {
        if (xCoordMultiplier > 0.5f) {
            xCoordMultiplier -= 0.5f;
            yCoordMultiplier -= 0.5f;
        } else if (xCoordMultiplier < 0.5f) {
            xCoordMultiplier += 0.5f;
            yCoordMultiplier += 0.5f;
        }
    }
}
