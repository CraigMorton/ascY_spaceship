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

    public float updateXMultiplier(float prevXPos) {
        return prevXPos -= 0.01f;
    }

    public float updateYMultiplier(float prevYPos) {
        float newCoordMultiplier = prevYPos;
        if (randomBooleanGenerator.getRandom()) {
            newCoordMultiplier += 0.025f;
        } else {
            newCoordMultiplier -= 0.025f;
        }
        return newCoordMultiplier;
    }

}
