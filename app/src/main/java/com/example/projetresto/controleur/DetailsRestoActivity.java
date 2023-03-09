package com.example.projetresto.controleur;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projetresto.R;
import com.example.projetresto.modele.DAO.DAOResto;
import com.example.projetresto.modele.DAO.StructureBDD;

public class DetailsRestoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //on crée un objet java en correspondance avec l'élément graphique listViewInfosLacs
        ListView listViewInfosResto = findViewById(R.id.ListViewDetailResto);
        //on crée un objet daolac
        DAOResto restobdd = new DAOResto(this);
        restobdd.open();
        //on récupère chacun
        Cursor c = DAOResto.getOneByNom();
        // choix des colonnes à afficher enregistrer dans un tableaux de chaine de caractères nommé columns
        String[] columns = new String[]{StructureBDD.COL_NOM_RESTO, StructureBDD.COL_VILLE_RESTO, StructureBDD.COL_TYPE_RESTO};
        // tableau d'entiers nommé to correspondant à la liste des id des éléments graphiques correspondants dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.textViewNom, R.id.textViewVille, R.id.textViewTypeResto};
        //modèle pour afficher les éléments dans une liste utilisant les données c avec les colonnes choisies columns et à mettre dans les éléments f=graphiques d'id contenu dans to
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_detail, c, columns, to, 0);

        //on attribue cet adapterView (ce type d'affichage) à la listeView
        listViewInfosResto.setAdapter(dataAdapter);

    }
}
