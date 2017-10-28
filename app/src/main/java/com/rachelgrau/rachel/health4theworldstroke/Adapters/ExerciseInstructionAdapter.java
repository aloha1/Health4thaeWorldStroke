package com.rachelgrau.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.BulletSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

/**
 * Created by garyg on 10/27/2017.
 */

public class ExerciseInstructionAdapter extends BaseAdapter {

    public class ViewHolder {
        TextView tvItem;

    }

    private Context mContext;
    private String[] mItems;

    public ExerciseInstructionAdapter(Context c, String[] items) {
        mContext = c;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.length;
    }

    @Override
    public Object getItem(int position) {
        return mItems[position];
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
            itemView = inflater.inflate(R.layout.list_item_exercise_instruction, null);
            viewHolder = new ViewHolder();
            viewHolder.tvItem = (TextView) itemView.findViewById(R.id.tv_item);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CharSequence t1 = mItems[position];
        SpannableString s1 = new SpannableString(t1);
        s1.setSpan(new BulletSpan(15), 0, t1.length(), 0);
        viewHolder.tvItem.setText(s1);
        return itemView;

    }
}
