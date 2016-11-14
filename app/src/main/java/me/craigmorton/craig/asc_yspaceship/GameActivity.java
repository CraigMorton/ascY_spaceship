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

    CanvasLayout layoutClass;
    protected static DisplayMetrics displayMetrics;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //removes title bar and makes fullscreen:
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        layoutClass = new CanvasLayout(this);
        layoutClass.setOwnerActivity(this);
        setContentView(layoutClass);


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
        layoutClass.updateScreenSize();

    }

    private void updateDisplayMetrics(){
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    }

    protected DisplayMetrics getDisplayMetrics(){
        updateDisplayMetrics();
        return displayMetrics;
    }

    @Override
    protected void onPause(){
        super.onPause();
        layoutClass.pause();
    }

    @Override
    protected void onResume(){
        super.onResume();
        layoutClass.resume();
    }



}
