package com.example.rezervacijafudbalskihtermina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class RezervacijaTermina extends AppCompatActivity implements View.OnClickListener{
    DatabaseHelper db;
    EditText opisT, vt, ki;
    Button homeDugme, rezDugme, logDugme, mojeRezDugme, dodajRezervaciju;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervacija_termina);

        db = new DatabaseHelper(this);
        opisT = (EditText) findViewById(R.id.opisT);
        vt = (EditText) findViewById(R.id.vt);
        ki = (EditText) findViewById(R.id.ki);
        dodajRezervaciju = (Button) findViewById(R.id.dodajRezervaciju);
        dodajRezervaciju.setOnClickListener(this);
        homeDugme = (Button) findViewById(R.id.pocetnaStranicaDugme);
        homeDugme.setOnClickListener(this);
        rezDugme = (Button) findViewById(R.id.rezervacijaT);
        rezDugme.setOnClickListener(this);
        logDugme = (Button) findViewById(R.id.loginT);
        logDugme.setOnClickListener(this);
        mojeRezDugme = (Button) findViewById(R.id.mojeRezervacijeT);
        mojeRezDugme.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pocetnaStranicaDugme:
                startActivity(new Intent(this, MainActivity.class));
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
            case R.id.dodajRezervaciju:
                String r1 = opisT.getText().toString();
                String r2 = vt.getText().toString();
                String r3 = ki.getText().toString();

                if (r1.equals("") || r2.equals("") || r3.equals("")) {

                    Toast.makeText(getApplicationContext(), "Nisu unesena sva polja neophodna za rezervaciju.", Toast.LENGTH_SHORT).show();


                } else {
                    Boolean proveriVrijeme = db.provjeriVrijeme(r2);
                    if(proveriVrijeme==true){

                        Boolean dodajRez = db.napraviRezervaciju(r1,r2,r3);
                        if(dodajRez==true){
                            Toast.makeText(this,"Uspjesno ste dodali termin.",Toast.LENGTH_SHORT).show();

                        }


                    }
                    else {
                        Toast.makeText(this,"Termin je vec zauzet", Toast.LENGTH_SHORT).show();

                    }

                }



                break;

            default:


                break;
        }
    }
}
