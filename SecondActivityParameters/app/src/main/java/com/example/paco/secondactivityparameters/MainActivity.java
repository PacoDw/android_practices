package com.example.paco.secondactivityparameters;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtWebSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtWebSite = findViewById(R.id.txtSitioWeb);
    }

    public void onClickVer(View v){
        Intent intent =  new Intent(this, BrowserActivity.class);
        intent.putExtra("webSite", txtWebSite.getText().toString());
        startActivity(intent);
    }
}
