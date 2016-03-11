package com.example.mm_000.testapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class RecordsActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            public void onClick(View v) {
                LinearLayout recordListLinearLayout = (LinearLayout) findViewById(R.id.recordListLinearLayout);

                TextView exampleTextView = new TextView(RecordsActivity.this);
                exampleTextView.setText("Dies ist ein Record Beispiel.");
                exampleTextView.setTextColor(Color.RED);
                exampleTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                exampleTextView.setHeight(100);

                recordListLinearLayout.addView(exampleTextView,0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_records, menu);
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
            startActivity(new Intent(RecordsActivity.this, MainActivity.class));
        }

        if(id == R.id.action_records)
        {
            startActivity(new Intent(RecordsActivity.this, RecordsActivity.class));
        }

        if(id == R.id.action_export)
        {
            startActivity(new Intent(RecordsActivity.this, ExportActivity.class));
        }

        if(id == R.id.action_settings)
        {
            startActivity(new Intent(RecordsActivity.this, SettingsActivity.class));
        }


        return super.onOptionsItemSelected(item);
    }


}
