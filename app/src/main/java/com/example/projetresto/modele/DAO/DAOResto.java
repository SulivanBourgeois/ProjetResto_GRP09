package com.example.projetresto.modele.DAO;


import static com.example.projetresto.modele.DAO.StructureBDD.COL_ADRESSE_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_ID_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_NOM_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_TYPE_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_VILLE_RESTO;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_resto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.projetresto.modele.metier.resto;
import com.example.projetresto.modele.DAO.StructureBDD;

public class DAOResto extends DAOModele {

    public DAOResto(Context context) {
        super(context);
    }

    public static long insererResto(resto unResto) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_NOM_RESTO, unResto.getNomR());
        values.put(COL_VILLE_RESTO, unResto.getVilleR());
        values.put(COL_TYPE_RESTO, unResto.getTypeRestoR());
        values.put(COL_ADRESSE_RESTO, unResto.getAdresseRestoR());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_resto, null, values);
    }

    public static resto cursorToResto(Cursor c) { //Cette méthode permet de convertir un cursor en un lac
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        resto unResto = new resto(null, null, null, null); //On créé un lac
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unResto.setNomR(c.getString(1));
        unResto.setVilleR(c.getString(2));
        unResto.setTypeRestoR(c.getString(3));
        unResto.setAdresseRestoR(c.getString(4));
        c.close(); //On ferme le cursor
        return unResto; //On retourne le restp

    }

    public static resto getRestoByNom(String nomResto) {
        //Récupère dans un Cursor les valeurs correspondant à un article grâce à sa designation)
        Cursor c = db.query(TABLE_resto, new String[]{COL_NOM_RESTO, COL_VILLE_RESTO,COL_TYPE_RESTO,COL_ADRESSE_RESTO}, COL_NOM_RESTO + " LIKE \"" + nomResto + "\"", null, null, null, null);
        return cursorToResto(c);
    }

    public static Cursor getOneByNom() {
        //problème avec les dates sans 0 devant 3/10 ne marche pas 03/10 fonctionne
        String $sql = "SELECT * FROM tresto WHERE NomR='" + "'";
        return db.rawQuery($sql, null);
    }


    public static Cursor getAll() {
        return db.rawQuery("SELECT * FROM tresto ORDER BY NomR", null);
    }


}

