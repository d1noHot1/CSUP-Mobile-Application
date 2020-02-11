package com.example.rezervacijafudbalskihtermina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LoggedIn extends AppCompatActivity implements View.OnClickListener {

    Button dugmekuci, dugmeodjava;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        session = new Session(this);
        if(!session.loggedIn()){
            logout();

        }
        dugmekuci = (Button) findViewById(R.id.povratakkuci);
        dugmekuci.setOnClickListener(this);
        dugmeodjava = (Button) findViewById(R.id.logout);
        dugmeodjava.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.povratakkuci:
                startActivity(new Intent(this, MainActivity.class));

                break;
            case R.id.logout:

                logout();

                break;

            default:

                break;
        }

    }

    private void logout(){

        session.setLoggedIn(false);
        startActivity(new Intent(this, Login.class));

    }
}
