package com.example.paco.spinnercontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private Spinner spinner;
    private EditText txtUno;
    private EditText txtDos;
    private TextView txtVRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUno = findViewById(R.id.txtValorUno);
        txtDos = findViewById(R.id.txtValorDos);
        txtVRes = findViewById(R.id.txtVRes);

        spinner = findViewById(R.id.spinner);

        String []opciones = {"sumar","restar","multiplicar","dividir"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opciones
        );

        spinner.setAdapter(adapter);
    }

    public void operar(View view) {
        String valor1=txtUno.getText().toString();
        String valor2=txtDos.getText().toString();

        int nro1=Integer.parseInt(valor1);
        int nro2=Integer.parseInt(valor2);

        String selec=spinner.getSelectedItem().toString();
        if (selec.equals("sumar")) {
            int suma=nro1+nro2;
            String resu=String.valueOf(suma);
            txtVRes.setText(resu);
        } else
        if (selec.equals("restar")) {
            int resta=nro1-nro2;
            String resu=String.valueOf(resta);
            txtVRes.setText(resu);
        }
        else
        if (selec.equals("multiplicar")) {
            int multi=nro1*nro2;
            String resu=String.valueOf(multi);
            txtVRes.setText(resu);
        }
        else
        if (selec.equals("dividir")) {
            int divi=nro1/nro2;
            String resu=String.valueOf(divi);
            txtVRes.setText(resu);
        }
    }
}
