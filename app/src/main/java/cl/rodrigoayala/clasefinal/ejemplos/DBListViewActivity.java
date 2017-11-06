package cl.rodrigoayala.clasefinal.ejemplos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import cl.rodrigoayala.clasefinal.R;

public class DBListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblist_view);

        ListView listview = (ListView) findViewById(R.id.listViewDB);
        TitulosDBHelper handler = new TitulosDBHelper(this);
        // Get access to the underlying writeable database
        SQLiteDatabase db = handler.getWritableDatabase();
        // Query for items from the database and get a cursor back
        Cursor titulosCursor = db.rawQuery("SELECT rowid _id, * FROM Titulos", null);

        DBCursorAdapter adapter = new DBCursorAdapter(this,titulosCursor,0);
        listview.setAdapter(adapter);

    }

    class DBCursorAdapter extends android.widget.CursorAdapter{

        public DBCursorAdapter(Context context, Cursor c, int flags) {
            super(context, c, flags);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_2, parent, false);

        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView tvIndex = (TextView) view.findViewById(android.R.id.text1);
            TextView tvTitulo = (TextView) view.findViewById(android.R.id.text2);

            String titulo = cursor.getString(cursor.getColumnIndexOrThrow("title"));
            int index = cursor.getInt(cursor.getColumnIndexOrThrow("id"));

            tvTitulo.setText(titulo);
            tvIndex.setText(String.valueOf(index));
        }
    }
}
