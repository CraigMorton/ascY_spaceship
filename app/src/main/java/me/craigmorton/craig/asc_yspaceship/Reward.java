package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Canvas;
import android.graphics.Color;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public class Reward extends CanvasEntity {

    public Reward() {
        colour = Color.YELLOW;
        ascii = new char[] {'$'};
        asciiSize = 40;
        xPos = 25;
        yPos = 25;
    }
    protected void updatePosition() {
        if (xPos > 50) {
            xPos -= 50;
            yPos -= 50;
        } else if (xPos < 50) {
            xPos += 50;
            yPos += 50;
        }
    }
}
