package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rachelgrau.rachel.health4theworldstroke.R;

import java.io.IOException;

public class music_player extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton btn;
    TextView tv;
    int indexPlaying; /*Index of the link which is playing */
    String[] links;
    String[] audio_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        indexPlaying=getIntent().getIntExtra("audio_position",0);
        btn=(ImageButton) findViewById(R.id.btnPlay);
        tv=(TextView) findViewById(R.id.name) ;

        //Linkes of all the audio file
        links =new String[] {"https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/acoustic-guitar-piano-underscore_M1OKaHS_.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/acoustic-loop-10_zyj2_N4u.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/acoustic-loop-4_fylndV4u.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/ambient-background-music-1-loop_z1QW6rBd.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/dawn_Gk5uoHS_.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/gymnopedie_z1Zn3BH_.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/jdi-0314-happy-gmaj-piano.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/jdi-acoustic-guitar-jam-1-032314-9.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/just-a-smile_fkPjarBO.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/life_z1jS5SHu.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/melodic-acoustic-advert-music_fkQXiVNu.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/melodic-piano-atmosphere_MyvXjE4O.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/mid-summer-evening_z1FwVUB_.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/mozart-piano-sonata-no-16_MJbUs4Nu.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sit-back-and-relax-ambient-sound-texture_zJeWh4NO.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sleeping-peacefully_GJkBQ8ru.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sunrise-without-you_fJ3zyBEu.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sweet-sweet-dreams-inst-full_f1W7K4EO.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/under-the-ocean-sun-loop_zJlMKVVO.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/welcome-home_fy7v7UB_.mp3",
                "https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/yesterday_zkDX1S4d.mp3"};

        // Name of all the videos to be displayed
        audio_name = new String[]{
                "Acoustic Guitar Piano",
                "Acoustic Loop",
                "Acoustic Loop 2",
                "Ambient Background Music",
                "Dawn",
                "Gymnopedie",
                "Happy Gmaj Piano",
                "Acoustic Guitar Jam",
                "Just a Smile",
                "Life",
                "Melodic Acoustic Music",
                "Melodic Piano Atmosphere",
                "Mid Summer Evening",
                "Mozart Piano Sonata",
                "Sit Back And Relax Ambient",
                "Sleeping Peacefully",
                "Sunrise Without You",
                "Sweet Sweet Dreams",
                "Under The Ocean Sun",
                "Welcome Home",
                "Yesterday"};

        onReady("Play");
    }

    public void onReady(String operation){
        if(operation.equals("Play")){
            play_music(links[indexPlaying]);
        }
        if(operation.equals("Next")){
            indexPlaying=indexPlaying+1;
            if(indexPlaying<=audio_name.length){
                play_music(links[indexPlaying]);
            }else{
                indexPlaying=0;
                Toast.makeText(this,"No more next Song",Toast.LENGTH_SHORT).show();
            }
        }
        if(operation.equals("Previous")){
            indexPlaying=indexPlaying-1;
            if(indexPlaying>=0){
                play_music(links[indexPlaying]);
            }else{
                indexPlaying=audio_name.length;
                Toast.makeText(this,"No more previous Song",Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void onClick(View v){
        if(v.getId()==R.id.btnNext){
            mp.stop();
            btn.setImageResource(R.drawable.play_off);
            onReady("Next");
        }if(v.getId()==R.id.btnPrevious){
            mp.stop();
            btn.setImageResource(R.drawable.play_off);
            onReady("Previous");
        }if(v.getId()==R.id.btnPlay){
            if(mp.isPlaying()){
                mp.pause();
                btn.setImageResource(R.drawable.play_off);
            }else{
                mp.start();
                btn.setImageResource(R.drawable.play_on);
            }
        }if(v.getId()==R.id.BackBtn){
            onBackPressed();
        }

    }
    public void play_music(String Purl){  /*Purl: Play this url*/
        mp = new MediaPlayer();
        tv.setText(audio_name[indexPlaying]);
        try {
            mp.setDataSource(Purl);
            mp.prepare();
            btn.setImageResource(R.drawable.play_on);
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mp.stop();
        finish();
    }
}
