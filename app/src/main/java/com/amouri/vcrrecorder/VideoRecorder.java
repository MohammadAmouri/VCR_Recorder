package com.amouri.vcrrecorder;

import android.content.Intent;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;


public class VideoRecorder extends Activity {

    private Button record_Vid, play_Vid;
    private VideoView video_view;
    private int S_CAM_APP_START = 0;
    private int CAM_MESSAGE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorder);


        record_Vid = (Button) findViewById(R.id.recordBtn);
        play_Vid = (Button) findViewById(R.id.openBtn);
        video_view = (VideoView) findViewById(R.id.video_View);


        record_Vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent call_Video_App = new Intent();
                call_Video_App.setAction(MediaStore.ACTION_VIDEO_CAPTURE);


                startActivityForResult(call_Video_App,S_CAM_APP_START );
            }


        });



        play_Vid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                video_view.start();
            }
        });
    }



    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        if(request == S_CAM_APP_START)
        {
            if(request == RESULT_OK)
            {
                Toast.makeText(getApplicationContext(),"Video recorded successfully",Toast.LENGTH_LONG).show();
            }
            else
            {
                Uri video_Uri = data.getData();
                video_view.setVideoURI(video_Uri);
            }
        }


    }


}