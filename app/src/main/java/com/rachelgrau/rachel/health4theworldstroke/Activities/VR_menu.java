package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.VR_MainActivity.Vname;

public class VR_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr_menu);
        setUpToolbar();
    }
    public void onClick(View v){

        if(v.getId()==R.id.bell_btn){
            Intent intent=new Intent(this,VR_MainActivity.class);
            intent.putExtra(Vname,"Bells");
            startActivity(intent);
        }if(v.getId()==R.id.Buddha_btn){
            Intent intent=new Intent(this,VR_MainActivity.class);
            intent.putExtra(Vname,"Buddha");
            startActivity(intent);
        }if(v.getId()==R.id.Flags_btn){
            Intent intent=new Intent(this,VR_MainActivity.class);
            intent.putExtra(Vname,"Flags");
            startActivity(intent);
        }if(v.getId()==R.id.Market_place_1_btn){
            Intent intent=new Intent(this,VR_MainActivity.class);
            intent.putExtra(Vname,"Market place 1");
            startActivity(intent);
        }if(v.getId()==R.id.Market_place_2_btn){
            Intent intent=new Intent(this,VR_MainActivity.class);
            intent.putExtra(Vname,"Market place 2");
            startActivity(intent);
        }if(v.getId()==R.id.Rocky_Beach_btn){
            Intent intent=new Intent(this,VR_MainActivity.class);
            intent.putExtra(Vname,"Rocky Beach");
            startActivity(intent);
        }/*if(v.getId()==R.id.Sandy_Beach_btn){
            Intent intent=new Intent(this,VR_MainActivity.class);
            intent.putExtra(Vname,"Sandy Beach");
            startActivity(intent);
        }*/

    }

    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.Mind_exercise);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }



}
