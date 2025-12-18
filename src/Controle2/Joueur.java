package Controle2;

public class Joueur implements Combattant{
	 private String nom;
	    private int pointsVie;
	    private int pointsVieMax;
	    private int attaqueBase;
	    private int defenseBase;
	    private int niveau;
	    private int experience;
	    private Inventaire inventaire;
	    private Arme armeEquipee;
	    private Armure armureEquipee;
	    private int defenseTemporaire;
	    
	    public Joueur(String nom) {
	        this.nom = nom;
	        this.pointsVieMax = 100;
	        this.pointsVie = pointsVieMax;
	        this.attaqueBase = 10;
	        this.defenseBase = 5;
	        this.niveau = 1;
	        this.experience = 0;
	        this.inventaire = new Inventaire(100);
	        this.defenseTemporaire = 0;
	    }
	    
	    @Override
	    public String getNom() { return nom; }
	    
	    @Override
	    public int getPointsVie() { return pointsVie; }
	    
	    public int getPointsVieMax() { return pointsVieMax; }
	    
	    @Override
	    public int getAttaque() {
	        int attaque = attaqueBase + (niveau * 2);
	        if (armeEquipee != null) {
	            attaque += armeEquipee.getPointsAttaque();
	        }
	        return attaque;
	    }
	    
	    @Override
	    public int getDefense() {
	        int defense = defenseBase + niveau + defenseTemporaire;
	        if (armureEquipee != null) {
	            defense += armureEquipee.getPointsDefense();
	        }
	        return defense;
	    }
	    
	    @Override
	    public int attaquer() {
	        defenseTemporaire = 0; //temporaire
	        return getAttaque() + (int)(Math.random() * 5);
	    }
	    
	    @Override
	    public void recevoirDegats(int degats) {
	        int degatsReels = Math.max(1, degats - getDefense());
	        pointsVie = Math.max(0, pointsVie - degatsReels);
	        System.out.println(nom + " recoit " + degatsReels + " degats! PV: " + pointsVie + "/" + pointsVieMax);
	    }
	    
	    @Override
	    public boolean estVivant() {
	        return pointsVie > 0;
	    }
	    
	    // Utiliser une potion
	    public void utiliserPotion(Potion potion) {
	        int soin = potion.getPointsSoin();
	        pointsVie = Math.min(pointsVieMax, pointsVie + soin);
	        System.out.println(nom + " utilise " + potion.getNom() + " et recupere " + soin + " PV!");
	    }
	    
	    // Utiliser un sort
	    public void utiliserSort(Sort sort, Monstre cible) {
	        if (sort.estDefensif()) {
	            defenseTemporaire = sort.getPuissance();
	            System.out.println(nom + " lance " + sort.getNom() + "! Defense +" + sort.getPuissance());
	        } else {
	            System.out.println(nom + " lance " + sort.getNom() + "! Attaque de " + sort.getPuissance() + " degats!");
	            cible.recevoirDegats(sort.getPuissance());
	        }
	    }
	    
	    public void gagnerExperience(int xp) {
	        experience += xp;
	        System.out.println(nom + " gagne " + xp + " XP!");
	        
	        // Monter de niveau si assez d'XP
	        if (experience >= niveau * 50) {
	            monterNiveau();
	        }
	    }
	    
	    private void monterNiveau() {
	        niveau++;
	        pointsVieMax += 20;
	        pointsVie = pointsVieMax;
	        attaqueBase += 3;
	        defenseBase += 2;
	        System.out.println("*** " + nom + " monte au niveau " + niveau + "! ***");
	        System.out.println("PV Max: " + pointsVieMax + " | Attaque: " + getAttaque() + " | Defense: " + getDefense());
	    }
	    
	    public void equiperArme(Arme arme) {
	        this.armeEquipee = arme;
	        System.out.println(nom + " equipe " + arme.getNom() + "!");
	    }
	    
	    public void equiperArmure(Armure armure) {
	        this.armureEquipee = armure;
	        System.out.println(nom + " equipe " + armure.getNom() + "!");
	    }
	    
	    public Inventaire getInventaire() { return inventaire; }
	    public int getNiveau() { return niveau; }
	    public Arme getArmeEquipee() { return armeEquipee; }
	    public Armure getArmureEquipee() { return armureEquipee; }
	    
	    public void afficherStats() {
	        System.out.println("\n=== " + nom + " (Niveau " + niveau + ") ===");
	        System.out.println("PV: " + pointsVie + "/" + pointsVieMax);
	        System.out.println("Attaque: " + getAttaque() + " | Defense: " + getDefense());
	        System.out.println("XP: " + experience + "/" + (niveau * 50));
	        System.out.println("Arme: " + (armeEquipee != null ? armeEquipee.getNom() : "Aucune"));
	        System.out.println("Armure: " + (armureEquipee != null ? armureEquipee.getNom() : "Aucune"));
	    }
}
