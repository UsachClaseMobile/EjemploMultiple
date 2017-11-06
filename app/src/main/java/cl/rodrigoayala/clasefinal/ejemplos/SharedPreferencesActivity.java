package cl.rodrigoayala.clasefinal.ejemplos;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import cl.rodrigoayala.clasefinal.R;

public class SharedPreferencesActivity extends AppCompatActivity {


    EditText textoEditText;
    SharedPreferences settings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        textoEditText = (EditText) findViewById(R.id.textoEditText);

        settings = getSharedPreferences("Settings", 0);
        editor = settings.edit();

        textoEditText.setText(settings.getString("texto",""));
    }

    @Override
    protected void onStop() {
        super.onStop();
        editor.putString("texto", textoEditText.getText().toString());
        editor.commit();
    }
}
