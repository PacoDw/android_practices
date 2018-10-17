package com.example.gustavomorentin.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView3;
    private EditText editText, editText2;
    private CheckBox checkBox, checkBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        textView3 = (TextView)findViewById(R.id.textView3);
        checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
    }

    public void calcular(View view){
        int num1 = Integer.parseInt(editText.getText().toString());
        int num2 = Integer.parseInt(editText2.getText().toString());
        String resu = "";
        if(checkBox.isChecked()&& checkBox2.isChecked()){
            int res = num1 + num2;
            int res2 = num1 - num2;
            resu = "Suma: " + res;
            resu += "\n Resta: " + res2;
        }
        else
        if(checkBox.isChecked()){
            int res = num1 + num2;
            resu = "Suma: " + res;
        }
        else
        if(checkBox2.isChecked()){
            int res = num1 - num2;
            resu = "Resta: " + res;
        }
        textView3.setText(resu);
    }
}
