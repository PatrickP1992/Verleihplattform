package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Date;

import at.patrick.petzmann.verleihplattform.Klassen.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.Methods;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

public class VerleihDienstleistungActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();

    private static final String[] DIENSTL = new String[]{
            "Haare schneiden", "Rasen mähen", "Garten umgraben", "Fenster putzen", "Grundreinigung für Gebäude"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleih_dienstleistung);

        AutoCompleteTextView editText = findViewById(R.id.VerleihDienstleistungTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DIENSTL);
        editText.setAdapter(adapter);
    }

    /**
     * Erstellt ein Angebot
     *
     * @param view
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void angebotErstellt(View view) {
        Intent intent = new Intent(this, AngebotErstelltActivity.class);
        TextView nameTextView = findViewById(R.id.VerleihDienstleistungTextView);
        TextView adresseTextView = findViewById(R.id.editText_AdresseVDienst);
        TextView plzTextView = findViewById(R.id.editText_PLZVDienst);
        TextView ortTextView = findViewById(R.id.VDienstOrtAutoTextView);
        TextView vonDatumTextView = findViewById(R.id.editText_VDienstDatumVon);
        TextView bisDatumTextView = findViewById(R.id.editText_VDienstDatumBis);

        String name = nameTextView.getText().toString();
        String adresse = adresseTextView.getText().toString();
        String plz = plzTextView.getText().toString();
        String ort = ortTextView.getText().toString();

        // Braucht noch eine Methode die eine String in Date umwandelt
        String vonDatumString = vonDatumTextView.getText().toString();
        String bisDatumString = bisDatumTextView.getText().toString();

        Date vonDatum = new Date();
        Date bisDatum = new Date();

        boolean dateIsTrue;

        if (Methods.matches(vonDatumString) && Methods.matches(bisDatumString)) {
            dateIsTrue = true;
            try {
                vonDatum = Methods.toDateFormat(vonDatumString);
                bisDatum = Methods.toDateFormat(bisDatumString);
            } catch (ParseException e) {
                dateIsTrue = false;
            }
        } else dateIsTrue = false;

        boolean rightDate = (vonDatum.getTime() >= Methods.dateToday().getTime() && vonDatum.getTime() < bisDatum.getTime());

        intent.putExtra("name", name);
        if (!name.isEmpty() && !adresse.isEmpty() && !plz.isEmpty() && !ort.isEmpty() && dateIsTrue && rightDate) {
            if (verleihsystem.createItem(verleihsystem.getActiveUser(), name, adresse, plz, ort, vonDatum, bisDatum, Kategorie.DIENSTLEISTUNG)) {
                Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
                startActivity(intent);
            }
        } else if (!rightDate) {
            Toast message = Toast.makeText(getApplicationContext(), "Korrektes Datum eingeben!", Toast.LENGTH_SHORT);
            message.show();
        } else if (!dateIsTrue) {
            Toast message = Toast.makeText(getApplicationContext(), "Korrektes Datumsformat zB. 01.01.2020 eingeben!", Toast.LENGTH_SHORT);
            message.show();
        } else {
            Toast message = Toast.makeText(getApplicationContext(), "Bitte alle Daten eingeben!", Toast.LENGTH_SHORT);
            message.show();
        }


    }
}
