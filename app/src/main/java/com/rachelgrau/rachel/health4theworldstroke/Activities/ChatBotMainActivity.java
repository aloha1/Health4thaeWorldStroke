package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
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

import java.util.Locale;

public class ChatBotMainActivity extends AppCompatActivity implements AIListener,TextToSpeech.OnInitListener  {

    AIService aiService;
    AIDataService aiDataService;
    AIConfiguration config;
    TextToSpeech tts;

    private ChatArrayAdapter chatArrayAdapter;
    private ListView listView;
    public TextView option1,option2,option3,option4,option5,option6;

    private boolean rightSide = true; //true if you want message on right rightSide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot_main);

        String feeling=getIntent().getStringExtra("Feeling");

        option1=(TextView) findViewById(R.id.option1);
        option2=(TextView) findViewById(R.id.option2);
        option3=(TextView) findViewById(R.id.option3);
        option4=(TextView) findViewById(R.id.option4);
        option5=(TextView) findViewById(R.id.option5);
        option6=(TextView) findViewById(R.id.option6);

        listView = (ListView) findViewById(R.id.msgview);
        tts = new TextToSpeech(this, this);
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
        send(feeling);

        }

        public void send(String the_msg) {
                //String the_msg=chatText.getText().toString();
            if(the_msg.equals("Awesome") || the_msg.equals("Happy") || the_msg.equals("Normal") ||
                    the_msg.equals("Sad") || the_msg.equals("Very Sad")){
                if(the_msg.equals("Awesome") || the_msg.equals("Happy")){
                    changeText(1);
                }
            }else{
                sendChatMessage(the_msg);
            }
                AIRequest aiRequest = new AIRequest();
                aiRequest.setQuery(the_msg);

                if(aiRequest.equals("")) {
                    throw new IllegalArgumentException("aiRequest must be not null");
                }
                @SuppressLint("StaticFieldLeak") final AsyncTask<AIRequest, Integer, AIResponse> task = new AsyncTask<AIRequest, Integer, AIResponse>() {
                            private AIError aiError;
                            @Override
                            protected AIResponse doInBackground(final AIRequest... params) {
                                final AIRequest request = params[0];
                                try {
                                    // Return response
                                    return aiDataService.request(request);
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
            private void sendResponse(String text) {
                if (text.length() == 0)
                    return;
                chatArrayAdapter.add(new ChatMessage(!rightSide, text));
                ConvertTextToSpeech(text);
            }
            private void sendChatMessage(String text) {
                if (text.length() == 0)
                    return;
                chatArrayAdapter.add(new ChatMessage(rightSide, text));
                //chatText.setText("");
            }

            @Override
            public void onError(AIError error) {
                Toast.makeText(this,"Some Error...Check your internet",Toast.LENGTH_SHORT).show();
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
            case 1:
                option1.setText("Exit");
                option2.setVisibility(View.GONE);
                option3.setVisibility(View.GONE);
                option4.setVisibility(View.GONE);
                option5.setVisibility(View.GONE);
                option6.setVisibility(View.GONE);
                break;
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
            case "Not Recovering Soon?":
                changeText(2);
                break;
            case "Anxious?":
                changeText(2);
                break;
            case "Depressed?":
                changeText(2);
                break;
            case "Can't Sleep?":
                changeText(2);
                break;
            case "Feeling Tired?":
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

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }
    @Override
    public void onPause() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
        }
        super.onPause();
    }
    private void ConvertTextToSpeech(String sayIt) {
        // TODO Auto-generated method stub

        if(sayIt==null||"".equals(sayIt))
        {
            sayIt = "Content not available";
            tts.speak(sayIt, TextToSpeech.QUEUE_FLUSH, null);
        }else
            tts.speak(sayIt, TextToSpeech.QUEUE_FLUSH, null);
    }

}

