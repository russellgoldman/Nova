package com.example.android.mentalhealthbot;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.android.mentalhealthbot.MessageListAdapter;
import com.example.android.mentalhealthbot.R;
import com.example.android.mentalhealthbot.UserMessage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ai.api.AIListener;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIResponse;
import ai.api.model.Result;


public class MainActivity extends AppCompatActivity implements AIListener {
    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    AIService aiService;
    List<UserMessage> messageList;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int permission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.RECORD_AUDIO);

        if (permission != PackageManager.PERMISSION_GRANTED) {

            makeRequest();
        }

        List<UserMessage> messageList = new ArrayList<>();

        // create the dialog flor listener service
        final AIConfiguration config = new AIConfiguration("4a4e36496e3a4d18a4af3d095a3ebdc3",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);

        aiService = AIService.getService(this, config);
        aiService.setListener(this);

        long time = new Date().getTime();
        messageList.add(new UserMessage("hello",false, time));
        messageList.add(new UserMessage("ima bot",false, time));
        messageList.add(new UserMessage("or am I",false, time));
        messageList.add(new UserMessage("ahaha",false, time));


        mMessageRecycler = (RecyclerView) findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(mMessageAdapter);
    }

    protected void makeRequest() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.RECORD_AUDIO},
                101);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 101: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {


                } else {

                }
                return;
            }
        }
    }


    public void listenButtonClicked(View view){

        aiService.startListening();

    }

    @Override
    public void onResult(AIResponse result) {

        // get speech response and get its text
        Log.d("anu",result.toString());
        Result result1=result.getResult();
        t.setText("Query "+result1.getResolvedQuery()+" action: "+result1.getAction());
        // do something with that text (add to list)
        long time = new Date().getTime();
        messageList.add(new UserMessage(strResult,true, time));

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

