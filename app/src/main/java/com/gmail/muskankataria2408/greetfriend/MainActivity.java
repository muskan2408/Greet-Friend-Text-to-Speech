package com.gmail.muskankataria2408.greetfriend;

import android.app.ListActivity;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.Locale;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
//implements View.OnClickListener it uses when we want to override onclick method
public class MainActivity extends ListActivity  {
     Button button;
    TextToSpeech t1;
    String []names;
    private static final String TAG="MainActivity";
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {




        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                {
                    t1.setLanguage(Locale.ENGLISH);
                }
            }
        });
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");
        // if we use activity or same activity so it requires layout to set so, we need setcontentview method but
        //in String resourses it has default layout file...
//        setContentView(R.layout.activity_main);
//
//        button= (Button)findViewById(R.id.button);
//        button.setOnClickListener(this);
           names=getResources().getStringArray(R.array.Friends);
    setListAdapter((ListAdapter) new ArrayAdapter<String>(this,R.layout.friend_item, names ));
    }

    //for Activity Cycle of android


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



    // OnListItemclick method is used in listarray view if we want an event to happen on click on list of items here onclick method is of no use
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);

        textView=(TextView)findViewById(R.id.textView);
        editText=(EditText)findViewById(R.id.editText);
        if(hour>=6&&hour<12)
        {
            Intent intent= new Intent(this,Main2Activity.class);
            //if we want to start another activity
            intent.putExtra("message", "Good Morning "+ names[(int)id]+"!");
            //if we want to chnge text on same activity then use this
            //textView.setText("Good Morning "+ friend+"!");
            startActivity(intent);
        }
        if(hour>=12&&hour<17)
        {
            Intent intent= new Intent(this,Main2Activity.class);
            intent.putExtra("message", "Good Afternoon "+ names[(int)id]+"!");
            //textView.setText("Good Afternoon "+ friend+"!");
            startActivity(intent);
        }
        if(hour>=17&&hour<21)
        {
            Intent intent= new Intent(this,Main2Activity.class);
            intent.putExtra("message", "Good Evening "+ names[(int)id]+"!");
            //textView.setText("Good Evening "+ friend+"!");
            startActivity(intent);
        }
        if(hour>=21&&hour<24||hour>=0&&hour<6)
        {
            Intent intent= new Intent(this,Main2Activity.class);
            intent.putExtra("message", "Good Night "+ names[(int)id]+"!");
            //textView.setText("Good Night "+ friend+"!");
            startActivity(intent);
        }
    }

//    @Override
//    public void onClick(View view) {
//        Date date = new Date();
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date);
//        int hour = cal.get(Calendar.HOUR_OF_DAY);
//
//        textView=(TextView)findViewById(R.id.textView);
//        editText=(EditText)findViewById(R.id.editText);
//
//        String friend= editText.getText().toString();
//        if(hour>=6&&hour<12)
//        {
//            Intent intent= new Intent(this,Main2Activity.class);
//            //if we want to start another activity
//            intent.putExtra("message", "Good Morning "+ friend+"!");
//            //if we want to chnge text on same activity then use this
//            //textView.setText("Good Morning "+ friend+"!");
//            startActivity(intent);
//        }
//        if(hour>=12&&hour<17)
//        {
//            Intent intent= new Intent(this,Main2Activity.class);
//            intent.putExtra("message", "Good Afternoon "+ friend+"!");
//            //textView.setText("Good Afternoon "+ friend+"!");
//            startActivity(intent);
//        }
//        if(hour>=17&&hour<21)
//        {
//            Intent intent= new Intent(this,Main2Activity.class);
//            intent.putExtra("message", "Good Evening "+ friend+"!");
//            //textView.setText("Good Evening "+ friend+"!");
//            startActivity(intent);
//        }
//        if(hour>=21&&hour<24||hour>=0&&hour<6)
//        {
//            Intent intent= new Intent(this,Main2Activity.class);
//            intent.putExtra("message", "Good Night "+ friend+"!");
//            //textView.setText("Good Night "+ friend+"!");
//            startActivity(intent);
//        }
//         switch(view.getId())
//         {
//             case R.id.button:
//                 textView.setText("Good Night "+ friend+"!" );break;
//             default: break;
//         }
    }

