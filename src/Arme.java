
enum Type{ // on créer une classe énum du type de dégat
		Direct,
		Explosif,
		Guide;
	}

public class Arme {
	
	private String nom;
	private int degatMIN;
	private int degatMAX;
	private Type typeDegat;
	
	
	
	public Arme(String nom, int degatMIN, int degatMAX,Type typeDegat){
		this.nom=nom;
		this.degatMIN=degatMIN;
		this.degatMAX=degatMAX;
		this.typeDegat=typeDegat;
	}
	
	public double degatMoy(){ // méthode qui renvoie les degat moyen DE L'ARME
		double degatMOY=0;
		degatMOY=(degatMIN+degatMAX)/2;
		return degatMOY;
	}
	
	@Override
	public String toString(){  // permet d'afficher les infos de l'arme ( utilie pour la classe vaisseau)
		String infoArme="";
		infoArme=nom+" type dégat: "+typeDegat+" dégat MIN MAX : ("+degatMIN+";"+degatMAX+")";
		return infoArme;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public int getDegatMIN() {
		return degatMIN;
	}



	public void setDegatMIN(int degatMIN) {
		this.degatMIN = degatMIN;
	}



	public int getDegatMAX() {
		return degatMAX;
	}



	public void setDegatMAX(int degatMAX) {
		this.degatMAX = degatMAX;
	}



	public Type getTypeDegat() {
		return typeDegat;
	}



	public void setTypeDegat(Type typeDegat) {
		this.typeDegat = typeDegat;
	}


	
	
	
	
	
}
