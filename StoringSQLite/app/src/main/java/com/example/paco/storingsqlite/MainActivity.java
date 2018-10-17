package com.example.paco.storingsqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText dni;
    private EditText name;
    private EditText college;
    private EditText table;

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dni = findViewById(R.id.txtDni);
        name = findViewById(R.id.txtFullname);
        college = findViewById(R.id.txtCollegeName);
        table = findViewById(R.id.txtTableNumber);

        // Connection to the database
        db = new dbSQLite(
                this,
                "paco",
                null,
                1).getWritableDatabase();

        // Method to add a register
        findViewById(R.id.addBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long isSaved = db.insert("voters", null, getRegister());
                clearInputs();

                if (isSaved == -1){
                    Snackbar.make(v, "Error: register has not been saved...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    Snackbar.make(v, "Success: register has been saved...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        // Method to delete a register
        findViewById(R.id.deleteBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int isDeleted = db.delete(
                        "voters",
                        "dni=" + dni.getText().toString(),
                        null );

                clearInputs();

                if (isDeleted == 1){
                    Snackbar.make(v, "Success: register has been deleted...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    Snackbar.make(v, "Info: register has not been deleted...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        // Method to update a register
        findViewById(R.id.updateBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int isUpdated = db.update(
                        "voters",
                        getRegister(),
                        "dni=" + dni.getText().toString(),
                        null );

                if (isUpdated == 1){
                    Snackbar.make(v, "Success: register has been updated...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                    Snackbar.make(v, "Info: register has not been updated...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        // Method to search a register
        findViewById(R.id.searchBtn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Cursor row = db.rawQuery("SELECT * FROM voters WHERE dni=" + dni.getText().toString(),
                        null );

                if (row.moveToFirst()){
                    Snackbar.make(v, "Success: register has been founded...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                    name.setText(row.getString(1));
                    college.setText(row.getString(2));
                    table.setText(row.getString(3));
                }
                else {
                    Snackbar.make(v, "Info: register is not exists...", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    private void clearInputs(){
        dni.setText("");
        name.setText("");
        college.setText("");
        table.setText("");
    }

    private ContentValues getRegister(){
        ContentValues  register = new ContentValues();
        register.put("dni", dni.getText().toString());
        register.put("name", name.getText().toString());
        register.put("college", college.getText().toString());
        register.put("tableNum", table.getText().toString());

        return register;
    }
}
