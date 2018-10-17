package com.example.paco.secondactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtView = findViewById(R.id.txtV);

        Bundle extras = getIntent().getExtras();

        if (extras != null)
            txtView.setText(extras.getString("name"));
    }


    public void closeActivity(View view) {  finish(); }
}
