package com.example.projetresto.controleur;

import static java.lang.String.valueOf;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.DAO.StructureBDD;
import com.example.projetresto.modele.metier.resto;

import java.util.ArrayList;



public class DetailsRestoActivity extends AppCompatActivity {

    String nomResto ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Spinner spinnerAfficheResto = (Spinner) findViewById(R.id.spinnerSaisieResto);
        DAOResto restobdd = new DAOResto(this);

        Cursor c = DAOResto.getAll();

        ArrayList<String> lesResto = new ArrayList();

        if (c.moveToFirst()) {
            if (c.getCount() != 0) {
                while (!c.isAfterLast()) {
                    lesResto.add(c.getString(1));
                    c.moveToNext();
                }
            }
            ArrayAdapter<String> dataAdapterR = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lesResto);
            dataAdapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


            spinnerAfficheResto.setAdapter(dataAdapterR);

            spinnerAfficheResto.setOnItemClickListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    nomResto = valueOf(spinnerAfficheResto.getSelectedItem());

                    resto Resto = restobdd.getRestoByNom(nomResto);
                    TextView typeResto = findViewById(R.id.TypeResto);
                    typeResto.setText("le type du Resto est :" + valueOf(Resto.getTypeRestoR()));
                    TextView adresseResto = findViewById(R.id.AdrResto);
                    adresseResto.setText("l'adresse du resto est :" + valueOf(Resto.getAdresseRestoR()));
                    TextView ville = findViewById(R.id.VilleResto);
                    ville.setText("la ville du Resto est :" + valueOf(Resto.getVilleR()));

                }
            }

            );
        }
    }
}
