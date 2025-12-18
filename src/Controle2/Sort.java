package Controle2;

public class Sort extends ObjetInventaire {
    private int puissance;
    private boolean estDefensif;

    public Sort(String nom, int puissance, boolean estDefensif, int prix) {
        super(nom, prix);
        this.puissance = puissance;
        this.estDefensif = estDefensif;
    }

    public int getPuissance() {
        return puissance;
    }
    
    public boolean estDefensif() { 
        return estDefensif; 
    }

    @Override
    public String toString() {
        String type = estDefensif ? "Defense" : "Attaque";
        return nom + " (" + type + ":" + puissance + ", " + prix + " intcoins)";
    }
}