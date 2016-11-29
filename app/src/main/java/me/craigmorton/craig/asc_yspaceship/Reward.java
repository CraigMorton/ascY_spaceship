package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Color;

import me.craigmorton.craig.asc_yspaceship.movement_behaviours.MovementBehaviour;

/**
 * Created by CraigMorton on 15/08/2016.
 */
public class Reward extends CanvasEntity {

    public Reward() {
        colour = Color.YELLOW;
        asciiArt = new char[] {'$'};
    }

    public Reward(float xMultiplier, float yMultiplier, MovementBehaviour movementBehaviour) {
        super(xMultiplier, yMultiplier, movementBehaviour);
        colour = Color.YELLOW;
        asciiArt = new char[] {'$'};
    }

    protected void updatePosition() {
        xCoordMultiplier = movementBehaviour.updateXMultiplier(xCoordMultiplier);
        yCoordMultiplier = movementBehaviour.updateYMultiplier(yCoordMultiplier);
    }
}
