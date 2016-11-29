package me.craigmorton.craig.asc_yspaceship.movement_behaviours;

/**
 * Created by user on 29/11/2016.
 */

public class NoMovement implements MovementBehaviour {
    public float updateXMultiplier(float prevXPos) {
        return prevXPos;
    }

    public float updateYMultiplier(float prevYPos) {
        return prevYPos;
    }

}
