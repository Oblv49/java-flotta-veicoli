package org.lessons.java.flottaVeicoli;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
                    // Controllo per targa già presente
                    String targa;
                    boolean targaDuplicata;
                    do {
                        System.out.println("Targa:");
                        targa = input.next();
                        targaDuplicata = flotta.targaGiaPresente(targa);
                        if (targaDuplicata) {
                            System.out.println("Targa già presente. Inserisci una targa diversa.");
                        }
                    } while (targaDuplicata);
                    //controllo errori data
                    int anno = 0;
                    int mese = 0;
                    int giorno = 0;
                    boolean dataImmatricolazioneValida = false;
                    while (!dataImmatricolazioneValida) {
                        try {
                            System.out.println("Anno di immatricolazione (yyyy):");
                            anno = input.nextInt();
                            System.out.println("Mese di immatricolazione (mm):");
                            mese = input.nextInt();
                            System.out.println("Giorno di immatricolazione (dd):");
                            giorno = input.nextInt();
                            // Verifica che il mese sia compreso tra 1 e 12 e il giorno tra 1 e 31
                            if (mese >= 1 && mese <= 12 && giorno >= 1 && giorno <= 31) {
                                LocalDate dataImmatricolazione = LocalDate.of(anno, mese, giorno);
                                dataImmatricolazioneValida = true;
                            } else {
                                System.out.println("Data di immatricolazione non valida. Inserisci una data valida (anno mese giorno).");
                            }
                        } catch (DateTimeParseException e) {
                            System.out.println("Data di immatricolazione non valida. Inserisci una data valida (anno mese giorno).");
                            input.nextLine();
                        }
                    }

                    System.out.println("Tipo di veicolo (1 per Automobile, 2 per Motocicletta):");
                    int tipo = input.nextInt();
                    if (tipo == 1) {
                        int nPorte = 0;
                        boolean numeroPorteValido = false;
                        while (!numeroPorteValido) {
                            try {
                                System.out.println("Numero di porte (tra 3 e 5): ");
                                nPorte = input.nextInt();
                                if (nPorte >= 3 && nPorte <= 5) {
                                    numeroPorteValido = true;
                                } else {
                                    System.out.println("Numero di porte non valido. Inserisci un numero compreso tra 3 e 5.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Numero di porte non valido. Inserisci un numero intero.");
                                input.nextLine();
                            }
                        }
                        Veicolo nuovaAutomobile = new Automobile(nomeVeicolo, targa, LocalDate.of(anno, mese, giorno), nPorte);
                        flotta.aggiungiVeicolo(nuovaAutomobile);
                        System.out.println("---------------------------------------------");
                    } else if (tipo == 2) {
                        boolean cavalletto = false;
                        boolean cavallettoValido = false;
                        while (!cavallettoValido) {
                            try {
                                System.out.println("Cavalletto (true o false):");
                                cavalletto = Boolean.parseBoolean(input.next());
                                cavallettoValido = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Valore del cavalletto non valido. Inserisci 'true' o 'false'.");
                                input.nextLine();
                            }
                        }
                        Veicolo nuovaMotocicletta = new Motocicletta(nomeVeicolo, targa, LocalDate.of(anno, mese, giorno), cavalletto);
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
