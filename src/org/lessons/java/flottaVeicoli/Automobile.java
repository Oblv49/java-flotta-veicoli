package org.lessons.java.flottaVeicoli;

import java.time.LocalDate;

public class Automobile extends Veicolo{
    //variables
    private int nPorte;

    //constructor


    public Automobile(String nome, String targa, LocalDate annoDiImmatricolazione, int nPorte) {
        super(nome, targa, annoDiImmatricolazione);
        this.nPorte = nPorte;
    }

    //getter and setter
        //get
    public int getNPorte() {
        return nPorte;
    }
        //set
    public void setnPorte(int nPorte) {
        this.nPorte = nPorte;
    }

    //tostring
    @Override
    public String toString() {
        return "Automobile: " +
                "numero porte= " + nPorte +
                '.';
    }
}
