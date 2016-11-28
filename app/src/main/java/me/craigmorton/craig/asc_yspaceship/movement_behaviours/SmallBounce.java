package me.craigmorton.craig.asc_yspaceship.movement_behaviours;

import me.craigmorton.craig.asc_yspaceship.movement_behaviours.MovementBehaviour;

/**
 * Created by user on 28/11/2016.
 */

public class SmallBounce implements MovementBehaviour {

    public float updateXPos(float prevXPos) {
        float newCoordMultiplier = prevXPos;
        if (randomBoolean()) {
            newCoordMultiplier += 0.05f;
        } else {
            newCoordMultiplier -= 0.05f;
        }
        return newCoordMultiplier;
    }

    public float updateYPos(float prevYPos) {
        return 0.0f;
    }

    private boolean randomBoolean() {
        int randomNumber = (int) Math.floor(Math.random() * 2);
        return (randomNumber == 1);
    }
}
