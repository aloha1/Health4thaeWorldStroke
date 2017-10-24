package com.rachelgrau.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;


/**
 * Created by varun on 21-10-2017.
 */

public class MusicAdapter extends BaseAdapter {

    public class ViewHolder {
        TextView tvMusicName;
        ImageView ivTime;

    }
    private Context mContext;
    private String[] mMusic;
    private int[] mtime;
    public MusicAdapter(Context c, String[] music, int[] time) {
        mContext = c;
        mMusic = music;
        mtime = time;
    }

    @Override
    public int getCount() {
        return mMusic.length ;
    }

    @Override
    public Object getItem(int position) {
        return mMusic[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = convertView;
        ViewHolder viewHolder;
        if (itemView == null) {
            itemView = inflater.inflate(R.layout.list_item_music, null);
            viewHolder = new ViewHolder();
            viewHolder.ivTime = (ImageView) itemView.findViewById(R.id.iv_time);
            viewHolder.tvMusicName = (TextView) itemView.findViewById(R.id.tv_music_name);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvMusicName.setText(mMusic[position]);
        viewHolder.ivTime.setImageDrawable(ContextCompat.getDrawable(mContext, mtime[position]));
        return itemView;

    }
}
