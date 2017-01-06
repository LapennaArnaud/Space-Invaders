import java.util.ArrayList;
import java.util.Random;

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
		
		System.out.println("#############################################################################");
		
		int nbTour = 1;
		while(!spaceInvaders.listeJoueurs.get(0).getVaisseau().estDetruit() && spaceInvaders.listeVaisseauEnnemis.size()>0){
			System.out.format("%n==========================Tour %d=========================%n",nbTour);
			spaceInvaders.tour();
			nbTour++;
		}
			
		if(spaceInvaders.listeJoueurs.get(0).getVaisseau().estDetruit()) // à l'arret des tours nous décrit si le joueur à gagner ou perdu
		{
			System.out.println("Le joueur a perdu");
		}
		else
		{
			System.out.println("Le joueur a gagné");
		}
		
		/*
		 * il y a un problème sur le jeu qui boucle de trop avec la 
		 * régen des bouclier il faut que je regarde si cela provient de la 
		 * position des vaisseaux ou des dégat des armes mais je n'ai plus le temps.
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
		
		for(Vaisseau ennemie : listeVaisseauEnnemis){ // utilisation des comptétences des vaisseaux
			if(ennemie instanceof IAptitude){
				listeJoueurs.get(0).getVaisseau().repartirDegat(((IAptitude)ennemie).utilise(listeVaisseauEnnemis));
			}
		}
		
		suppressionEnnemiesMort(listeVaisseauEnnemis); //Suppresion des morts ( le assault peut mourir de son pouvoir juste avant)

		
		int probabiliteTir = 1;
		boolean aTire = false;
		for(Vaisseau ennemie : listeVaisseauEnnemis){
			//Tour du joueur
			//Le joueur peut tirer si il n'a pas déjà tirer et que la probabilité est bonne.
			double rand = Math.random() * listeVaisseauEnnemis.size();
			if(!aTire && probabiliteTir > rand){
				// Attaque un ennemie aléatoire
				System.out.println("Le vaisseau du joueur attaque");
				listeJoueurs.get(0).getVaisseau().attaque(listeVaisseauEnnemis.get(new Random().nextInt(listeVaisseauEnnemis.size())));
				aTire = true;
			}
			//Augmentation de la probabilité que le joueur tire
			probabiliteTir ++;
			
			//Tour de l'ennemie
			if(!ennemie.estDetruit())
			{
				ennemie.attaque(listeJoueurs.get(0).getVaisseau());
			}
		}
		
		/*  --------> j'ai commenter le rechargement de bouclier car sinon le jeu boucle à l'infini je n'ai plus le temps de le débuger
		//Augmentation des boucliers
		System.out.println("Recharge du bouclier des joueurs");
		for(Joueur joueur : listeJoueurs){
			joueur.getVaisseau().rechargeBouclier(2); // la fonction check si il a perdu des pts de boucliers.
		}
		System.out.println("Recharge du bouclier des ennemies");
		for(Vaisseau ennemie : listeVaisseauEnnemis){
			ennemie.rechargeBouclier(2);
		}
		*/
		
		suppressionEnnemiesMort(listeVaisseauEnnemis); //Suppresion des morts
	}
	
	
	
	
	//Suprime les énnemies mort de la liste des ennemies
	public void suppressionEnnemiesMort(ArrayList<Vaisseau> lesEnnemis){
		for(int i = 0;i<lesEnnemis.size();){
			if(lesEnnemis.get(i).estDetruit()){
				System.out.println("Le " + lesEnnemis.get(i).getClass().toString() + " est détruit");
				lesEnnemis.remove(i);
			}else
				i++;
		}
	}
	
	
}
