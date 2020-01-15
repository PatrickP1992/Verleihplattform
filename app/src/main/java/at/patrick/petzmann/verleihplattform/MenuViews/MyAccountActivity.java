package at.patrick.petzmann.verleihplattform.MenuViews;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import at.patrick.petzmann.verleihplattform.Klassen.Other.ItemAdapter;
import at.patrick.petzmann.verleihplattform.Klassen.System.Verleihsystem;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccount.MeineItemsActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccount.VonMirAusgeliehenActivity;
import at.patrick.petzmann.verleihplattform.R;
import at.patrick.petzmann.verleihplattform.VerleihenAusleihenActivity;

public class MyAccountActivity extends AppCompatActivity {


    Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);


    }

    /**
     * Verlinkt das Accountmenü und arbeitet damit
     * @param menu
     * @return
     */

    @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.accountmenu, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch(item.getItemId()){
                    case R.id.home:
                        intent = new Intent(this, VerleihenAusleihenActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.messages:
                        intent = new Intent(this, NachrichtenActivity.class);
                        startActivity(intent);
                        return true;

                    case R.id.AGB:
                        intent = new Intent(this, AGBsActivity.class);
                        startActivity(intent);
                        return true;

            case R.id.impressum:
                intent = new Intent(this , impressumActivity.class);
                startActivity(intent);
                return true;

            default:  return super.onOptionsItemSelected(item);
        }
    }


    /**
     * wechselt zu MeineItemsActivity
     *
     * @param view
     */
    public void meineItems(View view) {
        Intent intent = new Intent(this, MeineItemsActivity.class);
        startActivity(intent);
    }

    /**
     * wechselt zu VonMirAusgeliehenActivity
     *
     * @param view
     */
    public void vonMirAusgeliehen(View view) {
        Intent intent2 = new Intent(this, VonMirAusgeliehenActivity.class);
        startActivity(intent2);
    }
}
