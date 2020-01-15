package at.patrick.petzmann.verleihplattform.AusleihenViews;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import at.patrick.petzmann.verleihplattform.Klassen.System.Item;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MenuViews.AGBsActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccountActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.NachrichtenActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.impressumActivity;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.VerleihenAusleihenActivity;

public class WillAusleihenActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    public Item toShow;
    TextView name;
    TextView adresse;
    TextView plz;
    TextView ort;
    TextView von;
    TextView bis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_will_ausleihen);
        Toast message;

        name = findViewById(R.id.textViewWillAusleihenName);
        adresse = findViewById(R.id.TextViewWillAusleihenAdresse);
        plz = findViewById(R.id.textViewWillAusleihenPlz);
        ort = findViewById(R.id.textViewWillAusleihenOrt);
        von = findViewById(R.id.textViewWillAusleihenVon);
        bis = findViewById(R.id.textViewWillAusleihenBis);

        Bundle myBundle = getIntent().getExtras();
        if (myBundle!=null)
        {
            int i = myBundle.getInt("itemId");
            String s = Integer.toString(i);
            message = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
            message.show();

            toShow = verleihsystem.returnItemById(i);
            showItem();
        }

    }

    public void showItem()
    {
        name.setText(toShow.getName());
        adresse.setText(toShow.getAdresse());
        plz.setText(toShow.getPlz());
        ort.setText(toShow.getOrt());
    }

    public void ausleihenItem(View view){

        if (verleihsystem.itemAusleihen(toShow))

        {
            // Punkte werden um 5 erhöht
            verleihsystem.getActiveUser().setPointsPlus5();

            Toast message2 = Toast.makeText(getApplicationContext(), "Anfrage erstellt und Punkte wurden erhöht", Toast.LENGTH_SHORT);
            message2.show();

        }




        Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert

        Intent intent = new Intent(this, VerleihenAusleihenActivity.class);
        startActivity(intent);
    }

    /**
     * Verlinkt das Home-menü und arbeitet damit
     * @param menu
     * @return
     */

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
