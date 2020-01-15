package at.patrick.petzmann.verleihplattform;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import at.patrick.petzmann.verleihplattform.Klassen.Item;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

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
        this.verleihsystem.itemAusleihen(toShow);
        Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
    }
}
