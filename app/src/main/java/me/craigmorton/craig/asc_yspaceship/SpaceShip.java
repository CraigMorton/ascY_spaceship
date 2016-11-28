package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Color;

/**
 * Created by user on 04/05/2016.
 */
public class SpaceShip extends CanvasEntity{

    public SpaceShip() {
        colour = Color.WHITE;
        asciiArt = new char[] {'<', '=', '>'};
//        asciiSize = 40;
        xCoordMultiplier = 0.75f;
        yCoordMultipler = 0.75f;
    }

    protected void updatePosition() {
        if (xCoordMultiplier > 0.5f) {
            xCoordMultiplier -= 0.5f;
            yCoordMultipler -= 0.5f;
        } else if (xCoordMultiplier < 0.5f) {
            xCoordMultiplier += 0.5f;
            yCoordMultipler += 0.5f;
        }
    }

    @Override
    protected void setXCoordMultiplier(float newXMultiplier){
        return;
    }

}

