package at.patrick.petzmann.verleihplattform.MenuViews;

import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import at.patrick.petzmann.verleihplattform.Klassen.System.User;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MainActivity;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.VerleihenAusleihenActivity;

public class registerActivity extends AppCompatActivity {
    Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }

    //muss noch als Benutzer gespeichert werden!

    /**
     * Erstellt einen neuen Benutzer
     * @param view
     */
    public void accountRegistriert(View view){
        Intent intent = new Intent(this, MainActivity.class);
        TextView vornameTextView = findViewById(R.id.vorname_editText);
        TextView nachnameTextView = findViewById(R.id.nachname_editText);
        TextView usernameTextView = findViewById(R.id.username_editText);
        TextView adresseTextView = findViewById(R.id.adresse_editText);
        TextView plzTextView = findViewById(R.id.plz_editText);
        TextView ortTextView = findViewById(R.id.ort_editText);
        TextView passwortTextView = findViewById(R.id.password_editText);
        TextView passwort2Textview = findViewById(R.id.password2_editText);

        String username = usernameTextView.toString();
        String password = passwortTextView.toString();
        String passwordMatches = passwort2Textview.toString();



        if (!username.isEmpty() && password.matches(passwordMatches)){

            startActivity(intent);
        }

    }
}
