package me.craigmorton.craig.asc_yspaceship;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by user on 04/05/2016.
 */
public class GameActivity extends Activity {

    CanvasLayout surfaceLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        removeTitleBar();

        surfaceLayout = new CanvasLayout(this);
        surfaceLayout.resume();
        setContentView(surfaceLayout);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

//        // Checks the orientation of the screen
//        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
//
//        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
//
//        }

        updateDisplayMetrics();
    }

    private void removeTitleBar() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    protected DisplayMetrics updateDisplayMetrics(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    @Override
    protected void onPause(){
        super.onPause();
        surfaceLayout.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        surfaceLayout.resume();
    }



}
