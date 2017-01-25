package com.example.mervesimsek.appsentencev2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddSentence_Activity extends AppCompatActivity  {
    final Context context=this;
    Button gec2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addsentence_layout);

        //Font düzenlemesi için burayı incele http://stackoverflow.com/questions/34572810/how-to-change-default-font-of-the-android-app
        TextView textView3 = (TextView) findViewById(R.id.textView2);
        TextView textView4 = (TextView) findViewById(R.id.textView3);


        Typeface font = Typeface.createFromAsset(context.getAssets(),"fonts/neuropol.ttf");
        textView3.setTypeface(font);
        textView4.setTypeface(font);


        gec2 = (Button) findViewById(R.id.button2);
        gec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AddSentence_Activity.this,OtherActivity.class);
                startActivity(i);
            }
        });


    }
}


