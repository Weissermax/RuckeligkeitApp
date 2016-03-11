package com.example.mm_000.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ExportActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_export, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if(id == R.id.action_home)
        {
            startActivity(new Intent(ExportActivity.this, MainActivity.class));
        }

        if(id == R.id.action_records)
        {
            startActivity(new Intent(ExportActivity.this, RecordsActivity.class));
        }

        if(id == R.id.action_export)
        {
            startActivity(new Intent(ExportActivity.this, ExportActivity.class));
        }

        if(id == R.id.action_settings)
        {
            startActivity(new Intent(ExportActivity.this, SettingsActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }

}
