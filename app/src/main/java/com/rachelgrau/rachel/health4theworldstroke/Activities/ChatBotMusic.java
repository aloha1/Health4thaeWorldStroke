package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.MusicAdapter;
import com.rachelgrau.rachel.health4theworldstroke.R;

public class ChatBotMusic extends AppCompatActivity {

    String[] audio_name;
    int[] file_time;
    int position_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot_music);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setNumColumns(3);
        /*gridview.setAdapter(new MusicAdapter(this));*/

        // Initializing a new String Array
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
                "Yesterday"
        };

        file_time = new int[] {
                R.drawable.fill1,
                R.drawable.fill2,
                R.drawable.fill3,
                R.drawable.fill4,
                R.drawable.fill5,
                R.drawable.fill6,
                R.drawable.fill7,
                R.drawable.fill8,
                R.drawable.fill9,
                R.drawable.fill10,
                R.drawable.fill11,
                R.drawable.fill12,
                R.drawable.fill13,
                R.drawable.fill14,
                R.drawable.fill15,
                R.drawable.fill16,
                R.drawable.fill17,
                R.drawable.fill18,
                R.drawable.fill19,
                R.drawable.fill20,
                R.drawable.fill21
        };


        // Data bind GridView with MusicAdapter (String Array elements)
        gridview.setAdapter(new MusicAdapter(this, audio_name, file_time));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position_2=position;
                music_player(position_2);
            }
        });
    }

    public void music_player(int audio_Index) {
        Intent intent=new Intent(this,music_player.class);
        intent.putExtra("audio_position",audio_Index);
        startActivity(intent);
    }
}