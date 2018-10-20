package com.example.paco.loadimages;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText filename;
    private ListView imageList;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> archivos = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageList = findViewById(R.id.imagesListView);

        imageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "=>"+parent.getAdapter().getItem(position),
                        Toast.LENGTH_LONG
                ).show();

                File path = new File(Environment.getExternalStorageDirectory(), "/TestFolder/"+parent.getAdapter().getItem(position));

                ImageView imageView = findViewById(R.id.imageView);
                imageView.setImageBitmap(BitmapFactory.decodeFile(path.getAbsolutePath()));
            }
        });


        findViewById(R.id.loadBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = new File(Environment.getExternalStorageDirectory().getPath(), "TestFolder");
                if (dir.exists() && dir.isDirectory()) {

                    Toast.makeText(
                            getApplicationContext(),
                            "Si existe!!",
                            Toast.LENGTH_LONG
                    ).show();
                    File[] files = dir.listFiles();


                    if (files.length == 0) {
                        Toast.makeText(getApplicationContext(), "No hay archivos", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        archivos.clear();

                        for (File aFile : files) {
                            archivos.add(aFile.getName());
                        }
                        adapter = new ArrayAdapter<>(
                                MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                archivos
                        );
                        imageList.setAdapter(adapter);
                    }
                }
                else
                {
                    Toast.makeText(
                            getApplicationContext(),
                            "No existe!!",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
    }
}
