package at.patrick.petzmann.verleihplattform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import at.patrick.petzmann.verleihplattform.Klassen.ItemAdapter;
import at.patrick.petzmann.verleihplattform.Klassen.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

public class AusleihenGegenstandActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    public ListView myListView;
    public TextView filterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausleihen_gegenstand);

        filterText = findViewById(R.id.ausleihenGegenstandTextView);

        verleihsystem.setCurrentFilter(filterText,verleihsystem.getActiveUser(),  Kategorie.GEGENSTAND);

        myListView = findViewById(R.id.listViewGegenstand);
        final ItemAdapter myAdapter = new ItemAdapter(this,verleihsystem.getFilterReturnItemId(),verleihsystem.getFilterReturnNames(),verleihsystem.getFilterReturnPictureRes());
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(AusleihenGegenstandActivity.this,WillAusleihenActivity.class);
                int[]ids = verleihsystem.getFilterReturnItemId();
                myIntent.putExtra("itemId", ids[position]);
                Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
                startActivity(myIntent);
            }
        });
    }
}
