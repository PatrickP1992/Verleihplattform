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

    /**
     * wechselt zu AusleihenActivity
     * @param view
     */
    public void ausleihen(View view)
    {
        Intent intent = new Intent(this, AusleihenActivity.class);
        startActivity(intent);
    }


    /**
     * wechselt zu VerleihenActivity
     * @param view
     */
    public void verleihen(View view)
    {
        Intent intent = new Intent(this, VerleihenActivity.class);
        startActivity(intent);
    }
}
