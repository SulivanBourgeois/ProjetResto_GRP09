package com.example.projetresto.modele.metier;

public class réservation {
    protected String NomRéservation;
    protected String PrénomReservation;


    public réservation(String nomRéservation, String prénomReservation) {
        this.NomRéservation = nomRéservation;
        this.PrénomReservation = prénomReservation;
    }

    public String getNomRéservation() {
        return NomRéservation;
    }

    public void setNomRéservation(String nomRéservation) {
        this.NomRéservation = nomRéservation;
    }

    public String getPrénomReservation() {
        return PrénomReservation;
    }

    public void setPrénomReservation(String prénomReservation) {
        this.PrénomReservation = prénomReservation;
    }
}
