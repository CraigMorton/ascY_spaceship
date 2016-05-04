package me.craigmorton.craig.asc_yspaceship;

/**
 * Created by user on 04/05/2016.
 */
public class SpaceShip {

    // class variables
    private float mYPos;
    //Xposition should be constant!
    private final float mXPos;

    // static class varaibles
    protected static final char[] ASCII_ART = {'<', '=', '>'};
//    private static final String ASCII_ART = "<=>";

    // CONSTRUCTORS






    public SpaceShip(){
        mXPos = 1;
        mYPos = 0;

    }

    //GETTERS / SETTERS




    public float getmXPos() {
        return mXPos;
    }

    public float getmYPos() {
        return mYPos;
    }

}

