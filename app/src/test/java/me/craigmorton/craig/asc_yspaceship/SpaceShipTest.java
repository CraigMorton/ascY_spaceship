package me.craigmorton.craig.asc_yspaceship;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by user on 24/11/2016.
 */

public class SpaceShipTest {

    CanvasEntity ship;

    @Before
    public void before() {
        ship = new SpaceShip();
    }

    @Test
    public void updatePositionLeavesXPosConstant() {
        float prevXPos = ship.getXCoordMultiplier();
        ship.updatePosition();
        float newXPos = ship.getXCoordMultiplier();
        assertEquals(prevXPos, newXPos, 0.01f);
    }

}
