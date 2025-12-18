package Controle2;

public class Materia extends ObjetInventaire{
	 private int bonusAmelioration;
	    
	    public Materia(String nom, int bonusAmelioration, int prix) {
	        super(nom, prix);
	        this.bonusAmelioration = bonusAmelioration;
	    }
	    
	    public int getBonusAmelioration() { return bonusAmelioration; }
	    
	    @Override
	    public String toString() {
	        return nom + " (+" + bonusAmelioration + ", " + prix + " intcoins)";
	    }
}
