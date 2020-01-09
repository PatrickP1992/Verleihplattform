package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AngebotErstelltActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_angebot_erstellt);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        TextView erstellt = findViewById(R.id.textView_AngebotErstellt);

        if (b != null) {
            String name = (String) b.get("name");
            erstellt.setText("Das Angebot zu " + name + " wurde erstellt");
        }
    }

    public void backToHome(View view) {
        Intent intent = new Intent(this, VerleihenAusleihenActivity.class);

        startActivity(intent);
    }
}
