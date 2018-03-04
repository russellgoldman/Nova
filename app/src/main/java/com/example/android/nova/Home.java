package com.example.android.nova;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView textview = (TextView) findViewById(R.id.home_field);

        textview.setText(getIntent().getStringExtra("homeNameText"));

        ImageView imageView = findViewById(R.id.nova_talk);

        imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // do stuff
                Uri uri = Uri.parse("https://m.me/320739645118779");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });
    }

    public void goto_resources(View view) {

        Intent intent = new Intent(this, ResourcesActivity.class);
        startActivity(intent);
    }
}
