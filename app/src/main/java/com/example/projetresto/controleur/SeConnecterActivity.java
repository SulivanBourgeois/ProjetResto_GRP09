package com.example.projetresto.controleur;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;

public class SeConnecterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        Button btnSignUp = findViewById(R.id.CreerCompte);
        View.OnClickListener ecouteur = new View.OnClickListener() {

            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.CreerCompte:
                        //code correspondant au clic sur le bouton enregistrer
                        Intent intent1 = new Intent(SeConnecterActivity.this, SignInActivity.class);
                        startActivity(intent1);
                        break;
                }

            }
        };
        btnSignUp.setOnClickListener(ecouteur);
    }
}
