
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
	private double tempsRechargement = 3; // je l'initialise pour éviter des erreurs mais il va etre défini dans le constructeur.
	private double compteutToursRecharge;
	
	
	public Arme(String nom, int degatMIN, int degatMAX,Type typeDegat,double tempsRechargement){
		this.nom=nom;
		this.degatMIN=degatMIN;
		this.degatMAX=degatMAX;
		this.typeDegat=typeDegat;
		this.tempsRechargement=tempsRechargement;
		compteutToursRecharge=this.tempsRechargement;
	}
	
	public double degatMoy(){ // méthode qui renvoie les degat moyen DE L'ARME
		double degatMOY=0;
		degatMOY=(degatMIN+degatMAX)/2;
		return degatMOY;
	}
	
	public int tir(){
		int degat=0;
		compteutToursRecharge--;
		
		if(compteutToursRecharge <= 0){ // si elle peut tirer ( ici < = 0 car il y a des armes du tp qui ont 1.5 de tmps de recharge et on décrémente de 1)
			compteutToursRecharge=tempsRechargement;
			degat = (int)(Math.random()*((degatMAX+1)-degatMIN)+degatMIN); // dégatMax +1 car on veut qu'il soit inclu valeurs [min, max] 
		
			switch(typeDegat) {
				case Direct:
					if((int)(Math.random()*((10+1)-1)+1)==5){ // un math random de 1 à 10 à 1/10 chance de tomber sur 5...
						degat=0;
					}
					break;
				case Explosif:
					compteutToursRecharge*=2; // on le multiplie par 2
					if((int)(Math.random()*((4+1)-1)+1)==1){ // un math random de 1 à 4 à 1/4 chance de tomber sur 1...
						degat=0;
					}
					break;
				case Guide:
					degat=degatMIN;
					break;
				default:
					break;
			}
			
		}else{ // si le compteur est > à 0 il ne peut pas tirer donc dégat = 0
			degat = 0;
		}
		return degat;
	}
	
	@Override
	public String toString(){  // permet d'afficher les infos de l'arme ( utilie pour la classe vaisseau)
		String infoArme="";
		infoArme=nom+" type dégat: "+typeDegat+" dégat MIN MAX: ("+degatMIN+";"+degatMAX+")";
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

	public double getTempsRechargement() {
		return tempsRechargement;
	}

	public void setTempsRechargement(double tempsRechargement) {
		this.tempsRechargement = tempsRechargement;
	}

	public double getCompteutToursRecharge() {
		return compteutToursRecharge;
	}

	public void setCompteutToursRecharge(double compteutToursRecharge) {
		this.compteutToursRecharge = compteutToursRecharge;
	}

	
	

	
	
	
	
	
	
}
