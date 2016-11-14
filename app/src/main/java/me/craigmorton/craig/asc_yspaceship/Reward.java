package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Canvas;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public class Reward extends CanvasEntity {
    private static final char[] ASCII_ART = {'$'};

    public Reward() {

    }

    public Reward(Canvas canvas, int xPos, int yPos) {
        super(xPos, yPos);
    }
}
