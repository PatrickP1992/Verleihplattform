package at.patrick.petzmann.verleihplattform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;
public class VerleihenAusleihenActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleihen_ausleihen);

    }

    public void ausleihen(View view)
    {
        Intent intent = new Intent(this, AusleihenActivity.class);

        //Toast message = Toast.makeText(getApplicationContext(),verleihsystem.getActiveUser().getUserName(), Toast.LENGTH_SHORT);
        //message.show();

        startActivity(intent);
    }



    public void verleihen(View view)
    {
        Intent intent = new Intent(this, VerleihenActivity.class);

        startActivity(intent);
    }
}
