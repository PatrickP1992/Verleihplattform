package at.patrick.petzmann.verleihplattform;

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

import at.patrick.petzmann.verleihplattform.Klassen.Dienstleistung;
import at.patrick.petzmann.verleihplattform.Klassen.Gegenstand;
import at.patrick.petzmann.verleihplattform.Klassen.ItemFactory;
import at.patrick.petzmann.verleihplattform.Klassen.ObjectSerializer;
import at.patrick.petzmann.verleihplattform.Klassen.User;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

public class MainActivity extends AppCompatActivity {


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


    public void demoMode()
    {
        User patrick   = new User(0,  "Patrick",   "1234");
        User stefan    = new User(1,  "Stefan",    "1234");
        User emanuel   = new User(2,  "Emanuel",   "1234");
        User christian = new User(3,  "Christian", "1234");

        ArrayList<User> users = new ArrayList<>();
        users.add(patrick);
        users.add(stefan);
        users.add(emanuel);
        users.add(christian);

        ArrayList<Dienstleistung> dienstleistungen = new ArrayList<>();
        ArrayList<Gegenstand> gegenstaende = new ArrayList<>();

        ItemFactory itemFactory = new ItemFactory();

        if (Verleihsystem.getVerleihsystem()==null)
        {
            Verleihsystem.setVerleihsystem(new Verleihsystem(users,gegenstaende,dienstleistungen,itemFactory));
        }

        verleihsystem = Verleihsystem.getVerleihsystem();
    }
}
