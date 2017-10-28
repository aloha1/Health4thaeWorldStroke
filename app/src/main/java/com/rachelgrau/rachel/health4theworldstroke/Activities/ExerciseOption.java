package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.illustrations.illName;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.videoPlayer.videoName;

public class ExerciseOption extends AppCompatActivity {

    static String option_data = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_option);
        option_data = getIntent().getStringExtra(option_data);
        setUpToolbar();
        changer(option_data);

    }

    public void changer(String name) {

        if (name.equals(getString(R.string.Strengthening))) {
            addXml(2);
            textChanger(1);
        }
        if (name.equals(getString(R.string.Legs))) {
            addXml(1);
            textChanger(11);
        }
        if (name.equals(getString(R.string.Arms))) {
            addXml(1);
            textChanger(12);
        }
        if (name.equals(getString(R.string.Coordination))) {
            addXml(1);
            textChanger(13);
        }
        if (name.equals(getString(R.string.Stretching))) {
            addXml(2);
            textChanger(2);
        }
        if (name.equals(getString(R.string.Leg_Feet))) {
            addXml(1);
            textChanger(21);
        }
        if (name.equals(getString(R.string.Arms_Hands))) {
            addXml(1);
            textChanger(22);
        }
        if (name.equals(getString(R.string.Function_Mobility))) {
            addXml(1);
            textChanger(3);
        }
    }

    public void textChanger(int n) {

        TextView OptionTV1 = (TextView) findViewById(R.id.optionTV1);
        ImageView OptionIV1 = (ImageView) findViewById(R.id.optionIV1);

        TextView OptionTV2 = (TextView) findViewById(R.id.optionTV2);
        ImageView OptionIV2 = (ImageView) findViewById(R.id.optionIV2);

        TextView OptionTV3 = (TextView) findViewById(R.id.optionTV3);
        ImageView OptionIV3 = (ImageView) findViewById(R.id.optionIV3);

        TextView OptionTV4 = (TextView) findViewById(R.id.optionTV4);
        ImageView OptionIV4 = (ImageView) findViewById(R.id.optionIV4);

        LinearLayout ll3 = (LinearLayout) findViewById(R.id.option3);
        LinearLayout ll4 = (LinearLayout) findViewById(R.id.option4);

        ScrollView sv = (ScrollView) findViewById(R.id.optionScroll);

        switch (n) {

            case 1:
                OptionTV1.setText(getString(R.string.Legs));
                OptionIV1.setImageResource(R.drawable.legs);
                OptionTV2.setText(R.string.Arms);
                OptionIV2.setImageResource(R.drawable.strengthing);
                OptionTV3.setText(R.string.Coordination);
                OptionIV3.setImageResource(R.drawable.coordination);
                ll4.setVisibility(View.GONE);
                break;
            case 11:
                OptionTV1.setText(getString(R.string.Toe));
                OptionIV1.setImageResource(R.drawable.toe);
                OptionTV2.setText(R.string.Knee);
                OptionIV2.setImageResource(R.drawable.knee);
                OptionTV3.setText(R.string.Hip);
                OptionIV3.setImageResource(R.drawable.hip);
                ll4.setVisibility(View.GONE);
                break;
            case 12:
                OptionTV1.setText(getString(R.string.Elbow));
                OptionIV1.setImageResource(R.drawable.elbow);
                OptionTV2.setText(R.string.Shoulder);
                OptionIV2.setImageResource(R.drawable.shoulder);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                break;
            case 13:
                OptionTV1.setText(getString(R.string.Leg_1));
                OptionIV1.setImageResource(R.drawable.leg1);
                OptionTV2.setText(R.string.Leg_2);
                OptionIV2.setImageResource(R.drawable.leg2);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                break;
            case 2:
                OptionTV1.setText(R.string.Leg_Feet);
                OptionIV1.setImageResource(R.drawable.legs);
                OptionTV2.setText(R.string.Arms_Hands);
                OptionIV2.setImageResource(R.drawable.strengthing);
                ll3.setVisibility(View.GONE);
                ll4.setVisibility(View.GONE);
                break;
            case 21:
                OptionTV1.setText(getString(R.string.Adductores));
                OptionIV1.setImageResource(R.drawable.rsz_adductors1);
                OptionTV2.setText(R.string.Hamstrings);
                OptionIV2.setImageResource(R.drawable.rsz_hamstrings2);
                OptionTV3.setText(R.string.Dorsiflexors);
                OptionIV3.setImageResource(R.drawable.rsz_dorsiflexors2);
                ll4.setVisibility(View.GONE);
                break;
            case 22:
                OptionTV1.setText(getString(R.string.Hand_Stretch));
                OptionIV1.setImageResource(R.drawable.rsz_hand2);
                OptionTV2.setText(R.string.Shoulder_Stretches);
                OptionIV2.setImageResource(R.drawable.rsz_1shoulder2);
                OptionTV3.setText(R.string.Arm_Stretch);
                OptionIV3.setImageResource(R.drawable.rsz_1hand2);
                ll4.setVisibility(View.GONE);
                break;
            case 3:
                OptionTV1.setText(R.string.Bridge_hip);
                OptionIV1.setImageResource(R.drawable.bridge_hip);
                OptionTV2.setText(R.string.Arm_trunk);
                OptionIV2.setImageResource(R.drawable.arm_trunk);
                OptionTV3.setText(R.string.Sittostand);
                OptionIV3.setImageResource(R.drawable.sit_to_stand);
                ll4.setVisibility(View.GONE);
                break;
        }
    }

    public void onClick(View v) {

        TextView OptionTV1 = (TextView) findViewById(R.id.optionTV1);
        TextView OptionTV2 = (TextView) findViewById(R.id.optionTV2);
        TextView OptionTV3 = (TextView) findViewById(R.id.optionTV3);

        /*for strengthning*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Legs))) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Legs));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Arms))) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Arms));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Coordination))) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Coordination));
            startActivity(intent);
        }

        /*for streching*/

        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Leg_Feet))) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Leg_Feet));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Arms_Hands))) {
            Intent intent = new Intent(this, ExerciseOption.class);
            intent.putExtra(option_data, getString(R.string.Arms_Hands));
            startActivity(intent);
        }

         /*video strengthning*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Toe))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Toe));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Knee))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Knee));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Hip))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Hip));
            startActivity(intent);
        }
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Elbow))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Elbow));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Shoulder))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Shoulder));
            startActivity(intent);
        }
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Leg_1))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Leg_1));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Leg_2))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Leg_2));
            startActivity(intent);
        }

        //video streching
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Adductores))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Adductores);
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Hamstrings))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Hamstrings);
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Dorsiflexors))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Dorsiflexors);
            startActivity(intent);
        }
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Hand_Stretch))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Hand_Stretch);
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Shoulder_Stretches))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Shoulder_Stretches);
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Arm_Stretch))) {
            Intent intent = new Intent(this, illustrations.class);
            intent.putExtra(illName, R.string.Arm_Stretch);
            startActivity(intent);
        }

        /*functional mobility*/
        if (v.getId() == R.id.option1 && OptionTV1.getText().equals(getString(R.string.Bridge_hip))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Bridge_hip));
            startActivity(intent);
        }
        if (v.getId() == R.id.option2 && OptionTV2.getText().equals(getString(R.string.Arm_trunk))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Arm_trunk));
            startActivity(intent);
        }
        if (v.getId() == R.id.option3 && OptionTV3.getText().equals(getString(R.string.Sittostand))) {
            Intent intent = new Intent(this, videoPlayer.class);
            intent.putExtra(videoName, getString(R.string.Sittostand));
            startActivity(intent);
        }
    }

    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(option_data);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    public void addXml(int info) {
        if (info == 1) {
            ScrollView sv = (ScrollView) findViewById(R.id.optionScroll);
            LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            sv.addView(layoutInflater.inflate(R.layout.options, null));
        }
        if (info == 2) {
            ScrollView sv = (ScrollView) findViewById(R.id.optionScroll);
            LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            sv.addView(layoutInflater.inflate(R.layout.exercises_box, null));
        }

    }
}