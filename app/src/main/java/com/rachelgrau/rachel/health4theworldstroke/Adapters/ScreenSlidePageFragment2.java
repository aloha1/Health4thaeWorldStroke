package com.rachelgrau.rachel.health4theworldstroke.Adapters;

/**
 * Created by Varun Raj on 02-08-2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.rachelgrau.rachel.health4theworldstroke.R;

public class ScreenSlidePageFragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page2, container, false);

        return rootView;
    }

}