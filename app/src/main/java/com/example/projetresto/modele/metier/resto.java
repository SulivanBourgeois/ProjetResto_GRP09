package com.example.projetresto.modele.metier;

public class resto {


    protected String nomR;
    protected String villeR;
    protected String typeRestoR;
    protected String adresseRestoR;

    public resto(String nomR, String villeR, String typeRestoR, String adresseRestoR) {
        this.nomR = nomR;
        this.villeR = villeR;
        this.typeRestoR = typeRestoR;
        this.adresseRestoR = adresseRestoR;
    }


    public String getNomR() {
        return nomR;
    }

    public void setNomR(String nomR) {
        this.nomR = nomR;
    }

    public String getVilleR() {
        return villeR;
    }

    public void setVilleR(String villeR) {
        this.villeR = villeR;
    }

    public String getTypeRestoR() {
        return typeRestoR;
    }

    public void setTypeRestoR(String typeRestoR) {
        this.typeRestoR = typeRestoR;
    }

    public String getAdresseRestoR() {
        return adresseRestoR;
    }

    public void setAdresseRestoR(String adresseRestoR) {
        this.adresseRestoR = adresseRestoR;
    }

}



