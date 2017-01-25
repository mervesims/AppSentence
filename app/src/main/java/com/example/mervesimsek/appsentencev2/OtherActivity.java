package com.example.mervesimsek.appsentencev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.SearchManager;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Merve Şimşek on 23.1.2017.
 */

public class OtherActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FloatingActionButton create;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btncreate);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create a new sentence", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        create = (FloatingActionButton) findViewById(R.id.btncreate);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent srcintent = new Intent(OtherActivity.this,AddSentence_Activity.class);
                startActivity(srcintent);
            }
        });



        ListView lv = (ListView) findViewById(R.id.listViewSentences);
        ArrayList<String> arraySentences = new ArrayList<>();
        arraySentences.addAll(Arrays.asList(getResources().getStringArray(R.array.string_sentences)));

        adapter = new ArrayAdapter<>(
                OtherActivity.this,
                android.R.layout.simple_list_item_1,
                arraySentences);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView)item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);

                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
