package com.rachelgrau.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.Models.LearnContent;
import com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;


/**
 * Created by rachel on 11/11/16.
 * Adapter for the LearnContent List View (in LearnActivity) which displays
 * a list of the different content the user can read or videos they can watch.
 */

public class LearnContentAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<LearnContent> mDataSource;

    public LearnContentAdapter(Context context, ArrayList<LearnContent> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDataSource(ArrayList<LearnContent> newData) {
        mDataSource = newData;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get views for this row item
        View rowView = mInflater.inflate(R.layout.list_item_learn_content, parent, false);
        TextView titleTextView =
                (TextView) rowView.findViewById(com.rachelgrau.rachel.health4theworldstroke.R.id.learn_content_title);
        ImageView arrowButton = (ImageView) rowView.findViewById(R.id.pink_arrow);
        // Populate view with relevant content
        LearnContent contentItem = (LearnContent) getItem(position);
        titleTextView.setText(contentItem.title);
        if(contentItem.title.equals(mContext.getString(R.string.faq))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.info));
        }if(contentItem.title.equals(mContext.getString(R.string.signs))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.mipmap.ambulance));
        }if(contentItem.title.equals(mContext.getString(R.string.RISK_FACTOR))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.walking));
        }if(contentItem.title.equals(mContext.getString(R.string.blood_pressure))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bloodpressurered_learn));
        }if(contentItem.title.equals(mContext.getString(R.string.heart_rate))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.heartrate_learn));
        }if(contentItem.title.equals(mContext.getString(R.string.Diet))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.diet_learn));
        }if(contentItem.title.equals(mContext.getString(R.string.blood_sugar))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bloodsugar_learn));
        }if(contentItem.title.equals(mContext.getString(R.string.exercise))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.strengthing));
        }if(contentItem.title.equals(mContext.getString(R.string.bladder))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.bladder_bowel_learn));
        }if(contentItem.title.equals(mContext.getString(R.string.home_mod))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.homemodification_learn));
        }if(contentItem.title.equals(mContext.getString(R.string.smoking_))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.nosmoking));
        }if(contentItem.title.equals(mContext.getString(R.string.shower))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.shower));
        }if(contentItem.title.equals(mContext.getString(R.string.resource))){
            arrowButton.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.resources));
        }
        return rowView;
    }

}
