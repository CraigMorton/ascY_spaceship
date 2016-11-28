package me.craigmorton.craig.asc_yspaceship;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 28/11/2016.
 */

public class SmallBounceMovementTest {

    SmallBounceMovement movement;

    @Before
    public void before() {
        movement = new SmallBounceMovement();
    }

    @Test
    public void movesXPosBy5Percent() {
        float xPos = 0.5f;
        float newXPos = movement.updateXPos(xPos);
        assertEquals(0.55f, newXPos, 0.01f);
    }
}
