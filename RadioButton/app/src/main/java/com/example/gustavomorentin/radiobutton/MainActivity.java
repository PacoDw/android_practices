package com.example.gustavomorentin.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText, editText2;
    private TextView textView2;
    private RadioButton radioButton, radioButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText =(EditText)findViewById(R.id.editText);
        editText2 =(EditText)findViewById(R.id.editText2);
        textView2 =(TextView)findViewById(R.id.textView2);
        radioButton =(RadioButton)findViewById(R.id.radioButton);
        radioButton2 =(RadioButton)findViewById(R.id.radioButton2);
    }

    public void operar (View view){
        int num1 = Integer.parseInt(editText.getText().toString());
        int num2 = Integer.parseInt(editText2.getText().toString());

        if(radioButton.isChecked()==true){
            int suma = num1 + num2;
            String res = String.valueOf(suma);
            textView2.setText(res);
        } else {
            int resta = num1 - num2;
            String res = String.valueOf(resta);
            textView2.setText(res);
        }
    }
}
