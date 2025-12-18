package Controle2;

public class Monstre implements Combattant {
	protected String nom;
    protected int pointsVie;
    protected int pointsVieMax;
    protected int attaque;
    protected int defense;
    protected int recompenseIntcoins;
    
    public Monstre(String nom, int pv, int attaque, int defense, int recompense) {
        this.nom = nom;
        this.pointsVieMax = pv;
        this.pointsVie = pv;
        this.attaque = attaque;
        this.defense = defense;
        this.recompenseIntcoins = recompense;
    }
    
    
    public String getNom() { return nom; }
    
    
    public int getPointsVie() { return pointsVie; }
    
    
    public int getPointsVieMax() { return pointsVieMax; }
    
    
    public int getAttaque() { return attaque; }
    
    
    public int getDefense() { return defense; }
    
    
    public int attaquer() {
        return attaque + (int)(Math.random() * 3);
    }
    
    
    public void recevoirDegats(int degats) {
        int degatsReels = Math.max(1, degats - defense);
        pointsVie = Math.max(0, pointsVie - degatsReels);
        System.out.println(nom + " reçoit " + degatsReels + " dégâts ! PV: " + pointsVie + "/" + pointsVieMax);
    }
    
    
    public boolean estVivant() {
        return pointsVie > 0;
    }
    
    public int getRecompenseIntcoins() { 
    	return recompenseIntcoins; 
    	}
    
    
}
