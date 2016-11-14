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
        xPos = 25;
        yPos = 25;

    }

    protected void updatePosition() {

    }



    @Override
    protected void setXPos(int newPos){
        return;
    }

}

