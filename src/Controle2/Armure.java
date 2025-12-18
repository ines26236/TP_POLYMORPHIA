package Controle2;

public class Armure extends ObjetInventaire{
private int pointsDefense;
    
    public Armure(String nom, int pointsDefense, int prix) {
        super(nom, prix);
        this.pointsDefense = pointsDefense;
    }
    
    public int getPointsDefense() {
    	return pointsDefense; 
    	}
    public void ameliorer(int bonus) { 
    	this.pointsDefense += bonus; 
    	}
    
    @Override
    public String toString() {
        return nom + " (DEF+" + pointsDefense + ", " + prix + " intcoins)";
    }
}
