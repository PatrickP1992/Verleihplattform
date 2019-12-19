package at.patrick.petzmann.verleihplattform;

import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VerleihDienstleistungActivity extends AppCompatActivity {
    private static final String[] DIENSTL = new String[]{
            "Haare schneiden","Rasen mähen","Garten umgraben","Fenster putzen","Grundreinigung für Gebäude"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleih_dienstleistung);

        AutoCompleteTextView editText = findViewById(R.id.VerleihDienstleistungTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DIENSTL);
        editText.setAdapter(adapter);
    }
}
