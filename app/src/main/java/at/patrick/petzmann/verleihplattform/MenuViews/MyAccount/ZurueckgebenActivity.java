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

public class ZurueckgebenActivity extends AppCompatActivity {
    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    public Item toShow;
    TextView name;
    TextView adresse;
    TextView plz;
    TextView ort;
    TextView von;
    TextView bis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zurueckgeben);



        Toast message;

        name = findViewById(R.id.textViewZurueckgebenName);
        adresse = findViewById(R.id.textViewZurueckgebenAdresse);
        plz = findViewById(R.id.textViewZurueckgebenPlz);
        ort = findViewById(R.id.textViewZurueckgebenOrt);
        von = findViewById(R.id.textViewZurueckgebenVon);
        bis = findViewById(R.id.textViewZurueckgebenBis);

        Bundle myBundle = getIntent().getExtras();
        if (myBundle!=null)
        {
            int i = myBundle.getInt("itemId");
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




    public void zurueckgebenItem(View view){

        if (verleihsystem.geliehenesItemZurückgeben(toShow))

        {

            Toast message2 = Toast.makeText(getApplicationContext(), "wurd zurückgegeben", Toast.LENGTH_SHORT);
            message2.show();


            Verleihsystem.setVerleihsystem(verleihsystem); // verleihsystem wird gespeichert

            Intent intent = new Intent(this, MyAccountActivity.class);
            startActivity(intent);
        }
    }
}
