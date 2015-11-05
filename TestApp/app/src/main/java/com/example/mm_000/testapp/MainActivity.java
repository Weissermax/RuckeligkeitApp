package com.example.mm_000.testapp;

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

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView xValueText, yValueText, zValueText;
    private Sensor mySensor;
    private SensorManager mySensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
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
