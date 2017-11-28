package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.VideoView;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.ExerciseInstructionAdapter;
import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.ExerciseOption.option_data;

public class Exercise extends AppCompatActivity {

    static String data = "";
    private String[] instructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_new);
        setUpToolbar();
        //TODO: replace string with getString(R.string.xxx);
        instructions = new String[]{
                getString(R.string.exercise_activity_text_pt1),
                getString(R.string.exercise_activity_text_pt2),
                getString(R.string.exercise_activity_text_pt3),
                getString(R.string.exercise_activity_text_pt4),
                getString(R.string.exercise_activity_text_pt5)
        };
        setUpInstruction();
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

        if (v.getId() == R.id.ll_strength) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Strengthening));
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_stretch) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Stretching));
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_function) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Function_Mobility));
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_mind) {
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

    private void setUpInstruction() {
        ListView listView = (ListView) findViewById(R.id.lv_instruction);
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.view_content_exercise, listView, false);
        listView.addHeaderView(header);
        listView.setAdapter(new ExerciseInstructionAdapter(this, instructions));
    }

    @Override
    protected void onResume() {
        super.onResume();
        playVideo();
    }
}
