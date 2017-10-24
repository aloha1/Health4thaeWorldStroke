package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

public class surveyView extends AppCompatActivity {

    WebView webView;
    Toolbar myToolbar;
    ProgressBar progressBar;
    public  static String videoname="";
    public String videoText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_view);
        this.videoText=this.getIntent().getStringExtra(videoname);
        setUpToolbar();
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        if(videoText.equals("a"))
        {webView.loadUrl("https://h4theworld.typeform.com/to/PsbAIj");}
        if(videoText.equals("b"))
        {webView.loadUrl("https://h4theworld.typeform.com/to/bdznW3");}
        if(videoText.equals("c"))
        {webView.loadUrl("https://h4theworld.typeform.com/to/p5QuYQ");}
        if(videoText.equals("d"))
        {webView.loadUrl("https://h4theworld.typeform.com/to/qPXTtS");}
        webView.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                if(progress < 100 && progressBar.getVisibility() == ProgressBar.GONE){
                    progressBar.setVisibility(ProgressBar.VISIBLE);
                }
                progressBar.setProgress(progress);
                if(progress == 100) {
                    progressBar.setVisibility(ProgressBar.GONE);
                }
            }
        });
    }
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);

        if (videoText.equals("a")) {
            toolbarTitle.setText(R.string.survey1);
        } else if (videoText.equals("b")) {
            toolbarTitle.setText(R.string.survey2);
        } else if (videoText.equals("c")) {
            toolbarTitle.setText(R.string.survey3);
        }
        else if (videoText.equals("d")) {
            toolbarTitle.setText(R.string.survey4);
        }
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }
}
