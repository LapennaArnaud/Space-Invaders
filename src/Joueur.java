
public class Joueur {

	private final String nom;
	private final String prenom;
	private String pseudo;
	private Vaisseau vaisseau;
	
	public Joueur(String nom,String prenom,String pseudo){
		this.nom=formatage(nom);
		this.prenom=formatage(prenom);
		this.pseudo=pseudo;
		vaisseau = new Vaisseau(600, 200); // initialise le vaisseau type (par défaut 600 structure et 200 armure)  
	}
	
	
	
	private static String formatage(String str){  // méthode permettant de formater nom , prénom avec une majuscule au début.
		return str=str.substring(0,1).toUpperCase() + str.substring(1);
	}

	


	public String getPrenomNom() {
		return prenom+" "+nom;
	}



	public String getPseudo() {
		return pseudo;
	}



	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	


	public Vaisseau getVaisseau() {
		return vaisseau;
	}



	public void setVaisseau(Vaisseau vaisseau) {
		this.vaisseau = vaisseau;
	}



	@Override
	public String toString(){
		String infoJoueur="";
		infoJoueur=pseudo+"("+getPrenomNom()+")";
		return infoJoueur;
	}
	
	
	@Override
	public boolean equals(Object obj){
		if(obj== null)
			return false;
		if(!(obj instanceof Joueur))
			return false;
		
		Joueur j = (Joueur)obj;
		if(this.pseudo==j.getPseudo()){
			return true;
		}
		return false;
	}


	
	
	
	
	
}
