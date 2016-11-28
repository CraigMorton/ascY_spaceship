package me.craigmorton.craig.asc_yspaceship;

/**
 * Created by user on 28/11/2016.
 */

public class SmallBounceMovement implements Movement {

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
