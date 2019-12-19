package at.patrick.petzmann.verleihplattform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view)
    {
        Intent intent = new Intent(this, VerleihenAusleihenActivity.class);

        EditText benutzername = findViewById(R.id.editText_Benutzername);
        EditText passwort = findViewById(R.id.editText_Passswort);

        startActivity(intent);

        /*
        if (benutzername.getText().toString().equals("patrick") && passwort.getText().toString().equals("test"))
        {
            startActivity(intent);
        }
        else
        {
            int duration = Toast.LENGTH_LONG;
            Toast popup = Toast.makeText(getApplicationContext(),"Login Daten sind falsch",duration);
            popup.show();
        }

         */
    }
}
