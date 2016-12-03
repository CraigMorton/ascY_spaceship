package me.craigmorton.craig.asc_yspaceship;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;

import me.craigmorton.craig.asc_yspaceship.movement_behaviours.NoMovement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

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

    @Test
    public void movementOnlyConstructorSetsDefaults() {
        CanvasEntity ship = new SpaceShip(new NoMovement());
        assertEquals(Color.WHITE, ship.getColour());
        assertArrayEquals(new char[] {'<', '=', '>'}, ship.getAsciiArt());
        assertEquals(0.5f, ship.getXCoordMultiplier(), 0.001f);
        assertEquals(0.5f, ship.getYCoordMultiplier(), 0.001f);
        assertEquals(NoMovement.class, ship.movementBehaviour.getClass());
    }

    @Test
    public void coordOnlyConstructorSetsDefaults() {
        CanvasEntity ship = new SpaceShip(0.8f, 0.8f);
        assertEquals(Color.WHITE, ship.getColour());
        assertArrayEquals(new char[] {'<', '=', '>'}, ship.getAsciiArt());
        assertEquals(0.8f, ship.getXCoordMultiplier(), 0.001f);
        assertEquals(0.8f, ship.getYCoordMultiplier(), 0.001f);
        assertEquals(NoMovement.class, ship.movementBehaviour.getClass());
    }

    @Test
    public void fullConstructorSetsAppearanceDefaults() {
        CanvasEntity ship = new SpaceShip(0.7f, 0.7f, new NoMovement());
        assertEquals(Color.WHITE, ship.getColour());
        assertArrayEquals(new char[] {'<', '=', '>'}, ship.getAsciiArt());
        assertEquals(0.7f, ship.getXCoordMultiplier(), 0.001f);
        assertEquals(0.7f, ship.getYCoordMultiplier(), 0.001f);
        assertEquals(NoMovement.class, ship.movementBehaviour.getClass());
    }
}
