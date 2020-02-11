package com.example.rezervacijafudbalskihtermina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MojeRezervacije extends AppCompatActivity implements View.OnClickListener{
    Button homeDugme, rezDugme, logDugme, mojeRezDugme, dugmeDelete;
    DatabaseHelper db;
    TextView tekstvju;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moje_rezervacije);


        db = new DatabaseHelper(this);
        dugmeDelete = (Button) findViewById(R.id.dugmedelete);
        dugmeDelete.setOnClickListener(this);
        homeDugme = (Button) findViewById(R.id.pocetnaStranicaDugme);
        homeDugme.setOnClickListener(this);
        rezDugme = (Button) findViewById(R.id.rezervacijaT);
        rezDugme.setOnClickListener(this);
        logDugme = (Button) findViewById(R.id.loginT);
        logDugme.setOnClickListener(this);
        mojeRezDugme = (Button) findViewById(R.id.mojeRezervacijeT);
        mojeRezDugme.setOnClickListener(this);
        db = new DatabaseHelper(this);
        Cursor cursor = db.alldata();
        tekstvju = (TextView) findViewById(R.id.tekstvju);

        if(cursor.getCount()==0){

            tekstvju.setText("Trenutno nemate rezervacija.");

        }
        else{
            while (cursor.moveToNext()){

                tekstvju.append("Opis: " + cursor.getString(0) +" ");
                tekstvju.append("Vrijeme: " + cursor.getString(1) + " ");
                tekstvju.append("Korisnik: " + cursor.getString(2)+" ");
                tekstvju.append("                                         ");



            }

        }


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

            case R.id.dugmedelete:

                db.deleteAll();
                Toast.makeText(getApplicationContext(),"Uspjesno ste uklonili termine. Osvjezite stranicu.",Toast.LENGTH_LONG).show();

                break;
            default:
                break;
        }
    }
}
