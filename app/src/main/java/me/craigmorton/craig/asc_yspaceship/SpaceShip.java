package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Color;

/**
 * Created by user on 04/05/2016.
 */
public class SpaceShip extends CanvasEntity{

    public SpaceShip(){
        colour = Color.WHITE;
        ascii = new char[] {'<', '=', '>'};
        asciiSize = 40;
        xPos = 75;
        yPos = 75;

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



    @Override
    protected void setXPos(int newPos){
        return;
    }

}

