package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

public class illustrations extends AppCompatActivity {

    static String illName="";
    static String language="";
    int nameIll;
    String lang="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illustrations);
        nameIll=this.getIntent().getIntExtra(illName, 0);
        lang=getIntent().getStringExtra(language);
        setUpToolbar();
        if(nameIll==(R.string.Adductores)) {
            addVideoFooterWithTitle(R.string.Adductors_text);
            addImagesWithURI(R.drawable.adductors1, R.drawable.adductors2);
        }
        if(nameIll==(R.string.Hamstrings)) {
            addVideoFooterWithTitle(R.string.Hamstrings_text);
            addImagesWithURI(R.drawable.hamstrings1, R.drawable.hamstrings2);
        }
        if(nameIll==(R.string.Dorsiflexors)) {
            addVideoFooterWithTitle(R.string.Dorsiflexors_text);
            addImagesWithURI(R.drawable.dorsiflexors1, R.drawable.dorsiflexors2);
        }
        if(nameIll==(R.string.Hand_Stretch)) {
            addVideoFooterWithTitle(R.string.Hand_Stretch_text);
            addImagesWithURI(R.drawable.hand1, R.drawable.hand2);
        }
        if(nameIll==(R.string.Shoulder_Stretches)) {
            addVideoFooterWithTitle(R.string.Shoulder_Stretches_text);
            addImagesWithURI(R.drawable.shoulder1, R.drawable.shoulder2);
        }
        if(nameIll==(R.string.Arm_Stretch)) {
            addVideoFooterWithTitle(R.string.Arm_Stretch_text);
            addImagesWithURI(R.drawable.arm1, R.drawable.arm2);
        }
    }
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(nameIll);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }
    public void addImagesWithURI(int imgOne, int imgTwo) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.illustrations);

        ImageView imageViewOne = new ImageView(this);
        //setting image resource
        imageViewOne.setImageResource(imgOne);
        //setting image position
        imageViewOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                800));
        ImageView imageViewTwo = new ImageView(this);
        //setting image resource
        imageViewTwo.setImageResource(imgTwo);
        //setting image position
        imageViewTwo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                800));

        layout.addView(imageViewOne);
        layout.addView(imageViewTwo);
    }
    public void addVideoFooterWithTitle(int title) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.illustrations);
        TextView header = new TextView(this);
        header.setTextSize(20);
        header.setText(title);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(35, 35, 35, 35);
        header.setLayoutParams(layoutParams);
        layout.addView(header);
    }
}
