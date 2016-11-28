package me.craigmorton.craig.asc_yspaceship;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created by user on 04/05/2016.
 */
public class CanvasLayout extends SurfaceView implements Runnable {

    private GameActivity activity;
    SurfaceHolder surfaceHolder;
    private Thread canvasThread;
    Canvas canvas;
    Paint paint;
    private boolean rendering;
    private int width;
    private int height;
    private long lastUpdated;
    private ArrayList<CanvasEntity> canvasEntities;
    private int FPS;

    public CanvasLayout(Context context){
        super(context);
        surfaceHolder = getHolder();
        activity = (GameActivity) context;
        FPS = 60;
        canvasSetUp();
        populateCanvasEntities();
        resume();
    }

    private void canvasSetUp() {
        rendering = false; // unnecessary - is implicit default
        lastUpdated = 0; // unnecessary - is implicit default
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvasEntities = new ArrayList<CanvasEntity>();
    }

    private void populateCanvasEntities() {
        canvasEntities.add(new SpaceShip());
        canvasEntities.add(new Reward());
    }

    protected void updateScreenSize(){
        activity.refreshDisplayMetrics();
    }

    protected void updateScreenSize(DisplayMetrics displayMetrics) {
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }

    private void renderAllEntities() {
        for (CanvasEntity entity : canvasEntities) {
            entity.updatePosition();
            renderItem(entity);
        }
    }

    private void renderItem(CanvasEntity item) {
        paint.setTextSize(40);
        paint.setColor(item.getColour());

        int xPos = (int) (item.getXCoordMultiplier() * width);
        int yPos = (int) (item.getYCoordMultiplier() * height);

        Log.d("<=>", "rendering " + item.getString() + " at " + Integer.toString(xPos) + " x " + Integer.toString(yPos));
        canvas.drawText(item.getAsciiArt(), 0, item.getAsciiArt().length , xPos, yPos, paint);
    }


    private void render(){
        long timeNow = System.currentTimeMillis();
        if (timeNow - lastUpdated < 1000) return;
        lastUpdated = timeNow;

        canvas = surfaceHolder.lockCanvas();
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        renderAllEntities();
        surfaceHolder.unlockCanvasAndPost(canvas);
    }


    @Override
    public void run() {
        while (rendering){
            boolean surfaceValid = surfaceHolder.getSurface().isValid();
            if (!surfaceValid){
                resume();
                continue;
            }
            render();
        }
    }

    public void pause(){
        boolean threadRunning = true;
        while (threadRunning) {
            try {
                canvasThread.join();
                canvasThread = null;
                threadRunning = false;
                rendering = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("<=> - canvas", e.getMessage());
            }
        }
    }

    public void resume(){
        rendering = true;
        canvasThread = new Thread(this);
        canvasThread.start();
    }

}
