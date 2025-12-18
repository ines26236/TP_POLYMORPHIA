package Controle2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientPvP {

    public static void main(String[] args) {
        final String HOST = "localhost"; // ou IP du serveur
        final int PORT = 5000;

        try (Socket socket = new Socket(HOST, PORT)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            // Thread pour lire les messages du serveur
            Thread lectureServeur = new Thread(() -> {
                try {
                    String msg;
                    while ((msg = in.readLine()) != null) {
                        System.out.println(msg);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            lectureServeur.start();

            // Envoyer les actions du joueur
            while (scanner.hasNextLine()) {
                String action = scanner.nextLine();
                out.println(action);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
