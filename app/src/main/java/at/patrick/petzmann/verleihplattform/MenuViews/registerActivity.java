package at.patrick.petzmann.verleihplattform.MenuViews;

import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import at.patrick.petzmann.verleihplattform.Klassen.Other.Methods;
import at.patrick.petzmann.verleihplattform.Klassen.System.User;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MainActivity;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.VerleihenAusleihenActivity;

public class registerActivity extends AppCompatActivity {
    //Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    //muss noch als Benutzer gespeichert werden!

    /**
     * Erstellt einen neuen Benutzer
     *
     * @param view
     */
    public void accountRegistriert(View view) {
        //Intent intent = new Intent(this, MainActivity.class);
        TextView vornameTextView = findViewById(R.id.vorname_editText);
        TextView nachnameTextView = findViewById(R.id.nachname_editText);
        TextView usernameTextView = findViewById(R.id.username_editText);
        TextView adresseTextView = findViewById(R.id.adresse_editText);
        TextView plzTextView = findViewById(R.id.plz_editText);
        TextView ortTextView = findViewById(R.id.ort_editText);
        TextView passwortTextView = findViewById(R.id.password_editText);
        TextView passwort2Textview = findViewById(R.id.password2_editText);

        String vorname = vornameTextView.getText().toString();
        String nachname = nachnameTextView.getText().toString();
        String username = usernameTextView.getText().toString();
        String adresse = adresseTextView.getText().toString();
        String plz = plzTextView.getText().toString();
        String ort = ortTextView.getText().toString();
        String password = passwortTextView.getText().toString();
        String passwordMatches = passwort2Textview.getText().toString();

        boolean passwordRegex = Methods.PASSWORD_PATTERN(password);
        boolean everythingEntered = Methods.FILLED_REGISTER(vorname, nachname, username, adresse, plz, ort, password, passwordMatches);


        if (everythingEntered && password.equals(passwordMatches) && passwordRegex) {
            Toast message = Toast.makeText(getApplicationContext(), "Account erfolgreich registriert!", Toast.LENGTH_SHORT);
            message.show();

            //startActivity(intent);
        } else if (!everythingEntered) {
            Toast message = Toast.makeText(getApplicationContext(), "Bitte alle Daten eingeben!", Toast.LENGTH_SHORT);
            message.show();
        } else if (!passwordRegex) {
            Toast message = Toast.makeText(getApplicationContext(), "Passwort soll mindestens 8 Zeichen, 1 Groß/Kleinbuchstaben, 1 Zahl und 1 Sonderzeichen enthalten!", Toast.LENGTH_SHORT);
            message.show();
        } else if (password!=passwordMatches) {
            Toast message = Toast.makeText(getApplicationContext(), "Passwörter stimmen nicht überein!", Toast.LENGTH_SHORT);
            message.show();
        } else {
            Toast message = Toast.makeText(getApplicationContext(), "Sonstiger Fehler", Toast.LENGTH_SHORT);
            message.show();
        }

    }
}
