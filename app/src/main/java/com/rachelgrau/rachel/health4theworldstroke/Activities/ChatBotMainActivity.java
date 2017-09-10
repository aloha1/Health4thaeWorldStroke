package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;
import com.google.gson.JsonElement;
import java.util.Map;

import com.rachelgrau.rachel.health4theworldstroke.R;
import com.squareup.picasso.Downloader;

public class ChatBotMainActivity extends AppCompatActivity implements AIListener  {

    private AIService aiService;
    TextView tv;
    Button listenButton;
    AIDataService aiDataService;
    AIConfiguration config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_main);

        listenButton = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView2);

        config = new AIConfiguration("15d1973433dd45df966ef1b4fc750daf",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        // Use with text search
        aiDataService = new AIDataService(this, config);

        // Use with Voice input
        aiService = AIService.getService(this, config);

        aiService.setListener(this);

        }
        public void listenButtonOnClick(View view) {
            AIRequest aiRequest = new AIRequest();
                aiRequest.setQuery("How are you");

                if(aiRequest==null) {
                    throw new IllegalArgumentException("aiRequest must be not null");
                }

                final AsyncTask<AIRequest, Integer, AIResponse> task =
                        new AsyncTask<AIRequest, Integer, AIResponse>() {
                            private AIError aiError;
                            @Override
                            protected AIResponse doInBackground(final AIRequest... params) {
                                final AIRequest request = params[0];
                                try {
                                    final AIResponse response = aiDataService.request(request);
                                    // Return response
                                    return response;
                                } catch (final AIServiceException e) {
                                    aiError = new AIError(e);
                                    return null;
                                }
                            }
                            @Override
                            protected void onPostExecute(final AIResponse response) {
                                if (response != null) {
                                    onResult(response);
                                } else {
                                    onError(aiError);
                                }
                            }
                        };
                task.execute(aiRequest);
            }
            @Override
            public void onResult(final AIResponse response) {
                Result result = response.getResult();

                // Get parameters
                String parameterString = "";
                if (result.getParameters() != null && !result.getParameters().isEmpty()) {
                    for (final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()) {
                        parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
                    }
                }
                //Show results in TextView.
                tv.setText("Query:" + result.getResolvedQuery() +
                        "\nAction: " + result.getFulfillment().getSpeech() +
                        "\nParameters: " + parameterString);
            }

            @Override
            public void onError(AIError error) {

            }

            @Override
            public void onAudioLevel(float level) {

            }

            @Override
            public void onListeningStarted() {

            }

            @Override
            public void onListeningCanceled() {

            }

            @Override
            public void onListeningFinished() {

            }
        }
