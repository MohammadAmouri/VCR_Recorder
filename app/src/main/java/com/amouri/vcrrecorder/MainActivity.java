package com.amouri.vcrrecorder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends Activity {

    /** Duration of wait **/
    private final int SPLASH_ACTIVITY_TIME = 4000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle image_1) {
        super.onCreate(image_1);
        setContentView(R.layout.activity_main);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent flashIntent = new Intent(MainActivity.this, VideoRecorder.class);
                MainActivity.this.startActivity(flashIntent);
                MainActivity.this.finish();
            }
        }, SPLASH_ACTIVITY_TIME);
    }
}