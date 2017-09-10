package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

import java.util.ArrayList;


import com.rachelgrau.rachel.health4theworldstroke.R;

public class ChatBotMainActivity extends AppCompatActivity implements AIListener  {

    AIService aiService;
    AIDataService aiDataService;
    AIConfiguration config;

    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;

    private boolean rightSide = true; //true if you want message on right rightSide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_main);

        listView = (ListView) findViewById(R.id.msgview);
        chatText = (EditText) findViewById(R.id.userMesg);
        chatArrayAdapter = new ChatArrayAdapter(getApplicationContext(), R.layout.right);
        listView.setAdapter(chatArrayAdapter);
        listView.setTranscriptMode(AbsListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        listView.setAdapter(chatArrayAdapter);


        config = new AIConfiguration("15d1973433dd45df966ef1b4fc750daf",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        // Use with text search
        aiDataService = new AIDataService(this, config);
        // Use with Voice input
        aiService = AIService.getService(this, config);
        aiService.setListener(this);
        }
        public void send(View v) {
                String the_msg=chatText.getText().toString();
                sendChatMessage(the_msg);
                AIRequest aiRequest = new AIRequest();
                aiRequest.setQuery(the_msg);

                if(aiRequest.equals("")) {
                    throw new IllegalArgumentException("aiRequest must be not null");
                }
                final AsyncTask<AIRequest, Integer, AIResponse> task = new AsyncTask<AIRequest, Integer, AIResponse>() {
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
                sendResponse(result.getFulfillment().getSpeech());
            }
            private boolean sendResponse(String text) {
                if (text.length() == 0)
                    return false;
                chatArrayAdapter.add(new ChatMessage(!rightSide, text));
                return true;
            }
            private boolean sendChatMessage(String text) {
                if (text.length() == 0)
                    return false;
                chatArrayAdapter.add(new ChatMessage(rightSide, text));
                chatText.setText("");
                return true;
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
