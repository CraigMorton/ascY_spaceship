package me.craigmorton.craig.asc_yspaceship;

import org.junit.Before;
import org.junit.Test;

import me.craigmorton.craig.asc_yspaceship.movement_behaviours.SmallBounce;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 28/11/2016.
 */

public class SmallBounceTest {

    SmallBounce movement;

    @Before
    public void before() {
        movement = new SmallBounce();
    }

    @Test
    public void movesXPosBy5Percent() {
        float xPos = 0.5f;
        float newXPos = movement.updateXPos(xPos);
        assertEquals(0.55f, newXPos, 0.01f);
    }
}