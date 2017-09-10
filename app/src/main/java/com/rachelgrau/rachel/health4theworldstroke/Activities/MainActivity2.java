package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        setContentView(R.layout.activity_main2);
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
    public void onClick(View v){

        if(v.getId()==R.id.helpMeSpeakButton || v.getId()==R.id.imageView1 || v.getId()==R.id.text1 ){
            Intent intent=new Intent(this,HelpMeSpeakActivity.class);
            startActivity(intent);
        }if(v.getId()==R.id.exercise_button || v.getId()==R.id.imageView2 || v.getId()==R.id.text2 ){
            Intent intent = new Intent(this, exercise.class);
            intent.putExtra(data,"o");
            startActivity(intent);
        }if(v.getId()==R.id.learnButton || v.getId()==R.id.imageView3 || v.getId()==R.id.text3 ){
            Intent intent = new Intent(this, LearnActivity.class);
            intent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_READ);
            startActivity(intent);
        }if(v.getId()==R.id.remindersButton || v.getId()==R.id.imageView4 || v.getId()==R.id.text4 ){
            Intent intent = new Intent(this, RemindersActivity.class);
            startActivity(intent);
        }if(v.getId()==R.id.generalInfoButton || v.getId()==R.id.imageView5 || v.getId()==R.id.text5 ){
            /*Intent intent = new Intent(this, InfoListActivity.class);*/
            Intent intent = new Intent(this, ChatBotMainActivity.class);
            startActivity(intent);
        }if(v.getId()==R.id.surveyButton || v.getId()==R.id.imageView6 || v.getId()==R.id.text6 ){
            Intent intent=new Intent(this,password_gateway.class);
            startActivity(intent);
        }
    }
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
