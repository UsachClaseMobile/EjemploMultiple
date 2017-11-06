package cl.rodrigoayala.clasefinal.ejemplos;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.rodrigoayala.clasefinal.R;

public class DatabaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        final EditText idEditText = (EditText) findViewById(R.id.idEditText);
        final EditText tituloEditText = (EditText) findViewById(R.id.tituloEditText);

        Button guardarButton = (Button) findViewById(R.id.guardarButton);
        Button verButton = (Button) findViewById(R.id.verButton);

        TitulosDBHelper mDbHelper = new TitulosDBHelper(DatabaseActivity.this);

        // Gets the data repository in write mode
        final SQLiteDatabase db = mDbHelper.getWritableDatabase();

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put("id", idEditText.getText().toString());
                values.put("title", tituloEditText.getText().toString());

                // Inser    t the new row, returning the primary key value of the new row
                long newRowId;
                newRowId = db.insert(
                        "Titulos",
                        null,
                        values);

                Toast.makeText(DatabaseActivity.this,"Id de fila: " + newRowId , Toast.LENGTH_SHORT).show();
            }
        });

        verButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseActivity.this,DBListViewActivity.class);
                startActivity(intent);
            }
        });
    }
}