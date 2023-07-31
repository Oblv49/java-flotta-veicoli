package org.lessons.java.flottaVeicoli;

import java.time.LocalDate;

public class Automobile extends Veicolo{
    //variables
    private int nPorte;

    //constructor
    public Automobile(String targa, LocalDate annoDiImmatricolazione, int nPorte) {
        super(targa, annoDiImmatricolazione);
        this.nPorte = nPorte;
    }

    //getter and setter
        //get
    public int getnPorte() {
        return nPorte;
    }
        //set
    public void setnPorte(int nPorte) {
        this.nPorte = nPorte;
    }

    //tostring
    @Override
    public String toString() {
        super.toString();
        return "Automobile: " +
                "nPorte= " + nPorte +
                '.';
    }

}
