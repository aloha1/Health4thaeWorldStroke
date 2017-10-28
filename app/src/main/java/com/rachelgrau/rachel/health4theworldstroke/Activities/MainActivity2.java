package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.LearnActivity.EXTRA_PAGE_TYPE;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.LearnActivity.PAGE_TYPE_READ;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.exercise.data;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2_new);
        setUpToolbar();
    }
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.home);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.ll_help_me_speak) {
            Intent intent = new Intent(this, HelpMeSpeakActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_exercise) {
            Intent intent = new Intent(this, exercise.class);
            intent.putExtra(data, "o");
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_learn) {
            Intent intent = new Intent(this, LearnActivity.class);
            intent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_READ);
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_reminders) {
            Intent intent = new Intent(this, RemindersActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_general_info) {
            /*Intent intent = new Intent(this, InfoListActivity.class);*/
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.ll_survey) {
            Intent intent = new Intent(this, password_gateway.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_1) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            intent.putExtra("Feeling","Awesome");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_2) {
            Intent intent = new Intent(MainActivity2.this, ChatBotMainActivity.class);
            intent.putExtra("Feeling","Happy");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_3) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            intent.putExtra("Feeling","Sad");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_4) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            intent.putExtra("Feeling","Sad");
            startActivity(intent);
        }
        if (v.getId() == R.id.iv_feeling_5) {
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            intent.putExtra("Feeling","Very Sad");
            startActivity(intent);
        }
    }
}