package com.example.paco.storingexternsd;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText filename;
    private EditText contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filename = findViewById(R.id.txtFileName);
        contentTxt = findViewById(R.id.txtContent);
    }

    public void onClickSave(View v) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(
                    new FileOutputStream(new File(
                            Environment.getExternalStorageDirectory().getAbsolutePath(),
                            filename.getText().toString() ) )
            );
            osw.write(contentTxt.getText().toString());
            osw.flush();
            osw.close();

            Toast.makeText(this, "The file has been saved!", Toast.LENGTH_LONG).show();

            filename.setText("");
            contentTxt.setText("");
        } catch (IOException ioe) {
            Toast.makeText(this, "Error onClickSave", Toast.LENGTH_LONG).show();

        }
    }

    public void onClickRecover(View v) {
        try {
            FileInputStream fIn = new FileInputStream(new File(
                    Environment.getExternalStorageDirectory().getAbsolutePath(),
                    filename.getText().toString())
            );
            BufferedReader br = new BufferedReader(new InputStreamReader(fIn));
            String linea = br.readLine();
            String todo = "";
            while (linea != null) {
                todo = todo + linea + "";
                linea = br.readLine();
            }
            br.close();
            contentTxt.setText(todo);
        } catch (IOException e) {
            Toast.makeText(this, "Error onClickRecover", Toast.LENGTH_LONG).show();

        }
    }
}
