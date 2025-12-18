package Controle2;

public abstract class ObjetInventaire {
	protected String nom;
    protected int prix;
    
    public ObjetInventaire(String nom, int prix) {
        this.nom = nom;
        this.prix = prix;
    }
    
    public String getNom() { return nom; }
    public int getPrix() { return prix; }
	}

