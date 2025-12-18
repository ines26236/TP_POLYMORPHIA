package Controle2;

public class Marchand {
private java.util.List<ObjetInventaire> catalogue;
public Marchand() {
    catalogue = new java.util.ArrayList<>();
    initialiserCatalogue();
}

private void initialiserCatalogue() {
    // Armes
    catalogue.add(new Arme("Épée en fer", 8, 50));
    catalogue.add(new Arme("Hache de guerre", 12, 80));
    catalogue.add(new Arme("Arc long", 10, 70));
    catalogue.add(new Arme("Épée légendaire", 20, 200));
    
    // Armures
    catalogue.add(new Armure("Armure de cuir", 5, 40));
    catalogue.add(new Armure("Bouclier en bois", 3, 30));
    catalogue.add(new Armure("Armure de plates", 10, 120));
    
    // Potions
    catalogue.add(new Potion("Petite potion", 30, 20));
    catalogue.add(new Potion("Grande potion", 60, 40));
    catalogue.add(new Potion("Potion majeure", 100, 70));
    
    // Sorts
    catalogue.add(new Sort("Boule de feu", 35, false, 100));
    catalogue.add(new Sort("Bouclier magique", 15, true, 80));
    
    // Materia
    catalogue.add(new Materia("Materia basique", 3, 50));
    catalogue.add(new Materia("Materia rare", 5, 100));
}

public void afficherCatalogue() {
    System.out.println("\n=== MARCHAND ===");
    System.out.println("Bienvenue voyageur ! Voici mes marchandises :\n");
    
    for (int i = 0; i < catalogue.size(); i++) {
        System.out.println((i + 1) + ". " + catalogue.get(i));
    }
}

public boolean vendre(Joueur joueur, int index) {
    if (index < 0 || index >= catalogue.size()) {
        System.out.println("Objet invalide !");
        return false;
    }
    
    ObjetInventaire objet = catalogue.get(index);
    
    if (!joueur.getInventaire().retirerIntcoins(objet.getPrix())) {
        System.out.println("Pas assez d'intcoins ! (Prix: " + objet.getPrix() + ")");
        return false;
    }
    
    // Ajouter l'objet à l'inventaire
    if (objet instanceof Arme) {
        joueur.getInventaire().ajouterArme((Arme) objet);
    } else if (objet instanceof Armure) {
        joueur.getInventaire().ajouterArmure((Armure) objet);
    } else if (objet instanceof Potion) {
        joueur.getInventaire().ajouterPotion((Potion) objet);
    } else if (objet instanceof Sort) {
        joueur.getInventaire().ajouterSort((Sort) objet);
    } else if (objet instanceof Materia) {
        joueur.getInventaire().ajouterMateria((Materia) objet);
    }
    
    System.out.println("Achat réussi : " + objet.getNom() + " !");
    return true;
}
}
