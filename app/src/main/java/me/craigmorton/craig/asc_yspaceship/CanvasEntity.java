package me.craigmorton.craig.asc_yspaceship;

import me.craigmorton.craig.asc_yspaceship.movement_behaviours.MovementBehaviour;
import me.craigmorton.craig.asc_yspaceship.movement_behaviours.NoMovement;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public abstract class CanvasEntity {

    protected float xCoordMultiplier;
    protected float yCoordMultiplier;
    protected int colour;
    protected char[] asciiArt;
    protected MovementBehaviour movementBehaviour;

    public CanvasEntity() {
        xCoordMultiplier = 0.5f;
        yCoordMultiplier = 0.5f;
        movementBehaviour = new NoMovement();
    }

    public CanvasEntity(MovementBehaviour movementBehaviour) {
        xCoordMultiplier = 0.5f;
        yCoordMultiplier = 0.5f;
        this.movementBehaviour = movementBehaviour;
    }

    public CanvasEntity(float xCoordMultiplier, float yCoordMultiplier) {
        this.xCoordMultiplier = xCoordMultiplier;
        this.yCoordMultiplier = yCoordMultiplier;
        movementBehaviour = new NoMovement();
    }

    public CanvasEntity(float xCoordMultiplier, float yCoordMultiplier, MovementBehaviour movementBehaviour) {
        this.xCoordMultiplier = xCoordMultiplier;
        this.yCoordMultiplier = yCoordMultiplier;
        this.movementBehaviour = movementBehaviour;
    }

    protected void updatePosition() {
        setXCoordMultiplier(movementBehaviour.updateXMultiplier(xCoordMultiplier));
        setYCoordMultiplier(movementBehaviour.updateYMultiplier(yCoordMultiplier));
    }

    protected String getString() {
        String asciiArt = "";
        for (char character : this.asciiArt) {
            asciiArt += character;
        }
        return asciiArt;
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

    protected int getColour() {
        return colour;
    }

    protected float getXCoordMultiplier() {
        return xCoordMultiplier;
    }

    protected float getYCoordMultiplier() {
        return yCoordMultiplier;
    }

    protected void setXCoordMultiplier(float newXMultiplier) {
        xCoordMultiplier = newXMultiplier;
    }

    protected void setYCoordMultiplier(float newYMultiplier) {
        yCoordMultiplier = newYMultiplier;
    }

    protected void setMovementBehaviour(MovementBehaviour movementBehaviour) {
        this.movementBehaviour = movementBehaviour;
    }

}
