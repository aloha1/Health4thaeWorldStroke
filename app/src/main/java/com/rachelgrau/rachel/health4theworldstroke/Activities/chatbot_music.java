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

    String[] file_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot_music);

        GridView gridview = (GridView) findViewById(R.id.grid_view);
        gridview.setNumColumns(3);
        /*gridview.setAdapter(new music_adapter(this));*/

        // Initializing a new String Array
        file_name = new String[]{
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
        final List<String> plantsList = new ArrayList<String>(Arrays.asList(file_name));

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
                switch (position) {
                    case 0:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/acoustic-guitar-piano-underscore_M1OKaHS_.mp3",0);
                        break;
                    case 1:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/acoustic-loop-10_zyj2_N4u.mp3",1);
                        break;
                    case 2:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/acoustic-loop-4_fylndV4u.mp3",2);
                        break;
                    case 3:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/ambient-background-music-1-loop_z1QW6rBd.mp3",3);
                        break;
                    case 4:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/dawn_Gk5uoHS_.mp3",4);
                        break;
                    case 5:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/gymnopedie_z1Zn3BH_.mp3",5);
                        break;
                    case 6:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/jdi-0314-happy-gmaj-piano.mp3",6);
                        break;
                    case 7:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/jdi-acoustic-guitar-jam-1-032314-9.mp3",7);
                        break;
                    case 8:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/just-a-smile_fkPjarBO.mp3",8);
                        break;
                    case 9:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/life_z1jS5SHu.mp3",9);
                        break;
                    case 10:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/melodic-acoustic-advert-music_fkQXiVNu.mp3",10);
                        break;
                    case 11:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/melodic-piano-atmosphere_MyvXjE4O.mp3",11);
                        break;
                    case 12:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/mid-summer-evening_z1FwVUB_.mp3",12);
                        break;
                    case 13:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/mozart-piano-sonata-no-16_MJbUs4Nu.mp3",13);
                        break;
                    case 14:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sit-back-and-relax-ambient-sound-texture_zJeWh4NO.mp3",14);
                        break;
                    case 15:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sleeping-peacefully_GJkBQ8ru.mp3",15);
                        break;
                    case 16:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sunrise-without-you_fJ3zyBEu.mp3",16);
                        break;
                    case 17:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/sweet-sweet-dreams-inst-full_f1W7K4EO.mp3",17);
                        break;
                    case 18:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/under-the-ocean-sun-loop_zJlMKVVO.mp3",18);
                        break;
                    case 19:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/welcome-home_fy7v7UB_.mp3",19);
                        break;
                    case 20:
                        music_player("https://s3-us-west-1.amazonaws.com/h4twrelaxingmusic/h4twrelaxingmusic/yesterday_zkDX1S4d.mp3",20);
                        break;
                }
            }
        });
    }

    public void music_player(String URI, int audio_name) {
        Intent intent=new Intent(this,music_player.class);
        intent.putExtra("Url",URI);
        intent.putExtra("audio_name",file_name[audio_name]);
        startActivity(intent);

    }
}