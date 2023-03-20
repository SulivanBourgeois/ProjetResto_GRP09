package com.example.projetresto.controleur;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;

public class ConnexionActivity extends AppCompatActivity {

        private EditText editTextEmail;
        private EditText editTextMotDePasse;
        private Button buttonSeConnecter;

        private SQLiteDatabase database;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_connexion);

            editTextEmail = findViewById(R.id.editTextEmail);
            editTextMotDePasse = findViewById(R.id.editTextMotDePasse);
            buttonSeConnecter = findViewById(R.id.buttonSeConnecter);

            // Ouvrir la base de données
            database = openOrCreateDatabase("MaBaseDeDonnees", MODE_PRIVATE, null);

            // Créer la table des utilisateurs si elle n'existe pas déjà
            database.execSQL("CREATE TABLE IF NOT EXISTS utilisateurs (id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, mot_de_passe TEXT)");

            buttonSeConnecter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = editTextEmail.getText().toString();
                    String motDePasse = editTextMotDePasse.getText().toString();

                    // Vérifier si l'utilisateur existe dans la base de données
                    Cursor cursor = database.rawQuery("SELECT * FROM utilisateurs WHERE email=? AND mot_de_passe=?", new String[]{email, motDePasse});
                    if (cursor.moveToFirst()) {
                        // L'utilisateur existe, ouvrir l'activité principale
                        Intent intent = new Intent(ConnexionActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // L'utilisateur n'existe pas, afficher un message d'erreur
                        Toast.makeText(ConnexionActivity.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();

            // Fermer la base de données
            if (database != null) {
                database.close();
            }
        }
    }

