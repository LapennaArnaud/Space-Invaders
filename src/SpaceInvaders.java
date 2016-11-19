import java.util.ArrayList;

public class SpaceInvaders {

	private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	private static Armurerie armurerie = new Armurerie();
	
	
	
	public SpaceInvaders(){
		init();
	}
	
	
	
	public static void main(String[] args) {
		SpaceInvaders spaceInvaders = new SpaceInvaders();
		
		// affichage des joueurs
		System.out.println("\nListe des joueurs :");
		for (Joueur j : spaceInvaders.listeJoueurs){
			System.out.println(j.toString());
		}
		
		//affichage de l'armurerie
		System.out.println("\nListe des armes de l'armurerie :");
		armurerie.afficherLesArmes();
		
		Vaisseau vaisseuDeOuf = new  Vaisseau(1800, 680);
		spaceInvaders.listeJoueurs.get(1).setVaisseau(vaisseuDeOuf);
		
		//affichage des propriétés du vaisseau de chaque joueurs :
		System.out.println("\nAffichage des propriétés du vaisseau de chaque joueurs :");
		for (Joueur j : spaceInvaders.listeJoueurs){
			System.out.println("Joueur :");
			System.out.println(j.toString());
			System.out.println("son vaisseau :");
			System.out.println(j.getVaisseau().toString());
			System.out.println("\n");
		}
		
		
		//////////
		// je n'ai pas eu le temps d'ajouter des armes au vaisseau des joueurs ( par défaut ils n'ont pas d'armes) donc 0 total dégat
		// il y a aussi plusieurs toString que j'ai codé et dont je n'ai pas eu le temps d'utiliser dans le main.
		///////
		
		
		
	}
	
	
	
	
	private void init(){
		Joueur j1 = new Joueur("groll", "julien", "nomtroswag");
		Joueur j2 = new Joueur("lapenna", "arnaud", "arnotos");
		Joueur j3 = new Joueur("muller", "william", "uliak");
		
		listeJoueurs.add(j1);
		listeJoueurs.add(j2);
		listeJoueurs.add(j3);
	}
	
}
