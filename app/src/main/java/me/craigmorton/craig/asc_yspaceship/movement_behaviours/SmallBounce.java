package me.craigmorton.craig.asc_yspaceship.movement_behaviours;

/**
 * Created by user on 28/11/2016.
 */

public class SmallBounce implements MovementBehaviour {

    RandomBoolean randomBooleanGenerator;

    public SmallBounce() {
        randomBooleanGenerator = new RandomBoolean();
    }

    public SmallBounce(RandomBoolean randomBooleanGenerator) {
        this.randomBooleanGenerator = randomBooleanGenerator;
    }

    public float updateXPos(float prevXPos) {
        float newCoordMultiplier = prevXPos;
        if (randomBooleanGenerator.getRandom()) {
            newCoordMultiplier += 0.05f;
        } else {
            newCoordMultiplier -= 0.05f;
        }
        return newCoordMultiplier;
    }

    public float updateYPos(float prevYPos) {
        return 0.0f;
    }

}
