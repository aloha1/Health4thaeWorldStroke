package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;


public class NewReadLearnContentActivity extends AppCompatActivity {

    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_learn_content);
        this.title = this.getIntent().getExtras().getString("title");
        setUpToolbar();
        setUpContent();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.read_content_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(this.title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpContent() {
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_red_learn_content);
         if (this.title.equals(getString(R.string.blood_sugar))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpBloodSugar();
        } else if (this.title.equals(getString(R.string.smoking_))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpSmoking();
        } else if (this.title.equals(getString(R.string.blood_pressure))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpBloodPressure();
        } else if (this.title.equals(getString(R.string.heart_rate))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpHeartRate();
        } else if (this.title.equals(getString(R.string.shower))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpShowerBath();
        } else if (this.title.equals(getString(R.string.exercise))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpExercises();
        } else if (this.title.equals(getString(R.string.Diet))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpDiet();
        } else if (this.title.equals(getString(R.string.bladder))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpBladderBowel();
        } else if (this.title.equals(getString(R.string.home_mod))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpHomeMod();
        } else if (this.title.equals(getString(R.string.faq))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpFAQ();
        } else if (this.title.equals(getString(R.string.RISK_FACTOR))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpRiskFactors();
        } else if (this.title.equals(getString(R.string.resource))) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpRiskFactors();
        }
    }

    public void setUpBEFASTsignsofstroke()
    {
        String secondPart="";
       // addHeaderWithText(getString(R.string.befast_line1));
        addLineBreak();
        String firstPart = getString(R.string.befast_line2);
       // String secondPart = getString(R.string.befast_line3);
        Spannable firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);
        addImageWithURI(R.drawable.sudden_loss_balance);

        firstPart = getString(R.string.befast_line4);
       // secondPart = getString(R.string.befast_line5);
        firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);
        addImageWithURI(R.drawable.sudden_loss_vision);

        firstPart = getString(R.string.befast_line6);
       // secondPart = getString(R.string.befast_line7);
        firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);
        addImageWithURI(R.drawable.facial_droop);

        firstPart = getString(R.string.befast_line8);
       // secondPart =getString(R.string.befast_line9);
        firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);
        addImageWithURI(R.drawable.arm_weakness);

        firstPart = getString(R.string.befast_line10);
       // secondPart = getString(R.string.befast_line11);
        firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);
        addImageWithURI(R.drawable.speech_difficulty);

        firstPart = getString(R.string.befast_line12);
       // secondPart = getString(R.string.befast_line13);
        firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);
        addImageWithURI(R.drawable.ambulance_new);
    }

    public void setUpBloodSugar() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstPart = getString(R.string.blood_sugar_line1);
        String secondPart = getString(R.string.blood_sugar_line2);
        Spannable firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();
        /* SECOND PARAGRAPH */
        firstPart = getString(R.string.blood_sugar_line3);
        secondPart = getString(R.string.blood_sugar_line4);
        String thirdPart = getString(R.string.blood_sugar_line5);
        String fourthPart = getString(R.string.blood_sugar_line6);
        String fifthPart = getString(R.string.blood_sugar_line7);
        Spannable secondParSpannable = new SpannableString(firstPart + secondPart + thirdPart + fourthPart + fifthPart);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length(), firstPart.length() + secondPart.length() + thirdPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length() + secondPart.length() + thirdPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length() + fifthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(secondParSpannable);

        addImageWithURI(R.drawable.blood_sugar);
    }

    public void setUpBloodPressure() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstPart = getString(R.string.blood_pressure_line1);
        String secondPart = getString(R.string.blood_pressure_line2);
        Spannable firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();
        /* SECOND PARAGRAPH */
        firstPart = getString(R.string.blood_pressure_line3);
        secondPart = getString(R.string.blood_pressure_line4);
        String thirdPart = getString(R.string.blood_pressure_line5);
        Spannable secondParSpannable = new SpannableString(firstPart + secondPart + thirdPart);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length(), firstPart.length() + secondPart.length() + thirdPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(secondParSpannable);

        addImageWithURI(R.drawable.blood_pressure);
    }

    public void setUpSmoking() {
        addHeaderWithText(getString(R.string.why_quit_smoking));
        addLineBreak();
        String firstPart = "";
        String secondPart = getString(R.string.smoking_line1);
        Spannable firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText(getString(R.string.what_should_u_do));
        addLineBreak();
        firstPart="";
        secondPart = getString(R.string.smoking_line2);
        firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);
        addImageWithURI(R.drawable.cigerate);
    }

    public void setUpHeartRate() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = getString(R.string.heart_rate_para1);
        String secondWord = getString(R.string.heart_rate_para2);
        Spannable firstParSpannable = new SpannableString(firstWord+secondWord);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstWord.length(), firstWord.length() + secondWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();
        /* SECOND PARAGRAPH */
        String firstPart = getString(R.string.heart_rate_para3);
        String secondPart = getString(R.string.heart_rate_para4); // bold
        String thirdPart = getString(R.string.heart_rate_para5);
        String fourthPart = getString(R.string.heart_rate_para6); // bold
        String fifthPart = getString(R.string.heart_rate_para7);
        Spannable secondParSpannable = new SpannableString(firstPart + secondPart + thirdPart + fourthPart + fifthPart);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length(), firstPart.length() + secondPart.length() + thirdPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length() + secondPart.length() + thirdPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length() + fifthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(secondParSpannable);

        addImageWithURI(R.drawable.hearthate);
    }

    public void setUpShowerBath() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = getString(R.string.bath_para1);
        Spannable firstParSpannable = new SpannableString(firstWord);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();
        /* First bullet point */
        String bulletOneFirst = getString(R.string.bath_para2);
        String bulletOneSecond = getString(R.string.bath_para3);
        Spannable bulletOneSpannable = new SpannableString(bulletOneFirst+bulletOneSecond);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bulletOneFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletOneFirst.length(), bulletOneFirst.length() + bulletOneSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        addTextViewWithText(bulletOneSpannable);

        /* Second bullet point */
        String bulletTwoFirst = getString(R.string.bath_para4);
        String bulletTwoSecond = getString(R.string.bath_para5);
        Spannable bulletTwoSpannable = new SpannableString(bulletTwoFirst+bulletTwoSecond);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bulletTwoFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletTwoFirst.length(), bulletTwoFirst.length() + bulletTwoSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletTwoSpannable);

        /* Third bullet point */
        String bulletThreeFirst = getString(R.string.bath_para6);
        Spannable bulletThreeSpannable = new SpannableString(bulletThreeFirst);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletThreeFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletThreeSpannable);

        /* Fourth bullet point */
        String bulletFourFirst = getString(R.string.bath_para7);
        Spannable bulletFourSpannable = new SpannableString(bulletFourFirst);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletFourFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletFourSpannable);

        addImageWithURI(R.drawable.grab_bars_new);
    }

    public void setUpExercises() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = getString(R.string.exercise_para1);
        Spannable firstParSpannable = new SpannableString(firstWord);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();
        /* First bullet point */
        String bulletOneFirst = getString(R.string.exercise_para2);
        String bulletOneSecond = getString(R.string.exercise_para3);
        String bulletOneThird= getString(R.string.exercise_para4);
        Spannable bulletOneSpannable = new SpannableString(bulletOneFirst+bulletOneSecond+bulletOneThird);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletOneFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletOneFirst.length(), bulletOneFirst.length() + bulletOneSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletOneFirst.length() + bulletOneSecond.length(), bulletOneFirst.length() + bulletOneSecond.length() + bulletOneThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletOneSpannable);

        /* Second bullet point */
        String bulletTwoFirst = getString(R.string.exercise_para5);
        String bulletTwoSecond = getString(R.string.exercise_para6);
        String bulletTwoThird= getString(R.string.exercise_para7);
        Spannable bulletTwoSpannable = new SpannableString(bulletTwoFirst+bulletTwoSecond+bulletTwoThird);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletTwoFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletTwoFirst.length(), bulletTwoFirst.length() + bulletTwoSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletTwoFirst.length() + bulletTwoSecond.length(), bulletTwoFirst.length() + bulletTwoSecond.length() + bulletTwoThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletTwoSpannable);

        /* Third bullet point */
        String bulletThreeFirst = getString(R.string.exercise_para8);
        String bulletThreeSecond = getString(R.string.exercise_para9);
        String bulletThreeThird= getString(R.string.exercise_para10);
        Spannable bulletThreeSpannable = new SpannableString(bulletThreeFirst+bulletThreeSecond+bulletThreeThird);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletThreeFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletThreeFirst.length(), bulletThreeFirst.length() + bulletThreeSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletThreeFirst.length() + bulletThreeSecond.length(), bulletThreeFirst.length() + bulletThreeSecond.length() + bulletThreeThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletThreeSpannable);

        /* Fourth bullet point */
        String bulletFourFirst = getString(R.string.exercise_para11);
        String bulletFourSecond = getString(R.string.exercise_para12);
        String bulletFourThird= getString(R.string.exercise_para13);
        Spannable bulletFourSpannable = new SpannableString(bulletFourFirst+bulletFourSecond+bulletFourThird);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletFourFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletFourFirst.length(), bulletFourFirst.length() + bulletFourSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletFourFirst.length() + bulletFourSecond.length(), bulletFourFirst.length() + bulletFourSecond.length() + bulletFourThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletFourSpannable);

        /* Fifth bullet point */
        String bulletFiveFirst = getString(R.string.exercise_para14);
        String bulletFiveSecond = getString(R.string.exercise_para15);
        String bulletFiveThird= getString(R.string.exercise_para16);
        Spannable bulletFiveSpannable = new SpannableString(bulletFiveFirst+bulletFiveSecond+bulletFiveThird);
        bulletFiveSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletFiveFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFiveSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletFiveFirst.length(), bulletFiveFirst.length() + bulletFiveSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFiveSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletFiveFirst.length() + bulletFiveSecond.length(), bulletFiveFirst.length() + bulletFiveSecond.length() + bulletFiveThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletFiveSpannable);

        /* Sixth bullet point */
        String bulletSixFirst = getString(R.string.exercise_para17);
        String bulletSixSecond = getString(R.string.exercise_para18);
        String bulletSixThird= getString(R.string.exercise_para19);
        Spannable bulletSixSpannable = new SpannableString(bulletSixFirst+bulletSixSecond+bulletSixThird);
        bulletSixSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletSixFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletSixSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletSixFirst.length(), bulletSixFirst.length() + bulletSixSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletSixSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletSixFirst.length() + bulletSixSecond.length(), bulletSixFirst.length() + bulletSixSecond.length() + bulletSixThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletSixSpannable);

        addImageWithURI(R.drawable.yoga);
        addImageWithURI(R.drawable.walking);
        addImageWithURI(R.drawable.rightposture);
        addImageWithURI(R.drawable.wrongposture);
    }

    public void setUpDiet() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = getString(R.string.diet_para1);
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();

        firstWord = getString(R.string.diet_para2);
        spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addImageWithURI(R.drawable.goodfood);
        addImageWithURI(R.drawable.badfood);
        addHeaderWithText(getString(R.string.diet_para3));
        addLineBreak();

        firstWord = getString(R.string.diet_para4);
        spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        addImageWithURI(R.drawable.brush_teeth);
    }

    public void setUpBladderBowel() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = getString(R.string.bladder_bowel_para_1);
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();
        String secondPar = getString(R.string.bladder_bowel_para_2);
        spannable = new SpannableString(secondPar);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        addImageWithURI(R.drawable.pouring_water);
        firstWord = getString(R.string.bladder_bowel_para_3);
        spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
    }

    public void setUpHomeMod() {
        addHeaderWithText(getString(R.string.problem));
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = getString(R.string.home_mod_line0);
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText(getString(R.string.what_to_do));
        addLineBreak();
        String bedroom = getString(R.string.home_mod_line1);
        spannable = new SpannableString(bedroom);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bedroom.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String bedroomExplanation = getString(R.string.home_mod_line2);
        spannable = new SpannableString(bedroomExplanation);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bedroomExplanation.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addImageWithURI(R.drawable.weak_side_bed);

        String general = getString(R.string.home_mod_line8);
        spannable = new SpannableString(general);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, general.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String generalExplanation = getString(R.string.home_mod_line9);
        spannable = new SpannableString(generalExplanation);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, generalExplanation.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addImageWithURI(R.drawable.slippery_carpet);

        String bath = getString(R.string.home_mod_line3);
        spannable = new SpannableString(bath);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bath.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String bathExplanationOne = getString(R.string.home_mod_line4);
        spannable = new SpannableString(bathExplanationOne);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bathExplanationOne.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String bathExplanationTwo =  getString(R.string.home_mod_line5);
        spannable = new SpannableString(bathExplanationTwo);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bathExplanationTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addImageWithURI(R.drawable.grab_bars_new);
    }

    public void setUpFAQ() {
        addHeaderWithText(getString(R.string.faq_line1));
        addLineBreak();
        String firstWord = getString(R.string.faq_line2);
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText(getString(R.string.faq_line11));
        addLineBreak();
        String word = getString(R.string.faq_line12);
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText(getString(R.string.faq_line13));
        addLineBreak();
        word = getString(R.string.faq_line14);
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
    }

    public void setUpRiskFactors() {
        addHeaderWithText(getString(R.string.riskFactor1_));
        addLineBreak();
        String word = getString(R.string.highbloodpressure);
        Spannable spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = getString(R.string.heart_disease);
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = getString(R.string.smoking);
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = getString(R.string.Diabetes);
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = getString(R.string.Prior_stroke);
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
    }

    public void addHeaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(75, 40, 75, 10);
        textView.setTextSize(20);
        textView.setTextColor(Color.WHITE);
        ll.addView(textView);
    }

    /* Text should be in HTML */
    public void addTextViewWithText(Spannable text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        secondPar.setTypeface(font);
        secondPar.setText(text);
        secondPar.setPadding(75, 10, 75, 0);
        secondPar.setTextSize(18);
        secondPar.setTextColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addLineBreak() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        View line = new View(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3);
        params.setMargins(75, 0, 75, 0);
        line.setLayoutParams(params);
        line.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
        ll.addView(line);
    }

    /* Adds the given images to the layout. */
    public void addImageWithURI(int imgOne) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        ImageView imageViewOne = new ImageView(this);
        //setting image resource
        imageViewOne.setImageResource(imgOne);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        //setting image position
        imageViewOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                800));
        ll.addView(imageViewOne);
    }

}
