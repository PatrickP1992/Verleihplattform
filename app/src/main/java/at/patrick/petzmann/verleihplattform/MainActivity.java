package at.patrick.petzmann.verleihplattform;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import at.patrick.petzmann.verleihplattform.Klassen.Dienstleistung;
import at.patrick.petzmann.verleihplattform.Klassen.Gegenstand;
import at.patrick.petzmann.verleihplattform.Klassen.ItemFactory;
import at.patrick.petzmann.verleihplattform.Klassen.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.ObjectSerializer;
import at.patrick.petzmann.verleihplattform.Klassen.User;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

public class MainActivity extends AppCompatActivity {

    // Variable für Verleihsystem wird angelegt
    public Verleihsystem verleihsystem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        demoMode();
    }


    /**
     * Loggt User in System ein
     * @param view
     */
    public void login(View view)
    {
        Intent intent = new Intent(this, VerleihenAusleihenActivity.class);

        EditText benutzernameEditText = findViewById(R.id.editText_Benutzername);
        EditText passwortEditText = findViewById(R.id.editText_Passswort);

        String benutzername = benutzernameEditText.getText().toString();
        String passwort = passwortEditText.getText().toString();

        if (verleihsystem.login(benutzername,passwort))
        {
            Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert
            startActivity(intent);
        }
        else
        {
            Toast message = Toast.makeText(getApplicationContext(),"Benutzername oder Passwort falsch!", Toast.LENGTH_SHORT);
            message.show();
        }
    }

    /**
     * Verlinkt das Registrieren Menü und arbeitet damit
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.registermenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.register:
                Toast.makeText(this, "Account registrieren ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            default:  return super.onOptionsItemSelected(item);
        }
    }


    /**
     * Erstellt ein Verleihsystem mit vordefinierten Daten
     */
    public void demoMode()
    {
        User patrick   = new User(0,  "Patrick",   "1234");
        User stefan    = new User(1,  "Stefan",    "1234");
        User emanuel   = new User(2,  "Emanuel",   "1234");
        User christian = new User(3,  "Christian", "1234");
        User quick     = new User(4,  " ",         " ");

        ArrayList<User> users = new ArrayList<>();
        users.add(patrick);
        users.add(stefan);
        users.add(emanuel);
        users.add(christian);
        users.add(quick);

        ArrayList<Dienstleistung> dienstleistungen = new ArrayList<>();

        ArrayList<Gegenstand> gegenstaende = new ArrayList<>();

        ItemFactory itemFactory = new ItemFactory();

        if (Verleihsystem.getVerleihsystem()==null)
        {
            Verleihsystem.setVerleihsystem(new Verleihsystem(users,gegenstaende,dienstleistungen,itemFactory));
        }

        //verleihsystem.setActiveUser(patrick);
        verleihsystem = Verleihsystem.getVerleihsystem();

        //----Dienstleistungen hinzufügen----------------------------------------------------------------------
        verleihsystem.createItem(patrick,"Nachhilfe in Mathe","UNI","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
        verleihsystem.createItem(patrick,"Name","Adresse","plz","Ort",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);


        //----Gegenstände hinzufügen----------------------------------------------------------------------------
        verleihsystem.createItem(patrick,"Taschenrechner","Uni","9020","KLagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name1","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name2","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name3","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name4","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name5","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name6","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name7","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name8","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name9","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);
        verleihsystem.createItem(patrick,"Name10","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND);

        //verleihsystem.getActiveUser().getGelieheneItems().add(verleihsystem.getItemFactory().createItem(patrick,"Beispiel","Adresse","plz","Ort",new Date(),new Date(), Kategorie.GEGENSTAND));

    }
}
