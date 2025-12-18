package Controle2;

import java.util.Scanner;

public class Combat {
	
	 public void combatAvecActions(Joueur joueur, Monstre monstre, Scanner scanner) {
	        System.out.println("\n=== COMBAT : " + joueur.getNom() + " VS " + monstre.getNom() + " ===");
	        System.out.println("Un " + monstre.getNom() + " sauvage apparait!\n");
	        
	        while (joueur.estVivant() && monstre.estVivant()) {
	            // Afficher l'etat du combat
	            System.out.println("\n--- Tour de " + joueur.getNom() + " ---");
	            System.out.println("PV: " + joueur.getPointsVie() + "/" + joueur.getPointsVieMax());
	            System.out.println(monstre.getNom() + " PV: " + monstre.getPointsVie() + "/" + monstre.getPointsVieMax());
	            
	            System.out.println("\nQue voulez-vous faire?");
	            System.out.println("1. Attaquer");
	            System.out.println("2. Utiliser une potion");
	            System.out.println("3. Utiliser un sort");
	            
	            int choix = scanner.nextInt();
	            scanner.nextLine();
	            
	            // Action du joueur
	            if (choix == 1) {
	                // Attaque normale
	                int degats = joueur.attaquer();
	                System.out.println(joueur.getNom() + " attaque avec " + degats + " points d'attaque!");
	                monstre.recevoirDegats(degats);
	            } else if (choix == 2) {
	                // Utiliser une potion
	                if (joueur.getInventaire().getPotions().isEmpty()) {
	                    System.out.println("Vous n'avez pas de potion!");
	                    continue;
	                }
	                System.out.println("Choisir une potion:");
	                for (int i = 0; i < joueur.getInventaire().getPotions().size(); i++) {
	                    System.out.println((i+1) + ". " + joueur.getInventaire().getPotions().get(i));
	                }
	                int potionIndex = scanner.nextInt() - 1;
	                scanner.nextLine();
	                if (potionIndex >= 0 && potionIndex < joueur.getInventaire().getPotions().size()) {
	                    Potion potion = joueur.getInventaire().getPotions().get(potionIndex);
	                    joueur.utiliserPotion(potion);
	                    joueur.getInventaire().retirerPotion(potion);
	                }
	            } else if (choix == 3) {
	                // Utiliser un sort
	                if (joueur.getInventaire().getSorts().isEmpty()) {
	                    System.out.println("Vous n'avez pas de sort!");
	                    continue;
	                }
	                System.out.println("Choisir un sort:");
	                for (int i = 0; i < joueur.getInventaire().getSorts().size(); i++) {
	                    System.out.println((i+1) + ". " + joueur.getInventaire().getSorts().get(i));
	                }
	                int sortIndex = scanner.nextInt() - 1;
	                scanner.nextLine();
	                if (sortIndex >= 0 && sortIndex < joueur.getInventaire().getSorts().size()) {
	                    Sort sort = joueur.getInventaire().getSorts().get(sortIndex);
	                    joueur.utiliserSort(sort, monstre);
	                    joueur.getInventaire().retirerSort(sort);
	                }
	            }
	            
	            // Verifier si le monstre est mort
	            if (!monstre.estVivant()) {
	                System.out.println("\n*** " + monstre.getNom() + " est vaincu! ***");
	                
	                // Recompenses
	                joueur.getInventaire().ajouterIntcoins(monstre.getRecompenseIntcoins());
	                System.out.println("Vous gagnez " + monstre.getRecompenseIntcoins() + " intcoins!");
	                joueur.gagnerExperience(monstre.getPointsVieMax() / 2);
	                
	               
	            
	            // Tour du monstre
	            System.out.println("\n--- Tour de " + monstre.getNom() + " ---");
	            int degats = monstre.attaquer();
	            System.out.println(monstre.getNom() + " attaque avec " + degats + " points d'attaque!");
	            joueur.recevoirDegats(degats);
	            
	            if (!joueur.estVivant()) {
	                System.out.println("\n*** " + joueur.getNom() + " est vaincu! GAME OVER ***");
	                break;
	            }
	        }
	        
	        System.out.println("\n=== FIN DU COMBAT ===\n");
	    }
}}
