package com.example.projetresto.modele.DAO;

import static com.example.projetresto.modele.DAO.StructureBDD.COL_EMAIL_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.COL_MDP_UTILISATEUR;
import static com.example.projetresto.modele.DAO.StructureBDD.TABLE_utilisateur;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.projetresto.modele.metier.utilisateur;

public class RéservationDAO extends DAOModele {

    public RéservationDAO(Context context) {
        super(context);
    }

    public long insererUtilisateur(utilisateur uneInscription) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_EMAIL_UTILISATEUR, uneInscription.getAdresseEmail());
        values.put(COL_MDP_UTILISATEUR, uneInscription.getMotdepasse());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_utilisateur, null, values);
    }

    public utilisateur cursorToContact(Cursor c) { //Cette méthode permet de convertir un cursor en un utilisateur
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst(); //on se place sur le premier élément
        utilisateur uneInscription = new utilisateur(null, null); //On créé un utilisateur
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        uneInscription.setAdresseEmail(c.getString(1));
        uneInscription.setMotdepasse(c.getString(2));
        c.close(); //On ferme le cursor
        return uneInscription; //On retourne le reste
    }


    public utilisateur getInscriptionByNom(String nomInscription) {
        //Récupère dans un Cursor les valeurs correspondant à un article grâce à sa designation)
        Cursor c = db.query(TABLE_utilisateur, new String[]{COL_EMAIL_UTILISATEUR, COL_MDP_UTILISATEUR}, COL_EMAIL_UTILISATEUR + " LIKE '%" + nomInscription + "%'", null, null, null, null);
        return cursorToContact(c);
    }}


