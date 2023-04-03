package com.example.projetresto.controleur;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetresto.R;

public class RéservationActivity extends AppCompatActivity {
    private EditText NomEditText;

    private EditText PrenomEditText;

    private Button EnregistrerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        NomEditText = findViewById(R.id.NomEditText);
        PrenomEditText = findViewById(R.id.PrenomEdtiText);
        EnregistrerButton = findViewById(R.id.buttonEnregistrer);
        EnregistrerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nom = NomEditText.getText().toString();
                String Prenom = PrenomEditText.getText().toString();

            }
        }
        );
    }
}
