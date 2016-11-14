package me.craigmorton.craig.asc_yspaceship;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public abstract class CanvasEntity {

    protected int xPos;
    protected int yPos;
    protected int colour;
    protected char[] ascii;
    protected float asciiSize;

    public CanvasEntity() {

    }

    public CanvasEntity(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    protected abstract void updatePosition();

    protected int getXPos() {
        return xPos;
    }
    protected int getYPos() {
        return yPos;
    }
    protected int getColour() {
        return colour;
    }
    protected char[] getAscii() {
        return ascii;
    }
    protected float getAsciiSize() {
        return asciiSize;
    }
    protected void setColour(int newColour) {
        colour = newColour;
    }
    protected void setXPos(int newPos) {
        xPos = newPos;
    }
    protected void setYPos(int newPos) {
        yPos = newPos;
    }

}
