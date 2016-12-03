package me.craigmorton.craig.asc_yspaceship.movement_behaviours;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 30/11/2016.
 */

public class NoMovementTest {

    MovementBehaviour movement;

    @Before
    public void before() {
        movement = new NoMovement();
    }

    @Test
    public void xPosUnchanged() {
        float prevXPos = 1.0f;
        float newXPos = movement.updateXMultiplier(prevXPos);
        assertEquals(prevXPos, newXPos, 0.001f);
    }

    @Test
    public void yPosUnchanged() {
        float prevYPos = 1.0f;
        float newYPos = movement.updateXMultiplier(prevYPos);
        assertEquals(prevYPos, newYPos, 0.001f);
    }
}
