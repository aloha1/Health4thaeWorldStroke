package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import static com.rachelgrau.rachel.health4theworldstroke.Activities.LearnActivity.EXTRA_PAGE_TYPE;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.LearnActivity.PAGE_TYPE_READ;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.exercise.data;

import android.widget.AdapterView.OnItemSelectedListener;


public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    String language,lang_selected;
    static String current_lang="";
    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transition_view);
        lang_selected=getIntent().getStringExtra(current_lang);
//        fakeFirstAppOpening();
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long id) {
                ((TextView) spinner.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView) spinner.getChildAt(0)).setTextSize(20);
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this,"Language:English", Toast.LENGTH_SHORT).show();
                      //  changeLang("eng");
                        setLocale("en");
                        language="en";
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this,"Idioma:Español", Toast.LENGTH_SHORT).show();
                      //  changeLang("span");
                        setLocale("es");
                        language="es";
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this,"La langue:Français", Toast.LENGTH_SHORT).show();
                        //  changeLang("span");
                        setLocale("fr");
                        language="fr";
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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    /* If it's the first time they're using the app, show them the terms page and wait for them to accept. */
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.apply();
            showDisclaimer();
        }
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, MainActivity.class);
        refresh.putExtra(current_lang,language);
        startActivity(refresh);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        // TODO Auto-generated method stub
        Toast.makeText(this, "YOUR SELECTION IS : " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
    }
    private void fakeFirstAppOpening() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(getString(R.string.pref_previously_started), Boolean.FALSE);
        edit.apply();
    }
    public void showDisclaimer() {
        Intent intent = new Intent(this, DisclaimerActivity.class);
        startActivity(intent);
    }

    public void generalInfoSelected(View view) {
        Intent intent = new Intent(this, InfoListActivity.class);
        startActivity(intent);
    }

    public void helpMeSpeakSelected(View view) {
        Intent intent = new Intent(this, HelpMeSpeakActivity.class);
        startActivity(intent);
    }

    public void videoSelected(View view) {
            Intent intent = new Intent(this, exercise.class);
            intent.putExtra(data,"o");
            startActivity(intent);
    }
    public void readSelected(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        intent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_READ);
        startActivity(intent);
    }
    public void survaySelected(View view) {
        Intent intent = new Intent(this,password_gateway.class);
        startActivity(intent);
    }
    public void remindersSelected(View view) {
        Intent intent = new Intent(this, RemindersActivity.class);
        startActivity(intent);
    }
    public void infoClicked(View view) {
        Intent intent = new Intent(this, InfoListActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
