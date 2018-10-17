package com.example.paco.storingsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.txtEmail);

        email.setText(getSharedPreferences("datos", Context.MODE_PRIVATE)
                        .getString("email", "")
        );
    }

    public void onClickSave(View v) {
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);

        preferences
                .edit()
                .putString("email", email.getText().toString())
                .apply();
        finish();
    }
}


/**
 * El modo de operación del archivo puede ser:
 *
 * MODE_PRIVATE solo la aplicación puede acceder al archivo de preferencias.
 *
 * MODE_WORLD_READABLE otras aplicaciones pueden consultar el archivo de preferencias
 *
 * MODE_WORLD_WRITEABLE otras aplicaciones pueden consultar y modificar el archivo.
 *
 * MODE_MULTI_PROCESS varios procesos pueden acceder (Requiere Android 2.3)
 * */