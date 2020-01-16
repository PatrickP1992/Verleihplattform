package at.patrick.petzmann.verleihplattform.MenuViews.MyAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import at.patrick.petzmann.verleihplattform.Klassen.System.Item;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccountActivity;
import at.patrick.petzmann.verleihplattform.R;

public class MeinItemVerwaltenActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    public Item toShow;
    TextView name;
    TextView adresse;
    TextView plz;
    TextView ort;
    TextView von;
    TextView bis;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mein_item_verwalten);


        Toast message;

        name = findViewById(R.id.textViewMeinItemName);
        adresse = findViewById(R.id.textViewMeinItemAdresse);
        plz = findViewById(R.id.textViewMeinItemPlz);
        ort = findViewById(R.id.textViewMeinItemOrt);
        von = findViewById(R.id.textViewMeinItemVon);
        bis = findViewById(R.id.textViewMeinItemBis);

        Bundle myBundle = getIntent().getExtras();
        if (myBundle!=null)
        {
            i = myBundle.getInt("itemId");
            String s = Integer.toString(i);
            message = Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);
            message.show();

            toShow = verleihsystem.returnItemById(i);
            showItem();
        }
    }



    public void showItem()
    {
        name.setText(toShow.getName());
        adresse.setText(toShow.getAdresse());
        plz.setText(toShow.getPlz());
        ort.setText(toShow.getOrt());
    }


    public void loeschenItem(View view){

        if (verleihsystem.itemLoeschen(i))

        {


            Toast message2 = Toast.makeText(getApplicationContext(), "Posting wurde gelöscht", Toast.LENGTH_SHORT);
            message2.show();


            Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert

            Intent intent = new Intent(this, MyAccountActivity.class);
            startActivity(intent);
        }
        }
}
