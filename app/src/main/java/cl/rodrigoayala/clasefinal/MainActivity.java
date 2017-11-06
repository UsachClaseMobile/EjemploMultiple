package cl.rodrigoayala.clasefinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cl.rodrigoayala.clasefinal.ejemplos.DatabaseActivity;
import cl.rodrigoayala.clasefinal.ejemplos.HTTPActivity;
import cl.rodrigoayala.clasefinal.ejemplos.SharedPreferencesActivity;
import cl.rodrigoayala.clasefinal.ejemplos.StorageActivity;
import cl.rodrigoayala.clasefinal.ejemplos.VideoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonSharedPreferences = (Button) findViewById(R.id.button_sharedpreferences);
        final Button buttonStorage = (Button) findViewById(R.id.button_storage);
        final Button buttonDatabase = (Button) findViewById(R.id.button_database);
        final Button buttonHTTP = (Button) findViewById(R.id.button_http);
        final Button buttonVideo = (Button) findViewById(R.id.button_video);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class klass = null;
                if (v == buttonSharedPreferences) {
                    klass = SharedPreferencesActivity.class;
                } else if (v == buttonStorage) {
                    klass = StorageActivity.class;
                } else if (v == buttonDatabase) {
                    klass = DatabaseActivity.class;
                } else if (v == buttonHTTP) {
                    klass = HTTPActivity.class;
                } else if (v == buttonVideo) {
                    klass = VideoActivity.class;
                }

                Intent intent = new Intent(MainActivity.this,klass);
                startActivity(intent);
            }
        };

        buttonSharedPreferences.setOnClickListener(listener);
        buttonStorage.setOnClickListener(listener);
        buttonDatabase.setOnClickListener(listener);
        buttonHTTP.setOnClickListener(listener);
        buttonVideo.setOnClickListener(listener);
    }
}
