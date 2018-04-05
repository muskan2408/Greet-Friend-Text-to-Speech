package com.gmail.muskankataria2408.greetfriend;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity{
    private static final String TAG="Main2Activity";
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent=getIntent();
        final String message=intent.getStringExtra("message");
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText(message);

        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
       // t1.speak(message, TextToSpeech.QUEUE_FLUSH, null);



        t1=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                String msg="";
                if(status == TextToSpeech.SUCCESS) {
                    t1.setLanguage(Locale.US);
                    say(message,true);
                    say(msg,false);
                    say(msg,false);
                }
                else if (status == TextToSpeech.ERROR) {
                    Toast.makeText(getApplicationContext(),"Error occurred while initializing Text-To-Speech engine", Toast.LENGTH_LONG).show();
                }

            }
        });
        Log.i(TAG, "onCreate()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onPause() {
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }
     void say(String text, boolean flush) {
        if(flush == true)
        {
            t1.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
        if(flush == false)
        {
            t1.speak(text,TextToSpeech.QUEUE_ADD,null);
        }
    }

}
