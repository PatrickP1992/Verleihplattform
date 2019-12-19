package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class VerleihGegenstand extends AppCompatActivity {
    private static final String[] ITEMS = new String[]{
            "Fahrrad","Mixer","Rasenmäher","Kettensäge","Staubsauger"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleih_gegenstand);

        AutoCompleteTextView editText = findViewById(R.id.VerleihGegenstandTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ITEMS);
        editText.setAdapter(adapter);//
    }

    public void angebotErstellt(View view)
    {
        Intent intent = new Intent(this, AngebotErstelltActivity.class);

        startActivity(intent);
    }
}
