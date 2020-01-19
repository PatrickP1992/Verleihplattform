package at.patrick.petzmann.verleihplattform;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import at.patrick.petzmann.verleihplattform.Klassen.System.Dienstleistung;
import at.patrick.petzmann.verleihplattform.Klassen.System.Gegenstand;
import at.patrick.petzmann.verleihplattform.Klassen.Other.ItemFactory;
import at.patrick.petzmann.verleihplattform.Klassen.System.Kategorie;
import at.patrick.petzmann.verleihplattform.Klassen.System.User;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccountActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.registerActivity;

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
        Intent intent;
        switch(item.getItemId()){
            case R.id.register:
                intent = new Intent(this, registerActivity.class);
                startActivity(intent);
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
            verleihsystem = Verleihsystem.getVerleihsystem();


            //----Dienstleistungen hinzufügen----------------------------------------------------------------------
            verleihsystem.createItem(patrick,"Nachhilfe in Mathe","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
            verleihsystem.createItem(patrick,"Babysitten","Klagenfurt","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
            verleihsystem.createItem(emanuel,"Nachhilfe in Informatik","Wölzing 95","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
            verleihsystem.createItem(stefan,"Haare schneiden","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
            verleihsystem.createItem(christian,"Nachhilfe in Deutsch","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
            verleihsystem.createItem(stefan,"Nachhilfe in Buchhaltung","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
            verleihsystem.createItem(emanuel,"Umzugshilfe","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);
            verleihsystem.createItem(emanuel,"Nachhilfe in Mathe","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.DIENSTLEISTUNG);


            //----Gegenstände hinzufügen----------------------------------------------------------------------------
            verleihsystem.createItem(patrick,"Taschenrechner","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(patrick,"Bleistift","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(patrick,"Kugelschreiber","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(stefan,"Hammer","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(stefan,"Bohrmaschine","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(stefan,"Lineal","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(emanuel,"Geodreieck","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(emanuel,"Zirkel","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(emanuel,"Kugelschreiber","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(christian,"Radiergummi","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);
            verleihsystem.createItem(christian,"Fahrrad","Klagenfurt Uni","9020","Klagenfurt",new Date(),new Date(), Kategorie.GEGENSTAND);



        }


        verleihsystem = Verleihsystem.getVerleihsystem();



    }
}
