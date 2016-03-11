package com.example.mm_000.testapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.audiofx.BassBoost;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.list_view);
        //listView.addView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
            startActivity(new Intent(SettingsActivity.this, MainActivity.class));
        }

        if(id == R.id.action_records)
        {
            startActivity(new Intent(SettingsActivity.this, RecordsActivity.class));
        }

        if(id == R.id.action_export)
        {
            startActivity(new Intent(SettingsActivity.this, ExportActivity.class));
        }

        if(id == R.id.action_settings)
        {
            startActivity(new Intent(SettingsActivity.this, SettingsActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }
}
