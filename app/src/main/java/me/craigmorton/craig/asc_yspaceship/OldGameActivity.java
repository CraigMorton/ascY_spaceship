package me.craigmorton.craig.asc_yspaceship;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class OldGameActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */
    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            mContentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    };


    protected DisplayMetrics metrics;
    protected int screenWidth;
    protected int screenHeight;

    protected SurfaceView mSurfaceView;
    protected SurfaceHolder mSurfaceHolder;
    protected Canvas mCanvas;

//      ONCLICK SYNTAX FOR LATER

//        // Set up the user interaction to manually show or hide the system UI.
//        mContentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("app-activity", "onCreate called");

        //removes title bar and makes fullscreen:
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;

        mSurfaceView = (SurfaceView) findViewById(R.id.fullscreen_surface);
        Log.d("app-", mSurfaceView.toString());
        mSurfaceHolder = mSurfaceView.getHolder();
        Log.d("app-", mSurfaceHolder.toString());


        Log.e("app-activity", "Screen: W: " + screenWidth + " x H: " + screenHeight);


//        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
//        Bitmap bmp = Bitmap.createBitmap(screenWidth, screenHeight, conf); // this creates a MUTABLE bitmap
        mCanvas = mSurfaceHolder.lockCanvas();
        Log.d("app-", mCanvas.toString());

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
//        SpaceShip.getAsciiArt()
        String textToDraw = "<=>";
        Log.e("app-log", "text to draw: " + textToDraw);
        mCanvas.drawText(textToDraw, screenWidth, screenHeight, paint);
        Rect r = new Rect(50, 50, 50, 50);
        mCanvas.drawRect(r, paint);
        Log.d("app-activity", "text should be drawn");

        mSurfaceHolder.unlockCanvasAndPost(mCanvas);


        }

    }
