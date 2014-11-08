package com.smartplace.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //View for second activity is provided here
        setContentView(R.layout.activity_second);

        //get xml reference for the textView
        TextView txtMessageReceived = (TextView)findViewById(R.id.txt_message_received);

        //Intent with the one the current activity has been created is referenced
        Intent intent = getIntent();
        //Once we reference the intent, we can access the value pair parameters
        //given as additional information for the current activity.
        String message =intent.getStringExtra("message");
        //By retrieving the data and store it in a variable, now we can do anything
        //we want with the variable and assign it to the textView
        txtMessageReceived.setText(message);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
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
}
