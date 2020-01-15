package at.patrick.petzmann.verleihplattform.MenuViews.MyAccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import at.patrick.petzmann.verleihplattform.AusleihenViews.AusleihenDienstleistungActivity;
import at.patrick.petzmann.verleihplattform.AusleihenViews.WillAusleihenActivity;
import at.patrick.petzmann.verleihplattform.Klassen.Other.ItemAdapter;
import at.patrick.petzmann.verleihplattform.Klassen.System.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MenuViews.AGBsActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.NachrichtenActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.impressumActivity;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.VerleihenAusleihenActivity;

public class VonMirAusgeliehenActivity extends AppCompatActivity {


    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    public ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_von_mir_ausgeliehen);


        verleihsystem.setCurrentFilterAusgeliehenVonMir();

        // Wird nur ausgeführt wenn etwas gefunden wurde
        if (verleihsystem.getFilterReturnItemId().length != 0)
        {
            myListView = findViewById(R.id.listVonMirAusgeliehen);
            final ItemAdapter myAdapter = new ItemAdapter(this,verleihsystem.getFilterReturnItemId(),verleihsystem.getFilterReturnNames(),verleihsystem.getFilterReturnPictureRes());
            myListView.setAdapter(myAdapter);

            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent myIntent = new Intent(VonMirAusgeliehenActivity.this, ZurueckgebenActivity.class);
                    int[]ids = verleihsystem.getFilterReturnItemId();
                    myIntent.putExtra("itemId", ids[position]);
                    Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
                    startActivity(myIntent);
                }
            });
        }
    }


    /**
     * Verlinkt das Accountmenü und arbeitet damit
     *
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.accountmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.home:
                intent = new Intent(this, VerleihenAusleihenActivity.class);
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
                intent = new Intent(this, impressumActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
