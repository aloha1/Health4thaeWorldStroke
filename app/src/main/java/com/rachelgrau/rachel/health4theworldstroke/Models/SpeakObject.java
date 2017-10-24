package com.rachelgrau.rachel.health4theworldstroke.Models;

import android.content.Context;

import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;

/**
 * Created by rachel on 11/20/16.
 */

public class SpeakObject {
    public String text;
    public int imgResource;

    public SpeakObject(String text, int imgResource) {
        this.text = text;
        this.imgResource = imgResource;
    }

    public int getImageResource() {
        return imgResource;
    }

    public String getText() {
        return text;
    }

    /* Returns an ArrayList of all speak objects */
    public static ArrayList<SpeakObject> getSpeakObjects(Context context) {
        ArrayList<SpeakObject> speakObjects = new ArrayList<SpeakObject>();

        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.yes),R.mipmap.yes_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.no), R.mipmap.no_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.thanks), R.mipmap.thanks_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.bathroom), R.mipmap.bathroom_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.water), R.mipmap.water_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.hungry), R.mipmap.food_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.notgivingup), R.mipmap.not_giving_up_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.pain), R.mipmap.pain_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.cantspeak), R.mipmap.cant_speak_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.ambulance),R.mipmap.ambulance));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.bed), R.mipmap.bed));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.bed1), R.mipmap.bed));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.clock), R.mipmap.clock));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.cold), R.mipmap.cold));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.dizzy), R.mipmap.dizzy));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.hi), R.mipmap.hi));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.hot), R.mipmap.hot));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.howareyou), R.mipmap.howareyou));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.lightsOff), R.mipmap.lightsoff));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.lightson), R.mipmap.lightson));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.now), R.mipmap.now));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.outside), R.mipmap.outside));

        return speakObjects;
    }
}
