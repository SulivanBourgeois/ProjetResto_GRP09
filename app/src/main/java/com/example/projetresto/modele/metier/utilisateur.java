package com.example.projetresto.modele.metier;

public class utilisateur {

    protected String adresseEmail;
    protected String Motdepasse;

    public utilisateur(String adresseEmail, String Motdepasse) {
        this.adresseEmail = adresseEmail;
        this.Motdepasse = Motdepasse;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public String getMotdepasse() {
        return Motdepasse;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public void setMotdepasse(String Motdepasse) {
        this.Motdepasse = Motdepasse;
    }
}
