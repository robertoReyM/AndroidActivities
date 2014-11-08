package com.smartplace.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //always the onCreate method shall call the default onCreate
        //with the super.onCreate method below
        super.onCreate(savedInstanceState);
        //the view to be used by the activity is defined here
        setContentView(R.layout.activity_first);

        //get xml references
        //In order to get the references the "findViewById" method shall be
        //called and casting the view into the desired view type
        TextView txtHello = (TextView)findViewById(R.id.txt_hello);
        Button btnNextActivity = (Button)findViewById(R.id.btn_next_activity);
        final EditText editMessage = (EditText)findViewById(R.id.edit_message);

        //set text on textView and button
        txtHello.setText(getString(R.string.txt_hello));
        btnNextActivity.setText(getString(R.string.btn_next_activity));

        //set text color on textView
        txtHello.setTextColor(getResources().getColor(R.color.test_color));

        //set on click listener on button
        btnNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intents are used to call other activities in your project
                //the context passed on the intent constructor is the current
                //activity's context, and the second parameter is the class
                //of the desired activity to create
                Intent intent = new Intent(getBaseContext(), SecondActivity.class);
                //In case we want to pass data from one activity to another one
                //the intent is provided with additional value pair parameters
                //that are received on the created activity
                //Here we pass the content of the editMessage EditText into
                //the next activity
                intent.putExtra("message", editMessage.getText().toString());
                //The next method is provided with the intent in order to start the
                //desired activity
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
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
