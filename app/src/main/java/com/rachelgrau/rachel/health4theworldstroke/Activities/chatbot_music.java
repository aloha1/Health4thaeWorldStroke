package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.music_adapter;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.rachelgrau.rachel.health4theworldstroke.R.id.parent;

public class chatbot_music extends AppCompatActivity {

    String audio_name[];
    int position_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot_music);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setNumColumns(3);
        /*gridview.setAdapter(new music_adapter(this));*/

        // name of the audio file
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

        // Populate a List from Array elements
        final List<String> plantsList = new ArrayList<String>(Arrays.asList(audio_name));

        // Data bind GridView with ArrayAdapter (String Array elements)
        gridview.setAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, plantsList) {
            public View getView(int position, View convertView, ViewGroup parent) {

                // Return the GridView current item as a View
                View view = super.getView(position, convertView, parent);

                // Convert the view as a TextView widget
                TextView tv = (TextView) view;
                tv.setBackgroundResource(R.drawable.music_style);

                tv.setTextColor(Color.WHITE);

                // Set the layout parameters for TextView widget
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT
                );
                tv.setLayoutParams(lp);

                // Get the TextView LayoutParams
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tv.getLayoutParams();

                // Set the TextView layout parameters
                tv.setLayoutParams(params);

                // Display TextView text in center position
                tv.setGravity(Gravity.CENTER);

                // Set the TextView text (GridView item text)
                tv.setText(plantsList.get(position));

                // Return the TextView widget as GridView item
                return tv;
            }
        });

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