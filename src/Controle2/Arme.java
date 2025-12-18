package Controle2;

public class Arme extends ObjetInventaire {
private int pointsAttaque;
    
    public Arme(String nom, int pointsAttaque, int prix) {
        super(nom, prix);
        this.pointsAttaque = pointsAttaque;
    }
    
    public int getPointsAttaque() {
    	return pointsAttaque; 
    	}
    
    public void ameliorer(int bonus) { 
    	this.pointsAttaque += bonus; 
    	}
    
    @Override
    public String toString() {
        return nom + " (ATK+" + pointsAttaque + ", " + prix + " intcoins)";
    }
}
