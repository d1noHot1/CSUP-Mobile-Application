package com.example.rezervacijafudbalskihtermina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button homeDugme, rezDugme, logDugme, mojeRezDugme;
    ImageView slika;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeDugme = (Button) findViewById(R.id.pocetnaStranicaDugme);
        homeDugme.setOnClickListener(this);
        rezDugme = (Button) findViewById(R.id.rezervacijaT);
        rezDugme.setOnClickListener(this);
        logDugme = (Button) findViewById(R.id.loginT);
        logDugme.setOnClickListener(this);
        mojeRezDugme = (Button) findViewById(R.id.mojeRezervacijeT);
        mojeRezDugme.setOnClickListener(this);
        slika = (ImageView) findViewById(R.id.slika);
        slika.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pocetnaStranicaDugme:
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this,"RADI RADI RADI",Toast.LENGTH_SHORT).show();
                break;

            case R.id.rezervacijaT:
                startActivity(new Intent(this, RezervacijaTermina.class));

                break;
            case R.id.loginT:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.mojeRezervacijeT:
                startActivity(new Intent(this, MojeRezervacije.class));

                break;
            case R.id.slika:
                startActivity(new Intent(this, Galerija.class));
                break;
            default:
                break;
        }
    }
}
