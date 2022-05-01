package edu.hanu.tutorial04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {
    VideoView videoView = findViewById(R.id.videoView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        //get link to video
        Intent intent = getIntent();
        String link_parse = intent.getStringExtra("LINK");




        videoView.setMediaController(new MediaController(this));
        videoView.setVideoPath(link_parse);
//        videoView.start();
    }
    @Override
    protected void onStart() {
        super.onStart();
        videoView.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }

    @Override
    public void onRestoreInstance(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(outState);

        int currentPositionInMilliseconds = videoView.getCurrentPosition();
        outState.putInt("CURRENT_POSITION", currentPositionInMilliseconds);
    }


}