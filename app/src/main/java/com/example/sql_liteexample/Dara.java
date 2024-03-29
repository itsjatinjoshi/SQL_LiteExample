package com.example.sql_liteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.database.SQLException;

 //import java.sql.SQLException;

public class Dara extends AppCompatActivity {
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dara);

        tvData= (TextView) findViewById(R.id.tvData);
        try{
            ContactsDB db = new ContactsDB(this);
            db.open();
            tvData.setText(db.getData());
            db.close();
            Toast.makeText(Dara.this, "Successfully saved!!", Toast.LENGTH_LONG).show();

        }
        catch(SQLException e){
            Toast.makeText(Dara.this, e.getMessage(), Toast.LENGTH_LONG).show();

        }
    }
}
