package com.example.mervesimsek.appsentencev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Merve Şimşek on 26.1.2017.
 */

public class CategoryActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FloatingActionButton create;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.btncreate2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create a new sentence", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        create = (FloatingActionButton) findViewById(R.id.btncreate2);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent srcint = new Intent(CategoryActivity.this, CardActivity.class);
                startActivity(srcint);
            }
        });


        ListView lvcategory = (ListView) findViewById(R.id.listViewCategories);
        ArrayList<String> arrayCategories = new ArrayList<>();
        arrayCategories.addAll(Arrays.asList(getResources().getStringArray(R.array.string_category)));

        adapter = new ArrayAdapter<>(
                CategoryActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCategories);
        lvcategory.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        SearchView searchView = (SearchView) item.getActionView();
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
