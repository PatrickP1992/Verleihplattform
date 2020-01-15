package at.patrick.petzmann.verleihplattform.VerleihenViews;

import android.content.Intent;
import android.os.Build;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Date;

import at.patrick.petzmann.verleihplattform.Klassen.System.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.Other.Methods;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MenuViews.AGBsActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccountActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.NachrichtenActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.impressumActivity;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.VerleihenAusleihenActivity;

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

        /**
         * Wenn alle Eingaben passen, speichert das Programm das Angebot
         * Abfragen nach Datum und ob Textfelder leer sind
         */

        String vonDatumString = vonDatumTextView.getText().toString();
        String bisDatumString = bisDatumTextView.getText().toString();
        boolean dateIsTrue;

        Date vonDatum = new Date();
        Date bisDatum = new Date();

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
        } else if (name.isEmpty() || adresse.isEmpty() || plz.isEmpty() || ort.isEmpty() || vonDatumString.isEmpty() || bisDatumString.isEmpty()) {
            Toast message = Toast.makeText(getApplicationContext(), "Bitte alle Daten eingeben!", Toast.LENGTH_SHORT);
            message.show();
        } else if (!dateIsTrue) {
            Toast message = Toast.makeText(getApplicationContext(), "Korrektes Datumsformat zB. 01.01.2020 eingeben!", Toast.LENGTH_SHORT);
            message.show();
        } else if (!rightDate) {
            Toast message = Toast.makeText(getApplicationContext(), "Korrektes Datum eingeben!", Toast.LENGTH_SHORT);
            message.show();
        } else {
            Toast message = Toast.makeText(getApplicationContext(), "Bitte alle Daten eingeben!", Toast.LENGTH_SHORT);
            message.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId()){
            case R.id.home:
                intent = new Intent(this, VerleihenAusleihenActivity.class);
                startActivity(intent);
                return true;

            case R.id.myaccount:
                intent = new Intent(this, MyAccountActivity.class);
                startActivity(intent);
                return true;

            case R.id.messages:
                intent = new Intent(this, NachrichtenActivity.class);
                startActivity(intent);
                return true;

            case R.id.AGB:
                intent = new Intent(this, AGBsActivity.class);
                startActivity(intent);
                return true;

            case R.id.impressum:
                intent = new Intent(this , impressumActivity.class);
                startActivity(intent);
                return true;

            default:  return super.onOptionsItemSelected(item);
        }
    }
}
