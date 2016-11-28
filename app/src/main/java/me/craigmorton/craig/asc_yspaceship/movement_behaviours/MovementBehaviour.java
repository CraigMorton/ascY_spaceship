package me.craigmorton.craig.asc_yspaceship.movement_behaviours;

/**
 * Created by user on 28/11/2016.
 */

public interface MovementBehaviour {
    float updateXMultiplier(float prevXPos);
    float updateYMultiplier(float prevYPos);

}
