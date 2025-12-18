package Controle2;

public class Potion extends ObjetInventaire {
private int pointsSoin;
    
    public Potion(String nom, int pointsSoin, int prix) {
        super(nom, prix);
        this.pointsSoin = pointsSoin;
    }
    
    public int getPointsSoin() { return pointsSoin; }
    
    @Override
    public String toString() {
        return nom + " (+" + pointsSoin + " PV, " + prix + " intcoins)";
    }
}
