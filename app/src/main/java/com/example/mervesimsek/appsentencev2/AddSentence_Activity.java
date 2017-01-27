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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddSentence_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayAdapter<String> adapter;
    final Context context = this;
    Button gec2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addsentence_layout);

        //Font düzenlemesi için burayı incele http://stackoverflow.com/questions/34572810/how-to-change-default-font-of-the-android-app
        TextView textView3 = (TextView) findViewById(R.id.textView2);
        TextView textView4 = (TextView) findViewById(R.id.textView3);
        TextView textView6 = (TextView) findViewById(R.id.textView6);


        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/neuropol.ttf");
        textView3.setTypeface(font);
        textView4.setTypeface(font);
        textView6.setTypeface(font);


        gec2 = (Button) findViewById(R.id.button2);
        gec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddSentence_Activity.this, OtherActivity.class);
                startActivity(i);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        List<String> categories = new ArrayList<String>();
        categories.add("Greetings");
        categories.add("Introductions");
        categories.add("Travel");
        categories.add("Accommodation");
        categories.add("Shopping");
        categories.add("On The Telephone");
        categories.add("Making Friends");
        categories.add("Health");
        categories.add("Business");
        categories.add("Money");
        categories.add("Education");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = parent.getItemAtPosition(position).toString();


        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {

    }


}



