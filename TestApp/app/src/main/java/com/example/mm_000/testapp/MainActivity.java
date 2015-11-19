package com.example.mm_000.testapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private Toolbar toolbar;
    private TextView xValueText, yValueText, zValueText;
    private Sensor mySensor;
    private SensorManager mySensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        // Create Sensor Manager
        mySensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        // Accelerometer Sensor
        mySensor = mySensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Register sensor Listener
        mySensorManager.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);
        //Try also the other DELAY-Sensors:
        //mySensorManager.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_GAME);
        //mySensorManager.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_FASTEST);

        xValueText = (TextView)findViewById(R.id.xValueText);
        yValueText = (TextView)findViewById(R.id.yValueText);
        zValueText = (TextView)findViewById(R.id.zValueText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // TODO: implement all menu items
        if(id == R.id.action_home)
        {
            Context context = getApplicationContext();
            CharSequence text = "Just hit "+item.getTitle();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();return true;
        }

        if(id == R.id.action_records)
        {
            startActivity(new Intent(MainActivity.this, RecordsActivity.class));
        }

        if(id == R.id.action_export)
        {
            Context context = getApplicationContext();
            CharSequence text = "Just hit "+item.getTitle();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();return true;
        }

        if(id == R.id.action_settings)
        {
            Context context = getApplicationContext();
            CharSequence text = "Just hit "+item.getTitle();
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xValueText.setText("X: "+ event.values[0]);
        yValueText.setText("Y: "+ event.values[1]);
        zValueText.setText("Z: "+ event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Not in use
    }
}
