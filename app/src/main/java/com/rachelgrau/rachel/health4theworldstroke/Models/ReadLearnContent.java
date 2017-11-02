package com.rachelgrau.rachel.health4theworldstroke.Models;

import android.content.Context;

import java.util.ArrayList;
import com.rachelgrau.rachel.health4theworldstroke.R;
/**
 * Created by rachel on 11/7/16.
 */

public class ReadLearnContent extends LearnContent{
    public String text;

    /* READ TOPICS */

   /* public static String BEFAST_SIGNS_OF_STROKE = "BEFAST Signs Of Stroke";
    public static final String SMOKING="Smoking";
    public static final String RISK_FACTORS = "Risk Factors";
    public static final String BLOOD_PRESSURE = "Blood Pressure";
    public static final String HEART_RATE = "Heart Rate";
    public static final String BLOOD_SUGAR = "Blood Sugar";
    public static final String EXERCISES = "Exercises";
    public static final String DIET = "Diet";
    public static final String SHOWER_BATH = "Shower/bath";
    public static final String BLADDER_BOWEL = "Bladder/bowel";
    public static final String HOME_MODIFICATION = "Home Modification";
    public static final String FAQ = "FAQ";
    public static final String RESOURCES = "Resources"; */

    public static ArrayList<LearnContent> getReadContent(Context context) {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();


        ReadLearnContent riskFactors = new ReadLearnContent(context.getString(R.string.RISK_FACTOR));
        ReadLearnContent signOfStroke=new ReadLearnContent(context.getString(R.string.signs));
        ReadLearnContent bloodPressure = new ReadLearnContent(context.getString(R.string.blood_pressure));
        ReadLearnContent smoking= new ReadLearnContent(context.getString(R.string.smoking_));
        ReadLearnContent heartRate = new ReadLearnContent(context.getString(R.string.heart_rate));
        ReadLearnContent bloodSugar = new ReadLearnContent(context.getString(R.string.blood_sugar));
        ReadLearnContent exercises = new ReadLearnContent(context.getString(R.string.exercise));
        ReadLearnContent diet = new ReadLearnContent(context.getString(R.string.Diet));
        ReadLearnContent showerBath = new ReadLearnContent(context.getString(R.string.shower));
        ReadLearnContent bladderBowel = new ReadLearnContent(context.getString(R.string.bladder));
        ReadLearnContent homeMod = new ReadLearnContent(context.getString(R.string.home_mod));
        ReadLearnContent faq = new ReadLearnContent(context.getString(R.string.faq));
        ReadLearnContent resources = new ReadLearnContent(context.getString(R.string.resource));
        
        /*content.add(riskFactors);*/
        content.add(faq);
        content.add(signOfStroke);
        content.add(riskFactors);
        content.add(bloodPressure);
        content.add(heartRate);
        content.add(bloodSugar);
        content.add(diet);
        content.add(smoking);
        content.add(exercises);
        content.add(showerBath);
        content.add(bladderBowel);
        content.add(homeMod);
        content.add(resources);

        return content;
    }

    public ReadLearnContent(String title) {
        this.title = title;
    }

}
