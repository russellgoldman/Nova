package com.example.android.nova;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textview = (TextView) findViewById(R.id.home_field);

        textview.setText(getIntent().getStringExtra("homeNameText"));
    }

    public void goto_resources(View view) {

        Intent intent = new Intent(this, ResourcesActivity.class);
        startActivity(intent);
    }
}
