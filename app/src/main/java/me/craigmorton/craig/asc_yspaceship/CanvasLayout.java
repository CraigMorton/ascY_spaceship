package me.craigmorton.craig.asc_yspaceship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 04/05/2016.
 */
public class CanvasLayout extends SurfaceView implements Runnable {

    Thread gameLoop;
    boolean rendering;
    private int screenWidth;
    private int screenHeight;
    private int lastUpdated;
    private GameActivity activity;
    Bitmap background;
    Canvas canvas;
    Paint paint;
    SurfaceHolder surfaceHolder;
    private ArrayList<CanvasEntity> canvasEntities;

    public CanvasLayout(Context context){
        super(context);
        this.activity = (GameActivity) context;
        rendering = false;
        canvasEntities = new ArrayList<CanvasEntity>();
        updateScreenSize();
        surfaceHolder = getHolder();
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        background = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        background = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);
        canvasEntities.add(new SpaceShip());
        canvasEntities.add(new Reward());

        lastUpdated = 0;

        resume();

    }

    protected void updateScreenSize(){
        if (activity != null){
            DisplayMetrics displayMetrics = activity.updateDisplayMetrics();
            updateScreenSize(displayMetrics);
        }
    }

    protected void updateScreenSize(DisplayMetrics displayMetrics) {
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
    }

    private void renderAllEntities() {
        for (CanvasEntity entity : canvasEntities) {
            entity.updatePosition();
            renderItem(entity);
        }
    }

    private void renderItem(CanvasEntity item) {
        paint.setTextSize(item.getAsciiSize());
        paint.setColor(item.getColour());

        float xPosPercentage = item.getXPos();
        float xPosMultiplier = xPosPercentage / 100;
        int xPos = (int) (xPosMultiplier * screenWidth);
        float yPosPercentage = item.getYPos();
        float yPosMultiplier = yPosPercentage / 100;
        int yPos = (int) (yPosMultiplier * screenHeight);
        Log.d("<=>", Integer.toString(xPos) + " " + Integer.toString(yPos));
        canvas.drawText(item.getAscii(), 0, item.getAscii().length , xPos, yPos, paint);
    }

//    private void renderTestSpaceShip() {
//        paint.setColor(Color.WHITE);
//        paint.setTextSize(40);
//        char[] textToDraw = canvasEntities.get(0).getAscii();
//        Log.d("<=>", "time now:" + Long.toString(new Date().getTime() ) );
//        Log.d("<=>", "text to draw: " + textToDraw[0] + textToDraw[1] + textToDraw[2]);
//        Log.d("<=>", "Screen: W: " + screenWidth + " x H: " + screenHeight);
//        Log.d("<=>", "half screen sizes: WHITE");
//        canvas.drawText(textToDraw, 0, textToDraw.length, screenWidth / 2, screenHeight / 2, paint);
//    }

    private void render(){
//        lastUpdated = (int) (System.currentTimeMillis() / 1000L);
        int timeNow = (int) (System.currentTimeMillis() / 1000L);
        if (timeNow - lastUpdated < 1) {
            return;
        }
        lastUpdated = timeNow;
        canvas = surfaceHolder.lockCanvas();
//        canvas.drawBitmap(background, 0, 0, null);

        // clear canvas between rerenders:
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        renderAllEntities();

//        renderTestSpaceShip();

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

//            try {
//                Thread.sleep(1000);
//                TimeUnit.SECONDS.sleep(1);

                updateScreenSize();
                render();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }
    }

    public void pause(){
        boolean threadRunning = true;
        while (threadRunning) {
            try {
                gameLoop.join();
                gameLoop = null;
                threadRunning = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("<=> - layout", e.getMessage());
            }
        }
    }

    public void resume(){
        rendering = true;
        gameLoop = new Thread(this);
        gameLoop.start();
    }

}
