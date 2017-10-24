package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.surveyView.videoname;

public class survey extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        setUpToolbar();
    }
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.survey);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }
    public void onClick(View view) {
        Intent intent=new Intent(this,surveyView.class);
        if(view.getId()==R.id.button1)
        {intent.putExtra(videoname,"a");}
        else if(view.getId()==R.id.button2)
        {intent.putExtra(videoname,"b");}
        else if (view.getId()==R.id.button3)
        {intent.putExtra(videoname,"c");}
        else if (view.getId()==R.id.button4)
        {intent.putExtra(videoname,"d");}
        startActivity(intent);
    }
}
