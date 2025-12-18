package Controle2;

public interface Combattant {
	 int attaquer();
	    void recevoirDegats(int degats);
	    boolean estVivant();
	    int getPointsVie();
	    int getPointsVieMax();
	    int getAttaque();
	    int getDefense();
	    String getNom();
}
