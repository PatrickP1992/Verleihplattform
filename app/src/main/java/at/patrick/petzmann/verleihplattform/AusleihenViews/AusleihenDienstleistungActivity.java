package at.patrick.petzmann.verleihplattform.AusleihenViews;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import at.patrick.petzmann.verleihplattform.Klassen.Other.ItemAdapter;
import at.patrick.petzmann.verleihplattform.Klassen.System.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MenuViews.AGBsActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccountActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.NachrichtenActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.impressumActivity;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.VerleihenAusleihenActivity;

public class AusleihenDienstleistungActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    public ListView myListView;
    public TextView filterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausleihen_dienstleistung);

        filterText = findViewById(R.id.ausleihenDienstleistungTextView);

        verleihsystem.setCurrentFilterAusleihen(filterText, verleihsystem.getActiveUser(), Kategorie.DIENSTLEISTUNG);

        // Wird nur ausgeführt wenn etwas gefunden wurde
        if (verleihsystem.getFilterReturnItemId().length != 0) {
            myListView = findViewById(R.id.listViewDienstleistungen);
            final ItemAdapter myAdapter = new ItemAdapter(this, verleihsystem.getFilterReturnItemId(), verleihsystem.getFilterReturnNames(), verleihsystem.getFilterReturnPictureRes());
            myListView.setAdapter(myAdapter);

            myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent myIntent = new Intent(AusleihenDienstleistungActivity.this, WillAusleihenActivity.class);
                    int[] ids = verleihsystem.getFilterReturnItemId();
                    myIntent.putExtra("itemId", ids[position]);
                    Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
                    startActivity(myIntent);
                }
            });
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
        switch (item.getItemId()) {
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
                intent = new Intent(this, impressumActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
