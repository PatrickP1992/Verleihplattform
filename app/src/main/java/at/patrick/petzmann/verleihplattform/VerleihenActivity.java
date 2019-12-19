package at.patrick.petzmann.verleihplattform;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VerleihenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verleihen);
    }

    public void vGegenstand(View view){
        Intent intent = new Intent(this, VerleihGegenstand.class);
        startActivity(intent);
    }



    public void vDienstleistung(View view){
        Intent intent2 = new Intent(this, VerleihDienstleistungActivity.class);
        startActivity(intent2);
    }
}
