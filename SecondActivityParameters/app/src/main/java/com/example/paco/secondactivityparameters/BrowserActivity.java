package com.example.paco.secondactivityparameters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class BrowserActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        webView = findViewById(R.id.WebView);

        Bundle bundle = getIntent().getExtras();
        String webSite = bundle.getString("webSite");
        webView.loadUrl("https://" + webSite);
    }

    public void finish(View v){ this.finish(); }
}
