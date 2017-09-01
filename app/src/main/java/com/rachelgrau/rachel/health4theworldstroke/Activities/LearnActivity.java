package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.LearnContentAdapter;
import com.rachelgrau.rachel.health4theworldstroke.Models.LearnContent;
import com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.rachelgrau.rachel.health4theworldstroke.Models.VideoLearnContent;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;

import static com.rachelgrau.rachel.health4theworldstroke.R.color.red;


public class LearnActivity extends AppCompatActivity {
    public static final String EXTRA_PAGE_TYPE = "pageType";
    public static final String EXTRA_VIDEO_CATEGORY = "videoCategory";
    public static final String EXTRA_TITLE = "title";

    public static final String PAGE_TYPE_READ = "Read";
    public static final String PAGE_TYPE_VIDEO = "Video";
    public static final String PAGE_TYPE_VIDEO_SUBCATEGORY = "VideoSubcategory";

    /* Page type can be:
     * Read
     * Video (Strengthening, stretching, functional mobility, exercises)
     * Video sub-category */
    private String pageType;
    private String videoCategory = ""; // if displaying videosubcategories, this string holds the main category

    private ListView listView; // list of read or video content, depending which tab is selected
    private LearnContentAdapter adapter;
    private ArrayList<LearnContent> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageType = this.getIntent().getStringExtra(EXTRA_PAGE_TYPE);
        if (pageType.equals(PAGE_TYPE_READ)) {
            content = ReadLearnContent.getReadContent(this);
        } else if (pageType.equals(PAGE_TYPE_VIDEO)) {
            content = VideoLearnContent.getVideoCategories();
        } else if (pageType.equals(PAGE_TYPE_VIDEO_SUBCATEGORY)) {
            videoCategory = this.getIntent().getStringExtra(EXTRA_VIDEO_CATEGORY);
            content = VideoLearnContent.getVideoSubcategories(videoCategory);
        }
        setContentView(R.layout.activity_learn);
        setUpToolbar();
        setUpListView();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);

        if (pageType.equals(PAGE_TYPE_READ)) {
            toolbarTitle.setText(R.string.learn);
        } else if (pageType.equals(PAGE_TYPE_VIDEO)) {
            toolbarTitle.setText(R.string.video);
        } else if (pageType.equals(PAGE_TYPE_VIDEO_SUBCATEGORY)) {
            toolbarTitle.setText(videoCategory);
        }
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpListView() {
        /* Populate list view with read content to start */
        listView = (ListView)findViewById(R.id.learn_content_list_view);
        adapter = new LearnContentAdapter(this, content);
        listView.setAdapter(adapter);

        /* Set up callback for when an item in the list is selected. */
        final Context context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                /* Transition to content activity */
                if (pageType.equals(PAGE_TYPE_READ)) {
                    // To read activity
                    ReadLearnContent selectedContent = (ReadLearnContent)content.get(position);
                    String selectedContentTitle = selectedContent.title;
                    if (selectedContentTitle.equals(getString(R.string.resource))) {
                        Intent readIntent = new Intent(context, ReadContentActivity.class);
                        readIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(readIntent);
                    } else {
                        Intent readIntent = new Intent(context, NewReadLearnContentActivity.class);
                        readIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(readIntent);
                    }
                } else if (pageType.equals(PAGE_TYPE_VIDEO)) {
                    VideoLearnContent selectedContent = (VideoLearnContent)content.get(position);
                    if (VideoLearnContent.categoryHasSubcategories(selectedContent.title)) {
                        // If it's one of these, we need to start another LearnActivity, this time with video subcategories
                        Intent videoSubcategoryIntent = new Intent(context, LearnActivity.class);
                        videoSubcategoryIntent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_VIDEO_SUBCATEGORY);
                        videoSubcategoryIntent.putExtra(EXTRA_VIDEO_CATEGORY, selectedContent.title);
                        startActivity(videoSubcategoryIntent);
                    } else {
                        // If it's one of these, show the video content! No subcategories.
                        Intent videoIntent = new Intent(context, VideoContentActivity.class);
                        videoIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(videoIntent);
                    }
                } else if (pageType.equals(PAGE_TYPE_VIDEO_SUBCATEGORY)) {
                    VideoLearnContent selectedContent = (VideoLearnContent)content.get(position);
                    if (VideoLearnContent.categoryHasSubcategories(selectedContent.title)) {
                        // If it's one of these, we need to start another LearnActivity, this time with video subcategories
                        Intent videoSubcategoryIntent = new Intent(context, LearnActivity.class);
                        videoSubcategoryIntent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_VIDEO_SUBCATEGORY);
                        videoSubcategoryIntent.putExtra(EXTRA_VIDEO_CATEGORY, selectedContent.title);
                        startActivity(videoSubcategoryIntent);
                    } else {
                        // If it's one of these, show the video content! No subcategories.
                        Intent videoIntent = new Intent(context, VideoContentActivity.class);
                        videoIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(videoIntent);
                    }
                }
            }
        });
    }
    public void onClick(View v){

        TextView tv=(TextView) findViewById(R.id.inputBox);
        TextView tvB=(TextView) findViewById(R.id.B);
        TextView tvE=(TextView) findViewById(R.id.E);
        TextView tvF=(TextView) findViewById(R.id.F);
        TextView tvA=(TextView) findViewById(R.id.A);
        TextView tvS=(TextView) findViewById(R.id.S);
        TextView tvT=(TextView) findViewById(R.id.T);

          if(v.getId()==R.id.B){
              tv.setText(getString(R.string.befast_line2));
              tvB.setBackgroundResource(R.drawable.round_learn);
              tvB.setTextColor(getResources().getColor(R.color.darkGray));
              allNormal("B");

        } if(v.getId()==R.id.E){
            tv.setText(getString(R.string.befast_line4));
            tvE.setBackgroundResource(R.drawable.round_learn);
            tvE.setTextColor(getResources().getColor(R.color.darkGray));
            allNormal("E");

        } if(v.getId()==R.id.F){
            tv.setText(getString(R.string.befast_line6));
            tvF.setBackgroundResource(R.drawable.round_learn);
            tvF.setTextColor(getResources().getColor(R.color.darkGray));
            allNormal("F");

        } if(v.getId()==R.id.A){
            tv.setText(getString(R.string.befast_line8));
            tvA.setBackgroundResource(R.drawable.round_learn);
            tvA.setTextColor(getResources().getColor(R.color.darkGray));
            allNormal("A");

        } if(v.getId()==R.id.S){
            tv.setText(getString(R.string.befast_line10));
            tvS.setBackgroundResource(R.drawable.round_learn);
            tvS.setTextColor(getResources().getColor(R.color.darkGray));
            allNormal("S");

        } if(v.getId()==R.id.T){
            tv.setText(getString(R.string.befast_line12));
            tvT.setBackgroundResource(R.drawable.round_learn);
            tvT.setTextColor(getResources().getColor(R.color.darkGray));
            allNormal("T");

        }
    }
    public void allNormal(String n){
        TextView B=(TextView) findViewById(R.id.B);
        TextView E=(TextView) findViewById(R.id.E);
        TextView F=(TextView) findViewById(R.id.F);
        TextView A=(TextView) findViewById(R.id.A);
        TextView S=(TextView) findViewById(R.id.S);
        TextView T=(TextView) findViewById(R.id.T);

        if(n.equals("B")){
            E.setBackgroundResource(R.drawable.round_learn_ring);
            E.setTextColor((getResources().getColor(red)));
            F.setBackgroundResource(R.drawable.round_learn_ring);
            F.setTextColor((getResources().getColor(red)));
            A.setBackgroundResource(R.drawable.round_learn_ring);
            A.setTextColor((getResources().getColor(red)));
            S.setBackgroundResource(R.drawable.round_learn_ring);
            S.setTextColor((getResources().getColor(red)));
            T.setBackgroundResource(R.drawable.round_learn_ring);
            T.setTextColor((getResources().getColor(red)));
        }if(n.equals("E")){
            B.setBackgroundResource(R.drawable.round_learn_ring);
            B.setTextColor((getResources().getColor(red)));
            F.setBackgroundResource(R.drawable.round_learn_ring);
            F.setTextColor((getResources().getColor(red)));
            A.setBackgroundResource(R.drawable.round_learn_ring);
            A.setTextColor((getResources().getColor(red)));
            S.setBackgroundResource(R.drawable.round_learn_ring);
            S.setTextColor((getResources().getColor(red)));
            T.setBackgroundResource(R.drawable.round_learn_ring);
            T.setTextColor((getResources().getColor(red)));
        }if(n.equals("F")){
            B.setBackgroundResource(R.drawable.round_learn_ring);
            B.setTextColor((getResources().getColor(red)));
            E.setBackgroundResource(R.drawable.round_learn_ring);
            E.setTextColor((getResources().getColor(red)));
            A.setBackgroundResource(R.drawable.round_learn_ring);
            A.setTextColor((getResources().getColor(red)));
            S.setBackgroundResource(R.drawable.round_learn_ring);
            S.setTextColor((getResources().getColor(red)));
            T.setBackgroundResource(R.drawable.round_learn_ring);
            T.setTextColor((getResources().getColor(red)));
        }if(n.equals("A")){
            E.setBackgroundResource(R.drawable.round_learn_ring);
            E.setTextColor((getResources().getColor(red)));
            F.setBackgroundResource(R.drawable.round_learn_ring);
            F.setTextColor((getResources().getColor(red)));
            B.setBackgroundResource(R.drawable.round_learn_ring);
            B.setTextColor((getResources().getColor(red)));
            S.setBackgroundResource(R.drawable.round_learn_ring);
            S.setTextColor((getResources().getColor(red)));
            T.setBackgroundResource(R.drawable.round_learn_ring);
            T.setTextColor((getResources().getColor(red)));
        }if(n.equals("S")){
            E.setBackgroundResource(R.drawable.round_learn_ring);
            E.setTextColor((getResources().getColor(red)));
            F.setBackgroundResource(R.drawable.round_learn_ring);
            F.setTextColor((getResources().getColor(red)));
            A.setBackgroundResource(R.drawable.round_learn_ring);
            A.setTextColor((getResources().getColor(red)));
            B.setBackgroundResource(R.drawable.round_learn_ring);
            B.setTextColor((getResources().getColor(red)));
            T.setBackgroundResource(R.drawable.round_learn_ring);
            T.setTextColor((getResources().getColor(red)));
        }if(n.equals("T")){
            E.setBackgroundResource(R.drawable.round_learn_ring);
            E.setTextColor((getResources().getColor(red)));
            F.setBackgroundResource(R.drawable.round_learn_ring);
            F.setTextColor((getResources().getColor(red)));
            A.setBackgroundResource(R.drawable.round_learn_ring);
            A.setTextColor((getResources().getColor(red)));
            S.setBackgroundResource(R.drawable.round_learn_ring);
            S.setTextColor((getResources().getColor(red)));
            B.setBackgroundResource(R.drawable.round_learn_ring);
            B.setTextColor((getResources().getColor(red)));
        }

    }
}
