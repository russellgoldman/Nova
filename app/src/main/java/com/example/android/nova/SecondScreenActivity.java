package com.example.android.nova;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        TextView textview = (TextView)findViewById(R.id.new_name_field);

        textview.setText(getIntent().getStringExtra("nameText"));


    }

    public void goto_home(View view){

        TextView textview = (TextView)findViewById(R.id.new_name_field);
        String nameField = textview.getText().toString();

        Intent intent = new Intent(this, Home.class);
        intent.putExtra("homeNameText", nameField);
        startActivity(intent);
    }



}
