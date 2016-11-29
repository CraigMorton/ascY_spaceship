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
        float yMultiplier = 0.5f;
        float newYMultiplier = movement.updateYMultiplier(yMultiplier);
        assertEquals(0.525f, newYMultiplier, 0.001f);
    }

    @Test
    public void movesXMultiplier1Percent() {
        float xMultiplier = 1f;
        float newXMultiplier = movement.updateXMultiplier(xMultiplier);
        assertEquals(0.99f, newXMultiplier, 0.001f);
    }
}
