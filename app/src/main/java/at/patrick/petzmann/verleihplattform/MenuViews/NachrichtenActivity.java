package at.patrick.petzmann.verleihplattform.MenuViews;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import at.patrick.petzmann.verleihplattform.R;

public class NachrichtenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nachrichten);
    }

    /**
     * Verlinkt das Nachrichten-Menü und arbeitet damit
     * @param menu
     * @return
     */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.messagemenu, menu);
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
