package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.ScreenSlidePageFragment2;
import com.rachelgrau.rachel.health4theworldstroke.Adapters.ScreenSlidePageFragment3;
import com.rachelgrau.rachel.health4theworldstroke.Adapters.ScreenSlidePageFragment4;
import com.rachelgrau.rachel.health4theworldstroke.Adapters.ScreenSlidePageFragment5;
import com.rachelgrau.rachel.health4theworldstroke.Adapters.ScreenSlidePageFragment6;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class SliderMainActivity extends FragmentActivity {

    Spinner spinner;
    String language, lang_selected;
    static String current_lang = "";
    Locale myLocale;
    /**
     * The number of pages.
     */
    private static final int NUM_PAGES = 6;
    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;
    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider_main);

        lang_selected = getIntent().getStringExtra(current_lang);
        spinner = (Spinner) findViewById(R.id.spinner);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.viewPager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                ((TextView) spinner.getChildAt(0)).setTextColor(Color.BLACK);
                ((TextView) spinner.getChildAt(0)).setTextSize(20);
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Toast.makeText(SliderMainActivity.this, "Language:English", Toast.LENGTH_SHORT).show();
                        setLocale("en");
                        language = "en";
                        break;
                    case 2:
                        Toast.makeText(SliderMainActivity.this, "Idioma:Español", Toast.LENGTH_SHORT).show();
                        setLocale("es");
                        language = "es";
                        break;
                    case 3:
                        Toast.makeText(SliderMainActivity.this, "La langue:Français", Toast.LENGTH_SHORT).show();
                        setLocale("fr");
                        language = "fr";
                        break;
                    case 4:
                        Toast.makeText(SliderMainActivity.this, "Wika:Filipino", Toast.LENGTH_SHORT).show();
                        setLocale("fil");
                        language = "fil";
                        break;
                    case 5:
                        Toast.makeText(SliderMainActivity.this, "Language:Nepali", Toast.LENGTH_SHORT).show();
                        setLocale("ne");
                        language = "ne";
                        break;
                    case 6:
                        Toast.makeText(SliderMainActivity.this, "语言:中文", Toast.LENGTH_SHORT).show();
                        setLocale("zh");
                        language = "zh";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        List<String> list = new ArrayList<String>();

        list.add("Select language     ");
        list.add("English");
        list.add("Español");
        list.add("Français");
        list.add("Filipino");
        list.add("Nepali");
        list.add("Chinese");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, SliderMainActivity.class);
        startActivity(refresh);
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        private ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ScreenSlidePageFragment();
            }
            if (position == 1) {
                return new ScreenSlidePageFragment2();
            }
            if (position == 2) {
                return new ScreenSlidePageFragment3();
            }
            if (position == 3) {
                return new ScreenSlidePageFragment4();
            }
            if (position == 4) {
                return new ScreenSlidePageFragment5();
            }
            if (position == 5) {
                return new ScreenSlidePageFragment6();
            }
            return new ScreenSlidePageFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public void goMain(View v) {

        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}