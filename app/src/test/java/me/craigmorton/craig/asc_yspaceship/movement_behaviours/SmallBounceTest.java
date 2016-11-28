package me.craigmorton.craig.asc_yspaceship.movement_behaviours;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 28/11/2016.
 */

public class SmallBounceTest {

    SmallBounce movement;

    @Before
    public void before() {
        movement = new SmallBounce(new FakeRandomBoolean());
    }

    @Test
    public void movesYMultiplier2point5Percent() {
        float xPos = 0.5f;
        float newXPos = movement.updateYMultiplier(xPos);
        assertEquals(0.525f, newXPos, 0.01f);
    }
}
