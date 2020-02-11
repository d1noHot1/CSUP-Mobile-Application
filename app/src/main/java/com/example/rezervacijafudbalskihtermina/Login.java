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



public class Login extends AppCompatActivity implements View.OnClickListener{
    DatabaseHelper db;
    Button homeDugme, rezDugme, logDugme, mojeRezDugme, loginujSe;
    EditText logU, logP;
    TextView textPrebaciReg;
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new Session(this);
        logU = (EditText) findViewById(R.id.log1);
        logP = (EditText) findViewById(R.id.log2);
        homeDugme = (Button) findViewById(R.id.pocetnaStranicaDugme);
        homeDugme.setOnClickListener(this);
        rezDugme = (Button) findViewById(R.id.rezervacijaT);
        rezDugme.setOnClickListener(this);
        logDugme = (Button) findViewById(R.id.loginT);
        logDugme.setOnClickListener(this);
        mojeRezDugme = (Button) findViewById(R.id.mojeRezervacijeT);
        mojeRezDugme.setOnClickListener(this);
        loginujSe = (Button) findViewById(R.id.dugmeLog);
        loginujSe.setOnClickListener(this);
        textPrebaciReg = (TextView) findViewById(R.id.textPrebaciReg);
        textPrebaciReg.setOnClickListener(this);
        db = new DatabaseHelper(this);

        if(session.loggedIn()){
            startActivity(new Intent(this, LoggedIn.class));
            finish();
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
            case R.id.dugmeLog:
                String username = logU.getText().toString();
                String password = logP.getText().toString();
                Boolean usernamePassword = db.UsernamePassword(username,password);

                if(usernamePassword==true) {
                    session.setLoggedIn(true);
                    Toast.makeText(getApplicationContext(), "Uspjesno ste se ulogovali", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(this, LoggedIn.class));

                }
                else
                    Toast.makeText(getApplicationContext(),"Pogresno korisnicko ime ili lozinka.",Toast.LENGTH_SHORT).show();
                break;

            case R.id.textPrebaciReg:
                startActivity(new Intent(this, Register.class));
                break;
            default:
                break;
        }


    }}







