package me.craigmorton.craig.asc_yspaceship;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 04/05/2016.
 */
public class GameLayout extends SurfaceView implements Runnable {

    Thread thread;
    boolean canDraw = false;

    int mScreenWidth;
    int mScreenHeight;

    Bitmap mBackgroundBitmap;
    Canvas mCanvas;
    SurfaceHolder mSurfaceHolder;

    public GameLayout(Context context){
        super(context);
        mSurfaceHolder = getHolder();

        getScreenSize();

        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
        mBackgroundBitmap = Bitmap.createBitmap(mScreenWidth, mScreenHeight, conf); // this creates a MUTABLE bitmap

    }

    protected void getScreenSize(){
        mScreenWidth = GameActivity.mDisplayMetrics.widthPixels;
        mScreenHeight = GameActivity.mDisplayMetrics.heightPixels;
    }

    @Override
    public void run() {
        while (canDraw){

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // draw stuff
            if (!mSurfaceHolder.getSurface().isValid()){
                continue;
            }

            mCanvas = mSurfaceHolder.lockCanvas();
            mCanvas.drawBitmap(mBackgroundBitmap, 0, 0, null);

            Paint paint = new Paint();
            paint.setColor(Color.WHITE);
            paint.setTextSize(40);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            char[] textToDraw = SpaceShip.ASCII_ART;
            mCanvas.drawText(textToDraw, 0, textToDraw.length, 300, 300, paint);

            Log.d("app-log", "text to draw: " + textToDraw);
            Log.d("app-activity", "Screen: W: " + mScreenWidth + " x H: " + mScreenHeight);
            Log.d("draw", "half screen sizes: WHITE");
            mCanvas.drawText(textToDraw, 0, textToDraw.length, mScreenWidth/2, mScreenHeight/2, paint);
            Log.d("draw", "half screen sizes: YELLOW");
            paint.setColor(Color.YELLOW);
            mCanvas.drawText(textToDraw, 0, textToDraw.length, mScreenWidth/2, mScreenHeight, paint);
            Log.d("draw", "ZERO ZERO: RED");
            paint.setColor(Color.RED);
            mCanvas.drawText(textToDraw, 0, textToDraw.length, 0, 40, paint);
            Log.d("draw", "100 100: RED");
            mCanvas.drawText(textToDraw, 0, textToDraw.length, 100, 100, paint);
            Log.d("app-activity", "text should be drawn");




            mSurfaceHolder.unlockCanvasAndPost(mCanvas);



        }
    }

    public void pause(){
        while (true) {
            try {
                thread.join();
                break;
//                thread = null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                Log.e("<=> - layout",e.getMessage());
            }
        }
        thread = null;

        // alt:
//        try {
//            thread.join();
//            thread = null;
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public void resume(){
        canDraw = true;
        thread = new Thread(this);
        thread.start();
    }

}
