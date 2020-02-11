package com.example.rezervacijafudbalskihtermina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class Galerija extends AppCompatActivity implements View.OnClickListener {

    ImageView back_strelica, iv_background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galerija);

        back_strelica = (ImageView) findViewById(R.id.back_strelica);
        back_strelica.setOnClickListener(this);
        iv_background = (ImageView) findViewById(R.id.iv_background);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv_background.getDrawable();
        animationDrawable.start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_strelica:
                startActivity(new Intent(this, MainActivity.class));
                break;

            default:
                break;
        }
    }
}
