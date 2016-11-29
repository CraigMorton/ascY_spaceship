package me.craigmorton.craig.asc_yspaceship;

import me.craigmorton.craig.asc_yspaceship.movement_behaviours.MovementBehaviour;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public abstract class CanvasEntity {

    protected float xCoordMultiplier;
    protected float yCoordMultiplier;
    protected int colour;
    protected char[] asciiArt;
    protected MovementBehaviour movementBehaviour;

    public CanvasEntity(float xCoordMultiplier, float yCoordMultiplier, MovementBehaviour movementBehaviour) {
        this.xCoordMultiplier = xCoordMultiplier;
        this.yCoordMultiplier = yCoordMultiplier;
        this.movementBehaviour = movementBehaviour;
    }

    public CanvasEntity(float xCoordMultiplier, float yCoordMultiplier) {
        this.xCoordMultiplier = xCoordMultiplier;
        this.yCoordMultiplier = yCoordMultiplier;
    }

    protected abstract void updatePosition();


    public String getString() {
        String asciiArt = "";
        for (char character : this.asciiArt) {
            asciiArt += character;
        }
        return asciiArt;
    }
    protected float getXCoordMultiplier() {
        return xCoordMultiplier;
    }
    protected float getYCoordMultiplier() {
        return yCoordMultiplier;
    }
    protected int getColour() {
        return colour;
    }
    protected char[] getAsciiArt() {
        // clone to avoid blatting asciiArt ie. item.getAsciiArt()[0] = '%';
        int numChars = asciiArt.length;
        char[] clone = new char[numChars];
        for (int i = 0; i < numChars; i++) {
            clone[i] = asciiArt[i];
        }
        return clone;
    }
    protected void setColour(int newColour) {
        colour = newColour;
    }
    protected void setXCoordMultiplier(float newXMultiplier) {
        xCoordMultiplier = newXMultiplier;
    }
    protected void setYCoordMultipler(float newYMultiplier) {
        yCoordMultiplier = newYMultiplier;
    }

}
