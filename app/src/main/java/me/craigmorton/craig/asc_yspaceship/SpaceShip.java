package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Color;

import me.craigmorton.craig.asc_yspaceship.movement_behaviours.MovementBehaviour;

/**
 * Created by user on 04/05/2016.
 */
public class SpaceShip extends CanvasEntity{

    public SpaceShip() {
        setUpAppearance();
    }

    public SpaceShip(MovementBehaviour movementBehaviour) {
        super(movementBehaviour);
        setUpAppearance();
    }

    public SpaceShip(float xMultiplier, float yMultiplier) {
        super(xMultiplier, yMultiplier);
        setUpAppearance();
    }

    public SpaceShip(float xMultiplier, float yMultiplier, MovementBehaviour movementBehaviour) {
        super(xMultiplier, yMultiplier, movementBehaviour);
        setUpAppearance();
    }

    private void setUpAppearance() {
        colour = Color.WHITE;
        asciiArt = new char[] {'<', '=', '>'};
    }

    @Override
    protected void setXCoordMultiplier(float newXMultiplier){
        return;
    }

}

