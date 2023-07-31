package org.lessons.java.flottaVeicoli;

import java.time.LocalDate;

public class Motocicletta extends Veicolo{
    //variables
    private boolean cavallettoSi;

    //constructor


    public Motocicletta(String nome, String targa, LocalDate annoDiImmatricolazione, boolean cavallettoSi) {
        super(nome, targa, annoDiImmatricolazione);
        this.cavallettoSi = cavallettoSi;
    }

    //getter and setter
        //get
    public boolean isCavallettoSi() {
        return cavallettoSi;
    }
        //set
    public void setCavallettoSi(boolean cavallettoSi) {
        this.cavallettoSi = cavallettoSi;
    }

    //tostring

    @Override
    public String toString() {
        return "Motocicletta: " +
                "con cavalletto= " + cavallettoSi +
                '.';
    }
}
