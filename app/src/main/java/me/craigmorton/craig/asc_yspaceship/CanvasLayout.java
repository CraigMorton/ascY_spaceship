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

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 04/05/2016.
 */
public class CanvasLayout extends SurfaceView implements Runnable {

    Thread gameLoop;
    boolean rendering = false;
    private int screenWidth;
    private int screenHeight;
//    private int lastUpdated;
    private GameActivity activity;
    Bitmap background;
    Canvas canvas;
    SurfaceHolder surfaceHolder;

    public CanvasLayout(Context context){
        super(context);
        this.activity = (GameActivity) context;
        updateScreenSize();
        surfaceHolder = getHolder();
        background = Bitmap.createBitmap(screenWidth, screenHeight, Bitmap.Config.ARGB_8888);

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

    private void reRender(){
        canvas = surfaceHolder.lockCanvas();
        canvas.drawBitmap(background, 0, 0, null);

        Paint paint = new Paint();
//            paint.setColor(Color.BLACK);
//            float screenWidthFloat = (float) screenWidth;
//            float screenHeightFloat = (float) screenHeight;
//            canvas.drawRect(0.0f, 0.0f, screenWidthFloat, screenHeightFloat, paint);
//            canvas.drawColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);

        paint.setColor(Color.WHITE);
        paint.setTextSize(40);
        char[] textToDraw = SpaceShip.ASCII_ART;
        canvas.drawText(textToDraw, 0, textToDraw.length, 300, 300, paint);

        Log.d("<=>", "text to draw: " + textToDraw[0] + textToDraw[1] + textToDraw[2]);
        Log.d("<=>", "Screen: W: " + screenWidth + " x H: " + screenHeight);

        Log.d("<=>", "half screen sizes: WHITE");
        canvas.drawText(textToDraw, 0, textToDraw.length, screenWidth / 2, screenHeight / 2, paint);

        paint.setColor(Color.YELLOW);
        Log.d("<=>", "half screen sizes: YELLOW");
        canvas.drawText(textToDraw, 0, textToDraw.length, screenWidth / 2, screenHeight, paint);

        paint.setColor(Color.RED);
        Log.d("<=>", "ZERO ZERO: RED");
        canvas.drawText(textToDraw, 0, textToDraw.length, 0, 40, paint);
        Log.d("<=>", "100 100: RED");
        canvas.drawText(textToDraw, 0, textToDraw.length, 100, 100, paint);

        Log.d("<=>", "----------------------------------------------------------");
        Log.d("<=>", "screen size / 40: " + (screenWidth / 40) + " x " + (screenHeight / 40));


        surfaceHolder.unlockCanvasAndPost(canvas);
    }

    @Override
    public void run() {
        while (rendering){
            if (!surfaceHolder.getSurface().isValid()){
                resume();
                continue;
            }

            try {

                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateScreenSize();
            reRender();
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
