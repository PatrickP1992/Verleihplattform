package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VerleihDienstleistungActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleih_dienstleistung);
    }

    public void angebotErstellt(View view)
    {
        Intent intent = new Intent(this, AngebotErstelltActivity.class);

        startActivity(intent);
    }
}
