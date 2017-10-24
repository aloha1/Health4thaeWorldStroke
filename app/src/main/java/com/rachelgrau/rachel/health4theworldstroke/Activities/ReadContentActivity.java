package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

public class ReadContentActivity extends AppCompatActivity {
    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_content);
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
        if(title.equals(getString(R.string.resource))) {
            setUpResources();
    }}



    public void setUpResources() {
        addTextViewWithText(R.string.resource_line1);
        addTextViewWithText(R.string.resource_line2);
        addTextViewWithText(R.string.resource_line3);
        addTextViewWithText(R.string.resource_line4);
        addTextViewWithText(R.string.resource_line5);
        addTextViewWithText(R.string.resource_line6);
        addTextViewWithText(R.string.resource_line7);
        addTextViewWithText(R.string.resource_line8);
        addTextViewWithText(R.string.resource_line9);
        addTextViewWithText(R.string.resource_line10);
    }

    public void addHeaderWithText(int text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(40, 40, 40, 10);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addSubheaderWithText(int text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setPadding(40, 10, 40, 0);
        textView.setTextSize(16);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addTextViewWithText(int text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(40, 10, 40, 0);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addIndentedTextViewWithText(int text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(65, 10, 40, 0);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addLineBreak() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        View line = new View(this);
        line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3));
        line.setBackgroundColor(ContextCompat.getColor(this, R.color.darkGray));
        ll.addView(line);
    }
}