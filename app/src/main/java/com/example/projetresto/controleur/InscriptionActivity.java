package com.example.projetresto.controleur;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;

public class InscriptionActivity extends AppCompatActivity {
    private EditText adresseEmailEditText;
    private EditText motDePasseEditText;
    private Button inscriptionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incription);

        adresseEmailEditText = findViewById(R.id.editTextEmail);
        motDePasseEditText = findViewById(R.id.editTextMotDePasse);
        inscriptionButton = findViewById(R.id.buttonCreer);
        inscriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String adresseEmail = adresseEmailEditText.getText().toString().trim();
                String motDePasse = motDePasseEditText.getText().toString().trim();

                if (adresseEmail.isEmpty()) {
                    adresseEmailEditText.setError("Veuillez entrer votre adresse email");
                    adresseEmailEditText.requestFocus();
                    return;
                }
                if (motDePasse.length() < 6) {
                    motDePasseEditText.setError("Le mot de passe doit contenir au moins 6 caractères");
                    motDePasseEditText.requestFocus();
                    return;
                }
                Intent intent = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                startActivity(intent);
                finish();

                //
            }
        });
    }
}
