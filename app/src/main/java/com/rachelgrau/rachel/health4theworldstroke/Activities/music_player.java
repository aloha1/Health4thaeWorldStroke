package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import java.io.IOException;

public class music_player extends AppCompatActivity {

    String url,music_name;
    MediaPlayer mp;
    ImageButton btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        url=getIntent().getStringExtra("Url");
        music_name=getIntent().getStringExtra("audio_name");
        btn=(ImageButton) findViewById(R.id.btn);
        tv=(TextView) findViewById(R.id.name) ;
        onReady();
    }
    public void onReady(){
        mp = new MediaPlayer();
        tv.setText(music_name);
        try {
            mp.setDataSource(url);
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onClick(View v){
        if(mp.isPlaying()){
            mp.pause();
            btn.setImageResource(R.drawable.play_off);
        }else{
            mp.start();
            btn.setImageResource(R.drawable.play_on);
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
        finish();
    }
}
