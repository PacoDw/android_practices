package com.example.paco.listviewcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView txtV;
    private ListView listV;

    private String[] paises = {
            "Argentina", "Chile", "Paraguay", "Bolivia", "Peru",
            "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay"
    };

    private String[] habitantes = {
            "40000000", "17000000", "6500000","10000000", "30000000",
            "14000000", "183000000", "44000000","29000000", "3500000"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtV = findViewById(R.id.txtView);
        listV = findViewById(R.id.listView);


        listV.setAdapter(new ArrayAdapter<> (
                this,
                android.R.layout.simple_list_item_1,
                paises
                )
        );

        listV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int posicion, long id) {
                txtV.setText("Población de "+ listV.getItemAtPosition(posicion) + " es "+ habitantes[posicion]);
            }
        });
    }
}
