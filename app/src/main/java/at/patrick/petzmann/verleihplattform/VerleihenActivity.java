package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VerleihenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleihen);
    }

    /**
     * Wechselt zu VerleihGegenstand
     * @param view
     */
    public void vGegenstand(View view){
        Intent intent = new Intent(this, VerleihGegenstand.class);
        startActivity(intent);
    }


    /**
     * Wechselt zu VerleihDienstleistungActivity
     * @param view
     */
    public void vDienstleistung(View view){
        Intent intent2 = new Intent(this, VerleihDienstleistungActivity.class);
        startActivity(intent2);
    }
}
