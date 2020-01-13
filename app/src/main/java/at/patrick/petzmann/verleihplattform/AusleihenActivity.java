package at.patrick.petzmann.verleihplattform;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import at.patrick.petzmann.verleihplattform.MenuViews.AGBsActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.MyAccountActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.NachrichtenActivity;
import at.patrick.petzmann.verleihplattform.MenuViews.impressumActivity;

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

    /**
     * Verlinkt das Hauptmenü und arbeitet damit
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch(item.getItemId()){
            case R.id.myaccount:
                intent = new Intent(this, MyAccountActivity.class);
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
}
