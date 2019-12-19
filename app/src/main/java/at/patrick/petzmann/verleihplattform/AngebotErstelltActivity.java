package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AngebotErstelltActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_erstellt);
    }

    public void backToHome(View view)
    {
        Intent intent = new Intent(this, VerleihenAusleihenActivity.class);

        startActivity(intent);
    }
}
