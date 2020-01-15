package at.patrick.petzmann.verleihplattform.MenuViews;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import at.patrick.petzmann.verleihplattform.AusleihenDienstleistungActivity;
import at.patrick.petzmann.verleihplattform.Klassen.ItemAdapter;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.WillAusleihenActivity;

public class MyAccountActivity extends AppCompatActivity {

    ListView myListView;
    Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);

        myListView = findViewById(R.id.listViewAusgeliehen);
        final ItemAdapter myAdapter = new ItemAdapter(this, this.verleihsystem.getActiveUser().getIdNumber(),verleihsystem.getActiveUser().getItemName(),verleihsystem.getActiveUser().getPictureCode());
        myListView.setAdapter(myAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int[]ids = verleihsystem.getFilterReturnItemId();
                Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
            }
        });
    }

    /**
     * Verlinkt das Accountmenü und arbeitet damit
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
        switch(item.getItemId()){
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
