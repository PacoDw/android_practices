package com.example.paco.storingpreferencesfile;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private EditText stringText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stringText = findViewById(R.id.txtText);

        String[] files = fileList();

        if (Arrays.asList(files).contains("myFile.txt")){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("myFile.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                stringText.setText(todo);
            } catch (IOException e) {}
        }
    }

    public void onClickSave(View v) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    "myFile.txt", Activity.MODE_PRIVATE));
            archivo.write(stringText.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (IOException e) {}
        Toast.makeText(this, "Saved text...", Toast.LENGTH_SHORT).show();
        finish();
    }
}
