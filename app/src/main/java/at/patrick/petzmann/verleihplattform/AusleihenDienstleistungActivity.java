package at.patrick.petzmann.verleihplattform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import at.patrick.petzmann.verleihplattform.Klassen.Dienstleistung;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

public class AusleihenDienstleistungActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausleihen_dienstleistung);


        ListView dienstleistungen = findViewById(R.id.listViewDienstleistungen);

        ArrayList<String> content = new ArrayList<>();

        for (Dienstleistung d:verleihsystem.getDienstleistungen())
        {
            content.add(d.getName());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_list_item_custom, content);

        dienstleistungen.setAdapter(arrayAdapter);

    }
}
