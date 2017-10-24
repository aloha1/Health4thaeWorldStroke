package com.rachelgrau.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rachelgrau.rachel.health4theworldstroke.R;


/**
 * Created by varun on 21-10-2017.
 */

public class music_adapter extends BaseAdapter {

    private Context mContext;

    public Integer[] mThumbIds = {
            R.drawable.music_chatbot, R.drawable.music_chatbot
    };

    public music_adapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return 21;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.musicfile_view, null);
        layout.setId(position);

        return layout;

    }
}
