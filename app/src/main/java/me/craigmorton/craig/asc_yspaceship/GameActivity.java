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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpFullscreen();
        surfaceLayout = new CanvasLayout(this);
        refreshDisplayMetrics();
        setContentView(surfaceLayout);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        refreshDisplayMetrics();
    }

    @Override
    protected void onPause() {
        super.onPause();
        surfaceLayout.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        surfaceLayout.resume();
    }

    private void setUpFullscreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    protected void refreshDisplayMetrics() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        if (surfaceLayout == null) return;
        surfaceLayout.updateScreenSize(displayMetrics);
    }

}
