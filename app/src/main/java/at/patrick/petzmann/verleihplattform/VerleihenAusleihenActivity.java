package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import at.patrick.petzmann.verleihplattform.Klassen.Verleihsystem;
public class VerleihenAusleihenActivity extends AppCompatActivity {

    public Verleihsystem verleihsystem = Verleihsystem.getVerleihsystem();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleihen_ausleihen);

    }

    /**
     * Erstellt ein Menü und arbeitet damit
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
        switch(item.getItemId()){
            case R.id.myaccount:
                Toast.makeText(this, "Account ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.messages:
                Toast.makeText(this, "Nachrichten ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.AGB:
                Toast.makeText(this, "AGBs ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            default:  return super.onOptionsItemSelected(item);
        }


    }

    /**
     * wechselt zu AusleihenActivity
     * @param view
     */
    public void ausleihen(View view)
    {
        Intent intent = new Intent(this, AusleihenActivity.class);
        startActivity(intent);
    }


    /**
     * wechselt zu VerleihenActivity
     * @param view
     */
    public void verleihen(View view)
    {
        Intent intent = new Intent(this, VerleihenActivity.class);
        startActivity(intent);
    }
}
