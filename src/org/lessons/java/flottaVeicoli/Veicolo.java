package org.lessons.java.flottaVeicoli;

import java.time.LocalDate;

/*
*
*    Descrizione:
*    Hai ricevuto l’incarico di sviluppare un’applicazione Java per la gestione di una flotta di veicoli.
*    Ogni veicolo nella flotta può essere di due tipi: automobile o motocicletta.
*    Ogni veicolo ha un numero di targa univoco e un anno di immatricolazione.
*    Le automobili hanno un campo per indicare il numero di porte, mentre le motociclette hanno un campo per indicare se sono dotate di
*    cavalletto o meno.
*    Deve essere possibile visualizzare tutte le informazioni di ciascun tipo di veicolo. Creare la gerarchia di classi necessarie e una
*    classe GestoreFlotta che conterrà una lista di veicoli.
*    La classe GestoreFlotta deve permettere di:
*
*        aggiungere nuovi veicoli alla flotta
*        contare quanti veicoli ci sono di un determinato tipo (automobile o motocicletta)
*        trovare un veicolo specifico tramite il numero di targa
*
*    Aggiungere un’altra classe Main, con il metodo main nel quale viene creata un’istanza di GestoreFlotta e ne vengono testati
*    tutti i metodi. Può essere fatto implementando un menu interattivo usando lo Scanner oppure impostando direttamente nel codice i
*    dati con cui costruire i vari oggetti.
*
*    BONUS 1: non deve essere possibile aggiungere 2 veicoli con la stessa targa; in questo caso il
*             sistema deve restituire un messaggio di errore
*    BONUS 2: ragionare sulla classe veicolo: è necessario e ha senso che venga istanziata oppure potrebbe essere astratta?
*
*/
public class Veicolo {
    //variables
    private String nome;
    private String  targa;
    private LocalDate annoDiImmatricolazione;

    //constructor
    public Veicolo(String nome, String targa, LocalDate annoDiImmatricolazione) {
        this.nome = nome;
        this.targa = targa;
        this.annoDiImmatricolazione = annoDiImmatricolazione;
    }

    //get and setter
        //get
    public String getTarga() {
        return targa;
    }
    public LocalDate getAnnoDiImmatricolazione() {
        return annoDiImmatricolazione;
    }
    public String getNome() {
        return nome;
    }

         //set
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }
    public void setAnnoDiImmatricolazione(LocalDate annoDiImmatricolazione) {
        this.annoDiImmatricolazione = annoDiImmatricolazione;
    }


    @Override
    public String toString() {
        return "Veicolo: " +
                "nome= " + nome +
                ", targa= " + targa +
                ", anno di immatricolazione=" + annoDiImmatricolazione +
                ", ";
    }

}
