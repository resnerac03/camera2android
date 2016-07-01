package com.example.bolanos.camera2videoimage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by BOLANOS on 6/30/2016.
 */
public class Display_Video_File extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_video_file);

        Intent intent = getIntent();
        String videoSrc = intent.getExtras().getString("VideoPath");
        Toast.makeText(getApplicationContext(),videoSrc,Toast.LENGTH_SHORT).show();

        playVideo(videoSrc);
    }

    private void playVideo(String videoPath){
        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        //videoView.setVideoPath(videoSrc);
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.start();

        MediaController mc = new MediaController(this);
        mc.setMediaPlayer(videoView);
        videoView.setMediaController(mc);
    }
}
