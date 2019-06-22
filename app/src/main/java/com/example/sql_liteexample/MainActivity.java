package com.example.sql_liteexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.database.SQLException;

 //import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= findViewById(R.id.etName);
        etCell= findViewById(R.id.etCell);

    }


    public void btnEditData(View view) {
        try{
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.updateEntry("1", "Jatin Joshi", "2323434");
            db.close();
            Toast.makeText(MainActivity.this, "Update saved!!", Toast.LENGTH_LONG).show();
            etName.setText("");
            etCell.setText("");
        }
        catch (SQLException e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }

    public void btnDeleteData(View view) {
        try{
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.deleteEntry("1");
            db.close();
            Toast.makeText(MainActivity.this, "Successfully Deleted!!", Toast.LENGTH_LONG).show();
            etName.setText("");
            etCell.setText("");
        }
        catch (SQLException e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }

    public void btnShowData(View view) {
       startActivity(new Intent(MainActivity.this, Dara.class));
    }

    public void btnSubmitData(View view) {
        String name = etName.getText().toString().trim();
        String cell = etCell.getText().toString().trim();
       try{
           ContactsDB db = new ContactsDB(this);
           db.open();
           db.createEntry(name, cell);
           db.close();
           Toast.makeText(MainActivity.this, "Successfully saved!!", Toast.LENGTH_LONG).show();
           etName.setText("");
           etCell.setText("");
         }
        catch (SQLException e){
           Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
}
