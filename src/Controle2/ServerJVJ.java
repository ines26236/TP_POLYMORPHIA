package Controle2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerJVJ {

    public static void main(String[] args) {
        final int PORT = 5000;

        try (ServerSocket serveur = new ServerSocket(PORT)) {
            System.out.println("Serveur PvP lancé, attente de 2 joueurs...");

            Socket socketJ1 = serveur.accept();
            System.out.println("Joueur 1 connecté");
            Socket socketJ2 = serveur.accept();
            System.out.println("Joueur 2 connecté");

            PrintWriter out1 = new PrintWriter(socketJ1.getOutputStream(), true);
            PrintWriter out2 = new PrintWriter(socketJ2.getOutputStream(), true);

            BufferedReader in1 = new BufferedReader(new InputStreamReader(socketJ1.getInputStream()));
            BufferedReader in2 = new BufferedReader(new InputStreamReader(socketJ2.getInputStream()));

            out1.println("Vous êtes le joueur 1");
            out2.println("Vous êtes le joueur 2");

            // Créer deux joueurs avec des stats simples
            Joueur j1 = new Joueur("Joueur 1");
            Joueur j2 = new Joueur("Joueur 2");

            int tour = 1;

            while (j1.estVivant() && j2.estVivant()) {
                if (tour % 2 == 1) {
                    out1.println("Votre tour: tapez '1' pour attaquer");
                    String action = in1.readLine();
                    if ("1".equals(action)) {
                        int degats = j1.attaquer();
                        j2.recevoirDegats(degats);
                        envoyer(out1, out2, j1.getNom() + " attaque avec " + degats + " degats!");
                    }
                } else {
                    out2.println("Votre tour: tapez '1' pour attaquer");
                    String action = in2.readLine();
                    if ("1".equals(action)) {
                        int degats = j2.attaquer();
                        j1.recevoirDegats(degats);
                        envoyer(out1, out2, j2.getNom() + " attaque avec " + degats + " degats!");
                    }
                }

                envoyer(out1, out2, "PV Joueur 1: " + j1.getPointsVie() + " | PV Joueur 2: " + j2.getPointsVie());
                tour++;
            }

            if (j1.estVivant()) {
                envoyer(out1, out2, "FIN DU COMBAT : Joueur 1 gagne !");
            } else {
                envoyer(out1, out2, "FIN DU COMBAT : Joueur 2 gagne !");
            }

            socketJ1.close();
            socketJ2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void envoyer(PrintWriter o1, PrintWriter o2, String message) {
        o1.println(message);
        o2.println(message);
    }
}
