package at.patrick.petzmann.verleihplattform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class VerleihenAusleihenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleihen_ausleihen);
    }

    public void ausleihen(View view)
    {
        Intent intent = new Intent(this, AusleihenActivity.class);

        startActivity(intent);
    }





    public void verleihen(View view)
    {
        Intent intent = new Intent(this, VerleihenActivity.class);

        startActivity(intent);
    }
}
