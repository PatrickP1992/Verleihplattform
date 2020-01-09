package at.patrick.petzmann.verleihplattform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;

public class WillAusleihenActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_will_ausleihen);

        Toast message;

        Bundle myBundle = getIntent().getExtras();
        if (myBundle!=null)
        {
            int i = myBundle.getInt("itemId");
            String s = Integer.toString(i);
            message = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
            message.show();
        }


    }
}
