package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

import at.patrick.petzmann.verleihplattform.Klassen.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

public class VerleihGegenstand extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();


    private static final String[] ITEMS = new String[]{
            "Fahrrad", "Mixer", "Rasenmäher", "Kettensäge", "Staubsauger"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleih_gegenstand);

        AutoCompleteTextView editText = findViewById(R.id.VerleihGegenstandTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ITEMS);
        editText.setAdapter(adapter);//
    }

    public void angebotErstellt(View view) {
        Intent intent = new Intent(this, AngebotErstelltActivity.class);
        TextView nameTextView = findViewById(R.id.VerleihGegenstandTextView);
        TextView adresseTextView = findViewById(R.id.editText_VGegenstandAdresse);
        TextView plzTextView = findViewById(R.id.editText_VGegenstandPLZ);
        TextView ortTextView = findViewById(R.id.autoCompleteTextView);
        TextView vonDatumTextView = findViewById(R.id.editText_VGegenstandDatumVon);
        TextView bisDatumTextView = findViewById(R.id.editText_VGegenstandDatumBis);

        String name = nameTextView.getText().toString();
        String adresse = adresseTextView.getText().toString();
        String plz = plzTextView.getText().toString();
        String ort = ortTextView.getText().toString();

        // Braucht noch eine Methode die eine String in Date umwandelt
        Date vonDatum = new Date();
        Date bisDatum = new Date();
        //----------------------------


        intent.putExtra("name", name);

        if (!name.isEmpty() && !adresse.isEmpty() && !plz.isEmpty() && !ort.isEmpty() && !vonDatum.equals(null) && !bisDatum.equals(null)) {
            if (verleihsystem.createItem(verleihsystem.getActiveUser(), name, adresse, plz, ort, vonDatum, bisDatum, Kategorie.GEGENSTAND)) {
                Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
                startActivity(intent);
            }
        } else {
            Toast message = Toast.makeText(getApplicationContext(), "Bitte alle Daten eingeben!", Toast.LENGTH_SHORT);

            message.show();
        }


    }
}
