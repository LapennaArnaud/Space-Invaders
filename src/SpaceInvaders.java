import java.util.ArrayList;

public class SpaceInvaders {

	private ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	private ArrayList<Vaisseau> listeVaisseauEnnemis = new ArrayList<Vaisseau>();
	
	
	
	public SpaceInvaders() throws ArmurerieException{
		init();
	}
	
	
	
	public static void main(String[] args) throws ArmurerieException {
		SpaceInvaders spaceInvaders = new SpaceInvaders();
		Armurerie armurerie = Armurerie.getInstance(); // pour éviter de marquer le getInstance() à chaque fois dans le main
		
		
		 
		
		// affichage des joueurs
		System.out.println("\nListe des joueurs :");
		for (Joueur j : spaceInvaders.listeJoueurs){
			System.out.println(j.toString());
		}
		
		//affichage de l'armurerie
		System.out.println("\nListe des armes de l'armurerie :");
		armurerie.afficherLesArmes();
		
		//on ajoute des armes aux vaisseaux... ( un vaisseau doit-il avoir une arme de base ?)
		spaceInvaders.listeJoueurs.get(0).getVaisseau().ajoutArme(armurerie.getListeArmes().get(1));
		


		
		//affichage des propriétés du vaisseau de chaque joueurs :
		System.out.println("\nAffichage des propriétés du vaisseau de chaque joueurs :");
		for (Joueur j : spaceInvaders.listeJoueurs){
			System.out.println("Joueur :");
			System.out.println(j.toString());
			System.out.println("son vaisseau :");
			System.out.println(j.getVaisseau().toString());
			j.getVaisseau().afficherLesArmes(); // on appelle la fonction qui affiche les armes, elle n'est pas comprise dans le toString du vaisseau car elle printLn directement sans renurn un string ( non demandé) 
			System.out.println("\n");
		}
		
		
		/*
		 * 
		 * ici on va faire la partie 4 du TP2 ( le dessus était pour tester les méthodes des classes du TP1)
		 * 
		 * 
		 */
		
		
		
	}
	
	
	
	
	private void init() throws ArmurerieException{
		Joueur j1 = new Joueur("groll", "julien", "nomtroswag");
		//Joueur j2 = new Joueur("lapenna", "arnaud", "arnotos");
		//Joueur j3 = new Joueur("muller", "william", "uliak");
		
		listeJoueurs.add(j1);
		//listeJoueurs.add(j2);
		//listeJoueurs.add(j3);
		
		// on charge la liste des vaisseaux ennemis avec chacun des vaisseaux. le viper est le vaisseau du joueur donc pas un vaisseau enemie
		listeVaisseauEnnemis.add(new Dart());
		listeVaisseauEnnemis.add(new Slavel());
		listeVaisseauEnnemis.add(new Alkesh());
		listeVaisseauEnnemis.add(new Tardis());
		listeVaisseauEnnemis.add(new Assault());
	}
	
	public void tour(){
		for(Vaisseau ennemie: listeVaisseauEnnemis){
			ennemie.attaque(listeJoueurs.get(0).getVaisseau());//on attaque le seul joueur du jeu ici
		}
		listeJoueurs.get(0).getVaisseau().attaque(listeVaisseauEnnemis.get((int)(Math.random()*(listeVaisseauEnnemis.size()))));
	
		
		for(Vaisseau ennemie: listeVaisseauEnnemis){
			
		}
		
		for(Joueur joueur: listeJoueurs){
			
		}
	}
	
	
}
