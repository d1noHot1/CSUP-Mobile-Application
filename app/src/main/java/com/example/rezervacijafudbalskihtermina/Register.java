package com.example.rezervacijafudbalskihtermina;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends AppCompatActivity implements View.OnClickListener{



    DatabaseHelper db;
    Button homeDugme, rezDugme, logDugme, mojeRezDugme, dugmeReg;
    EditText e1, e2, e3;
    TextView textPrebaciLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        e1 = (EditText) findViewById(R.id.registrujKorisnicko);
        e2 = (EditText) findViewById(R.id.registrujEmail);
        e3 = (EditText) findViewById(R.id.registrujPassword);
        homeDugme = (Button) findViewById(R.id.pocetnaStranicaDugme);
        homeDugme.setOnClickListener(this);
        rezDugme = (Button) findViewById(R.id.rezervacijaT);
        rezDugme.setOnClickListener(this);
        logDugme = (Button) findViewById(R.id.loginT);
        logDugme.setOnClickListener(this);
        mojeRezDugme = (Button) findViewById(R.id.mojeRezervacijeT);
        mojeRezDugme.setOnClickListener(this);
        dugmeReg = (Button) findViewById(R.id.dugmeReg);
        dugmeReg.setOnClickListener(this);
        textPrebaciLogin = (TextView) findViewById(R.id.textPrebaciLogin);
        textPrebaciLogin.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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

            case R.id.dugmeReg:
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();

                if (s1.equals("") || s2.equals("") || s3.equals("")) {

                    Toast.makeText(getApplicationContext(), "Nisu unesena sva polja neophodna za registraciju.", Toast.LENGTH_SHORT).show();


                } else {
                    Boolean provjeriUsername = db.provjeriUsername(s1);
                    if(provjeriUsername==true){

                        Boolean insert = db.insert(s1,s2,s3);
                        if(insert==true){
                            Toast.makeText(this,"Uspjesno ste se registrovali.",Toast.LENGTH_SHORT).show();

                        }


                    }
                    else {
                        Toast.makeText(this,"Korisnicko ime vec postoji", Toast.LENGTH_SHORT).show();

                    }

                }
                break;


            case R.id.textPrebaciLogin:
                startActivity(new Intent(this, Login.class));
                break;
            default:
                break; }

    }





}



