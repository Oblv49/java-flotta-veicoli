package org.lessons.java.flottaVeicoli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //variables
        ArrayList<Veicolo> veicoli = new ArrayList<>();
        GestoreFlotta flotta =  new GestoreFlotta(veicoli);
        int userChoose;
        Scanner input = new Scanner(System.in);

        //cretion istance
        Veicolo v1 = new Automobile("Lamborghini","AB123CD", LocalDate.of(2018, 5, 10), 4);
        Veicolo v2 = new Automobile("Mustang", "EF456GH", LocalDate.of(2019, 7, 15), 5);
        Veicolo v3  = new Motocicletta("Kawasaki","XY789Z", LocalDate.of(2020, 3, 22), true);
        Veicolo v4 = new Automobile("Ferrari","LM789OP", LocalDate.of(2021, 9, 5), 3);
        Veicolo v5 = new Motocicletta("Harley Davidson's","QR123S", LocalDate.of(2017, 12, 3), false);
        Veicolo v6 = new Automobile("bugatti","TU456VW", LocalDate.of(2022, 2, 18), 2);

        //add instance in arraylist
        flotta.aggiungiVeicolo(v1);
        flotta.aggiungiVeicolo(v2);
        flotta.aggiungiVeicolo(v3);
        flotta.aggiungiVeicolo(v4);
        flotta.aggiungiVeicolo(v5);
        flotta.aggiungiVeicolo(v6);

        //program creation
        System.out.println("Benvenuto nel Gestionale DElla FlottaVeicoli.");
        System.out.println("---------------------------------------------");
        System.out.println("Tutti i veicoli presenti:");
        for (Veicolo veicolo : veicoli) {
            System.out.println("Il Veicolo: " + veicolo.getNome() + " " + " con Targa: " + veicolo.getTarga());
        }
        do {
            System.out.println("Cosa desideri fare?");
            System.out.println("1. Contare i veicoli");
            System.out.println("2. Cercare un veicolo tramite targa");
            System.out.println("3. Aggiungere un veicolo");
            System.out.println("0. Uscire");

            userChoose = input.nextInt();

            switch (userChoose) {
                case 1:
                    System.out.println("Scegli il tipo di veicolo da contare:");
                    System.out.println("---------------------------------------------");
                    System.out.println("1. Automobili");
                    System.out.println("2. Motociclette");
                    int tipoVeicolo = input.nextInt();
                    System.out.println("---------------------------------------------");
                    if (tipoVeicolo == 1) {
                        int automobili = flotta.contaAutomobili();
                        System.out.println("Numero di automobili presenti: " + automobili);
                        System.out.println("---------------------------------------------");
                    } else if (tipoVeicolo == 2) {
                        int motociclette = flotta.contaMotociclette();
                        System.out.println("Numero di motociclette presenti: " + motociclette);
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("Scelta non valida.");
                    }
                    break;
                case 2:
                    System.out.println("Inserisci la targa da cercare:");
                    System.out.println("---------------------------------------------");
                    String targaDaCercare = input.next();
                    System.out.println("---------------------------------------------");
                    Veicolo veicoloTrovato = flotta.cercaVeicoloPerTarga(targaDaCercare);
                    if (veicoloTrovato != null) {
                        System.out.println("Veicolo trovato:");
                        System.out.println("---------------------------------------------");
                        System.out.println("Nome: " + veicoloTrovato.getNome());
                        System.out.println("Targa: " + veicoloTrovato.getTarga());
                        if (veicoloTrovato instanceof Automobile) {
                            System.out.println("Tipo: Automobile");
                            Automobile automobile = (Automobile) veicoloTrovato;
                            System.out.println("Numero di porte: " + automobile.getNPorte());
                        } else if (veicoloTrovato instanceof Motocicletta) {
                            System.out.println("Tipo: Motocicletta");
                            Motocicletta motocicletta = (Motocicletta) veicoloTrovato;
                            System.out.println("Cavalletto: " + motocicletta.isCavallettoSi());
                        }
                        System.out.println("Anno di Immatricolazione: " + veicoloTrovato.getAnnoDiImmatricolazione());
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("Veicolo non trovato.");
                    }
                    break;
                case 3:
                    System.out.println("Inserisci i dettagli del veicolo:");
                    System.out.println("---------------------------------------------");
                    System.out.println("Nome del veicolo:");
                    String nomeVeicolo = input.next();
                    System.out.println("Targa:");
                    String targa = input.next();
                    System.out.println("Anno di immatricolazione (yyyy):");
                    int anno = input.nextInt();
                    System.out.println("Mese di immatricolazione (mm):");
                    int mese = input.nextInt();
                    System.out.println("Giorno di immatricolazione (dd):");
                    int giorno = input.nextInt();
                    LocalDate dataImmatricolazione = LocalDate.of(anno, mese, giorno);
                    System.out.println("Tipo di veicolo (1 per Automobile, 2 per Motocicletta):");
                    int tipo = input.nextInt();
                    if (tipo == 1) {
                        System.out.println("Numero di porte:");
                        int nPorte = input.nextInt();
                        Veicolo nuovaAutomobile = new Automobile(nomeVeicolo, targa, dataImmatricolazione, nPorte);
                        flotta.aggiungiVeicolo(nuovaAutomobile);
                        System.out.println("---------------------------------------------");

                    } else if (tipo == 2) {
                        System.out.println("Cavalletto (true o false):");
                        boolean cavalletto = input.nextBoolean();
                        Veicolo nuovaMotocicletta = new Motocicletta(nomeVeicolo, targa, dataImmatricolazione, cavalletto);
                        flotta.aggiungiVeicolo(nuovaMotocicletta);
                        System.out.println("---------------------------------------------");

                    } else {
                        System.out.println("Tipo di veicolo non valido.");
                    }
                    break;
                case 0:
                    System.out.println("Uscita dal programma.");
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    break;
            }
        } while (userChoose != 0);

        input.close();
    }
}
