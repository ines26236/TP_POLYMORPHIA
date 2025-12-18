package Controle2;

public class Bestiaire {
	public static Monstre genererMonstreAleatoire() {
        int random = (int)(Math.random() * 4);
        switch(random) {
            case 0: return new Dragon();
            case 1: return new Zombie();
            case 2: return new Loup();
          
            default: return new Loup();
        }

}
}