package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIDataService;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;


import com.rachelgrau.rachel.health4theworldstroke.R;

public class ChatBotMainActivity extends AppCompatActivity implements AIListener  {

    AIService aiService;
    AIDataService aiDataService;
    AIConfiguration config;

    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    private EditText chatText;
    public TextView option1,option2,option3,option4,option5,option6;

    private boolean rightSide = true; //true if you want message on right rightSide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_main);

        option1=(TextView) findViewById(R.id.option1);
        option2=(TextView) findViewById(R.id.option2);
        option3=(TextView) findViewById(R.id.option3);
        option4=(TextView) findViewById(R.id.option4);
        option5=(TextView) findViewById(R.id.option5);
        option6=(TextView) findViewById(R.id.option6);

        listView = (ListView) findViewById(R.id.msgview);
        /*chatText = (EditText) findViewById(R.id.userMesg);*/
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

        public void send(String the_msg) {
                //String the_msg=chatText.getText().toString();
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
                //chatText.setText("");
                return true;
            }

            @Override
            public void onError(AIError error) {
                Toast.makeText(this,"Some Error.Check your internet",Toast.LENGTH_SHORT).show();
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

    public void onClick(View v){

        switch (v.getId()){
            case R.id.option1:
                send(option1.getText().toString());
                check(option1.getText().toString());
                break;
            case R.id.option2:
                send(option2.getText().toString());
                check(option2.getText().toString());
                break;
            case R.id.option3 :
                send(option3.getText().toString());
                check(option3.getText().toString());
                break;
            case R.id.option4 :
                send(option4.getText().toString());
                check(option4.getText().toString());
                break;
            case R.id.option5 :
                send(option5.getText().toString());
                check(option5.getText().toString());
                break;
            case R.id.option6 :
                send(option6.getText().toString());
                check(option6.getText().toString());
                break;
        }
    }
    public void changeText(int no){  /*function to change options*/
        switch(no){
            case 2:
                option1.setText("Watch 360 Videos");
                option2.setText("Listen to music");
                option3.setVisibility(View.VISIBLE);
                option4.setVisibility(View.VISIBLE);
                option5.setVisibility(View.VISIBLE);
                option6.setVisibility(View.VISIBLE);
                option3.setText("Inspiring Quotes");
                option4.setText("Stroke Exercise Video");
                option5.setText("Get tips to tackle this");
                option6.setText("Exit");
                break;
            case 3:
                option1.setText("Yes");
                option2.setText("No");
                option3.setVisibility(View.GONE);
                option4.setVisibility(View.GONE);
                option5.setVisibility(View.GONE);
                option6.setVisibility(View.GONE);
                break;
        }
        }
    public void check(String text){

        switch (text){
            case "Lonely?":
                changeText(2);
                break;
            case "Watch 360 Videos":
                Intent intent=new Intent(ChatBotMainActivity.this,VR_menu.class);
                startActivity(intent);
                break;
            case "Listen to music":
                intent=new Intent(ChatBotMainActivity.this,ChatBotMusic.class);
                startActivity(intent);
                break;
            case "No":
                changeText(2);
                break;
            case "Exit":
                finish();
                break;
            case "Stroke Exercise Video":
                intent=new Intent(ChatBotMainActivity.this,Exercise.class);
                startActivity(intent);
                break;
            case "Get tips to tackle this":
                changeText(3);
                break;
            case "Inspiring Quotes":
                intent=new Intent(this,chatBotQuotes.class);
                startActivity(intent);
                break;
        }

    }

}
