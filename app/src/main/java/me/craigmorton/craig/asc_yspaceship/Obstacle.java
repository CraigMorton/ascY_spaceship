package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Color;

/**
 * Created by user on 04/05/2016.
 */
public class Obstacle extends CanvasEntity{

    public Obstacle(){
        colour = Color.GRAY;
        ascii = new char[] {'#'};
    }

    protected void updatePosition() {

    }
}
