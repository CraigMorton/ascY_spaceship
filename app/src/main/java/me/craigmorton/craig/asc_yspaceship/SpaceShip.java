package me.craigmorton.craig.asc_yspaceship;

/**
 * Created by user on 04/05/2016.
 */
public class SpaceShip extends CanvasEntity{

    private int yPos;
    //Xposition should be constant
    private final int xPos = 1;

    protected static final char[] ASCII_ART = {'<', '=', '>'};

    public SpaceShip(){
        yPos = 0;
    }

    public SpaceShip(int yPos) {
        this.yPos = yPos;
    }

    @Override
    protected void setXPos(int newPos){
        return;
    }

}

