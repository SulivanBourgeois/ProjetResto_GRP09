package com.example.projetresto.controleur;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOResto;

public class InscriptionActivity extends AppCompatActivity {

        EditText Email, motDePasse;
        Button boutonInscription;
        DAOResto myDatabaseHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_incription);

            Email = findViewById(R.id.editTextEmail);
            motDePasse = findViewById(R.id.editTextMotDePasse);
            boutonInscription = findViewById(R.id.buttonCreer);

            myDatabaseHelper = new DAOResto(this);

            boutonInscription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String nom = Email.getText().toString();
                    String motDePasseTexte = motDePasse.getText().toString();

                    // Vérifier si le nom d'utilisateur est déjà utilisé
                    if (myDatabaseHelper.checkUser(nom)) {
                        Toast.makeText(InscriptionActivity.this, "Ce nom d'utilisateur est déjà utilisé", Toast.LENGTH_SHORT).show();
                    } else {
                        // Ajouter l'utilisateur à la base de données
                        myDatabaseHelper.addUser(nom, motDePasseTexte);
                        Toast.makeText(InscriptionActivity.this, "Inscription réussie", Toast.LENGTH_SHORT).show();
                        finish(); // Fermer l'activité d'inscription
                    }
                }
            });
        }
    }

