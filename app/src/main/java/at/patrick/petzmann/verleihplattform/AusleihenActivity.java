package at.patrick.petzmann.verleihplattform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AusleihenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ausleihen);
    }

    /**
     * Wechselt zu AusleihenGegenstandActivity
     * @param view
     */
    public void aGegenstand(View view){
        Intent intent = new Intent(this, AusleihenGegenstandActivity.class);
        startActivity(intent);
    }


    /**
     * Wechselt zu AusleihenDienstleistungActivity
     * @param view
     */
    public void aDienstleistung(View view){
        Intent intent2 = new Intent(this, AusleihenDienstleistungActivity.class);
        startActivity(intent2);
    }
}
