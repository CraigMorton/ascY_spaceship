package me.craigmorton.craig.asc_yspaceship.movement_behaviours;

/**
 * Created by user on 28/11/2016.
 */

public class RandomBoolean {
    public static boolean getRandom() {
        int randomNumber = (int) Math.floor(Math.random() * 2);
        return (randomNumber == 1);
    }
}
