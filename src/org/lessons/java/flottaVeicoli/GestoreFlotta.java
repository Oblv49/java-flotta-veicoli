package org.lessons.java.flottaVeicoli;

import java.util.ArrayList;

public class GestoreFlotta {

    //variables
    private ArrayList<Veicolo> veicoli = new ArrayList<>();

    //constructor
    public GestoreFlotta(ArrayList<Veicolo> veicoli) {
        this.veicoli = veicoli;
    }

    //getter and setter
        //get
    public ArrayList getVeicoli() {
        return veicoli;
    }
        //set
    public void setVeicoli(ArrayList veicoli) {
        this.veicoli = veicoli;
    }

    //tostring
    @Override
    public String toString() {
        return "GestoreFlotta{" +
                "veicoli=" + veicoli +
                '}';
    }


    //methods
        //aggiunge veicolo
        public void aggiungiVeicolo(Veicolo veicolo) {
            veicoli.add(veicolo);
        }
        //conta numero di motociclette
        public int contaMotociclette() {
            int conteggioMotociclette = 0;
            for (Veicolo veicolo : veicoli) {
                if (veicolo instanceof Motocicletta) {
                    conteggioMotociclette++;
                }
            }
            return conteggioMotociclette;
        }

        //conta numeri di automobili
        public int contaAutomobili() {
            int conteggioAutomobili = 0;
            for (Veicolo veicolo : veicoli) {
                if (veicolo instanceof Automobile) {
                    conteggioAutomobili++;
                }
            }
            return conteggioAutomobili;
        }

        //ricerca per targa
        public Veicolo cercaVeicoloPerTarga(String targa) {
            for (Veicolo veicolo : veicoli) {
                if (veicolo.getTarga().equals(targa)) {
                    return veicolo;
                }
            }
            return null;
        }

}
