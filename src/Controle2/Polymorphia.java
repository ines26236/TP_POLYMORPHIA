package Controle2;

import java.util.Scanner;

public class Polymorphia {

public static void main(String[] args) {

Scanner scanner = new Scanner(System.in);

System.out.println("=======================================");
System.out.println(" BIENVENUE DANS POLYMORPHIA");
System.out.println("=======================================\n");

Joueur javalt = new Joueur("Javalt de Riv");
Marchand marchand = new Marchand();
Combat combat = new Combat();

boolean jeuActif = true;

while (jeuActif && javalt.estVivant()) {

System.out.println("\n=== MENU PRINCIPAL ===");
System.out.println("1. Voir mes statistiques");
System.out.println("2. Voir mon inventaire");
System.out.println("3. Visiter le marchand");
System.out.println("4. S'equiper");
System.out.println("5. Ameliorer un objet avec Materia");
System.out.println("6. Explorer Polymorphia");
System.out.println("7. Quitter");
System.out.println("8. Combat multijoueur (PvP)");
System.out.print("\nVotre choix: ");

int choix = scanner.nextInt();
scanner.nextLine();

switch (choix) {

case 1:
javalt.afficherStats();
break;

case 2:
javalt.getInventaire().afficher();
break;

case 3:
marchand.afficherCatalogue();
System.out.println("\nVos intcoins: " + javalt.getInventaire().getIntcoins());
System.out.print("Acheter quel objet? (0 pour annuler): ");
int achat = scanner.nextInt() - 1;
scanner.nextLine();
if (achat >= 0) {
marchand.vendre(javalt, achat);
}
break;

case 4:
System.out.println("\nQue voulez-vous equiper?");
System.out.println("1. Arme");
System.out.println("2. Armure");
int typeEquip = scanner.nextInt();
scanner.nextLine();

if (typeEquip == 1 && !javalt.getInventaire().getArmes().isEmpty()) {
System.out.println("Choisir une arme:");
for (int i = 0; i < javalt.getInventaire().getArmes().size(); i++) {
System.out.println((i + 1) + ". " + javalt.getInventaire().getArmes().get(i));
}
int armeIndex = scanner.nextInt() - 1;
scanner.nextLine();
if (armeIndex >= 0) {
javalt.equiperArme(javalt.getInventaire().getArmes().get(armeIndex));
}

} else if (typeEquip == 2 && !javalt.getInventaire().getArmures().isEmpty()) {
System.out.println("Choisir une armure:");
for (int i = 0; i < javalt.getInventaire().getArmures().size(); i++) {
System.out.println((i + 1) + ". " + javalt.getInventaire().getArmures().get(i));
}
int armureIndex = scanner.nextInt() - 1;
scanner.nextLine();
if (armureIndex >= 0) {
javalt.equiperArmure(javalt.getInventaire().getArmures().get(armureIndex));
}
} else {
System.out.println("Aucun objet disponible !");
}
break;

case 5:
if (javalt.getInventaire().getMaterias().isEmpty()) {
System.out.println("Vous n'avez pas de Materia!");
break;
}
System.out.println("Amelioration non encore implementee.");
break; 

case 6:
System.out.println("\nVous explorez les vastes etendues de Polymorphia...");
Monstre monstre = Bestiaire.genererMonstreAleatoire();
combat.combatAvecActions(javalt, monstre, scanner);
break;

case 7:
System.out.println("\nMerci d'avoir joue a Polymorphia!");
jeuActif = false;
break;

case 8:
    System.out.println("\nConnexion au serveur multijoueur...");
    try {
        ClientPvP.main(null); // lance le client PvP
    } catch (Exception e) {
        System.out.println("Erreur de connexion: " + e.getMessage());
    }
    break;


default:
System.out.println("Choix invalide!");
}
}

if (!javalt.estVivant()) {
System.out.println("\n=======================================");
System.out.println(" GAME OVER");
System.out.println("=======================================");
}

scanner.close();
}
}

