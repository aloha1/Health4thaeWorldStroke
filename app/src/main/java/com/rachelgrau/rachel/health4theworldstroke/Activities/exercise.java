package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.Locale;

import static android.view.ViewGroup.LayoutParams.FILL_PARENT;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.exercise_option.option_data;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.illustrations.illName;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.videoPlayer.videoName;

public class exercise extends AppCompatActivity {

    static String data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        playVideo();
        setUpToolbar();
    }

    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.exercise);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.strengthButton || v.getId() == R.id.imageView1 || v.getId() == R.id.text1) {
            Intent intent = new Intent(this, exercise_option.class);
            intent.putExtra(option_data, getString(R.string.Strengthening));
            startActivity(intent);
        }
        if (v.getId() == R.id.stretchButton || v.getId() == R.id.imageView2 || v.getId() == R.id.text2) {
            Intent intent = new Intent(this, exercise_option.class);
            intent.putExtra(option_data, getString(R.string.Stretching));
            startActivity(intent);
        }
        if (v.getId() == R.id.functionButton || v.getId() == R.id.imageView3 || v.getId() == R.id.text3) {
            Intent intent = new Intent(this, exercise_option.class);
            intent.putExtra(option_data, getString(R.string.Function_Mobility));
            startActivity(intent);
        }
        if (v.getId() == R.id.mindButtton || v.getId() == R.id.imageView4 || v.getId() == R.id.text4) {
            Intent intent = new Intent(this, VR_menu.class);
            startActivity(intent);
        }

    }

    public void playVideo() {
        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.female_doc;
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }
}
