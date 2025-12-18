package Controle2;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
	 private List<Arme> armes;
	    private List<Armure> armures;
	    private List<Potion> potions;
	    private List<Sort> sorts;
	    private List<Materia> materias;
	    private int intcoins;
	    
	    public Inventaire(int intcoinsDepart) {
	        this.armes = new ArrayList<>();
	        this.armures = new ArrayList<>();
	        this.potions = new ArrayList<>();
	        this.sorts = new ArrayList<>();
	        this.materias = new ArrayList<>();
	        this.intcoins = intcoinsDepart;
	    }
	    
	    public void ajouterIntcoins(int montant) { 
	        this.intcoins += montant; 
	    }
	    
	    public boolean retirerIntcoins(int montant) {
	        if (intcoins >= montant) {
	            intcoins -= montant;
	            return true;
	        }
	        return false;
	    }
	    
	    public int getIntcoins() { return intcoins; }
	    
	    // Ajouter des objets
	    public void ajouterArme(Arme a) { armes.add(a); }
	    public void ajouterArmure(Armure a) { armures.add(a); }
	    public void ajouterPotion(Potion p) { potions.add(p); }
	    public void ajouterSort(Sort s) { sorts.add(s); }
	    public void ajouterMateria(Materia m) { materias.add(m); }
	    
	    // Recuperer les listes
	    public List<Arme> getArmes() { return armes; }
	    public List<Armure> getArmures() { return armures; }
	    public List<Potion> getPotions() { return potions; }
	    public List<Sort> getSorts() { return sorts; }
	    public List<Materia> getMaterias() { return materias; }
	    
	    // Retirer des objets consommables
	    public void retirerPotion(Potion p) { potions.remove(p); }
	    public void retirerSort(Sort s) { sorts.remove(s); }
	    public void retirerMateria(Materia m) { materias.remove(m); }
	    
	    public void afficher() {
	        System.out.println("\n=== INVENTAIRE ===");
	        System.out.println("Intcoins: " + intcoins);
	        
	       
	        System.out.println("\nArmes (" + armes.size() + "):");
	        for (int i = 0; i < armes.size(); i++) {
	            System.out.println("  " + (i+1) + ". " + armes.get(i));
	        }
	        
	        System.out.println("\nArmures (" + armures.size() + "):");
	        for (int i = 0; i < armures.size(); i++) {
	            System.out.println("  " + (i+1) + ". " + armures.get(i));
	        }
	        
	        System.out.println("\nPotions (" + potions.size() + "):");
	        for (int i = 0; i < potions.size(); i++) {
	            System.out.println("  " + (i+1) + ". " + potions.get(i));
	        }
	        
	        System.out.println("\nSorts (" + sorts.size() + "):");
	        for (int i = 0; i < sorts.size(); i++) {
	            System.out.println("  " + (i+1) + ". " + sorts.get(i));
	        }
	        
	        System.out.println("\nMaterias (" + materias.size() + "):");
	        for (int i = 0; i < materias.size(); i++) {
	            System.out.println("  " + (i+1) + ". " + materias.get(i));
	        }
	    }
}
