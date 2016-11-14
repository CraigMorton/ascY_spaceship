package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Canvas;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public abstract class CanvasEntity {

    private int xPos;
    private int yPos;

    public CanvasEntity() {

    }

    public CanvasEntity(int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public void render(){

    }

    protected int getXPos() {
        return xPos;
    }
    protected int getYPos() {
        return yPos;
    }
    protected void setXPos(int newPos) {
        xPos = newPos;
    }
    protected void setYPos(int newPos) {
        yPos = newPos;
    }



}
