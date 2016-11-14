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
    }
    protected void updatePosition() {

    }
}
