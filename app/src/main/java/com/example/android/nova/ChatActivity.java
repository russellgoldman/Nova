package com.example.android.nova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        WebView webView = findViewById(R.id.web_view);
        // Simplest usage: note that an exception will NOT be thrown
        // if there is an error loading this page (see below).
        webView.loadUrl("https://example.com/");

    }
}
