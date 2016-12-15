import java.util.ArrayList;

public class Vaisseau {
	
	private int ptnDeStructureMAX;
	private int ptnDeBouclierMAX;
	
	private int ptnDeStructure;
	private int ptnDeBouclier;
	
	private boolean estDetruit=false;
	
	private ArrayList<Arme> listeArmesVaisseau = new ArrayList<Arme>();
	
	
	public Vaisseau(int ptnDeStructureMAX,int ptnDeBouclierMAX){
		this.ptnDeStructureMAX=ptnDeStructureMAX;
		this.ptnDeBouclierMAX=ptnDeBouclierMAX;
		ptnDeStructure=ptnDeStructureMAX;
		ptnDeBouclier=ptnDeBouclierMAX;
	}
	
	public void ajoutArme(Arme arme){
		if (listeArmesVaisseau!= null){
			if (listeArmesVaisseau.size()<3 ){
				listeArmesVaisseau.add(arme); // faire attention car ici ont peut lui ajouter des armes qui ne sont pas dans l'armurerie ( correction future)
			}else{
				System.out.println("ajout arme impossible : il n'y a plus de place sur le vaisseau");
			}
		}		
	}
	
	public void enleveArme(Arme arme){
		if(listeArmesVaisseau!=null){ // on regarde si la liste est non null
			if(listeArmesVaisseau.remove(arme)){ // utilise la fonction remove de List qui renvoie true si il y a l'objet présent et le retire...
				System.out.println("arme retirée");
			}else{
				System.out.println("remove de l'arme impossible: il n'y a pas cette arme sur le vaisseau");
			}
		}
		
	}
	
	public void afficherLesArmes(){ // affiche toutes les armes présente sur le vaisseau avec le toString de  la classe Arme
		if(listeArmesVaisseau!=null){
			for(Arme arme : listeArmesVaisseau){
				System.out.printf("Arme n°"+(listeArmesVaisseau.indexOf(arme)+1)+": ");
				System.out.println(arme.toString());
			}
		}
	}

	public double calculTotDegatMOY(){
		double degatMoy=0;
		
		if(listeArmesVaisseau!=null){
			for(Arme arme : listeArmesVaisseau){
				degatMoy=degatMoy+arme.degatMoy();
			}
			if(listeArmesVaisseau.size()!=0)
				degatMoy=degatMoy/listeArmesVaisseau.size();
		}
		
		return degatMoy;
	}
	
	@Override
	public String toString(){  // permet d'afficher les infos du vaisseau( utile pour la classe space invaders)
		String infoVaisseau="";
		infoVaisseau="Pts de structure Max: "+ptnDeStructureMAX+" Pts de bouclier: "+ptnDeBouclierMAX+" Dégat moyen : "+calculTotDegatMOY();
		return infoVaisseau;
	}
	
	// les getters et setters 

	public int getPtnDeStructureMAX() {
		return ptnDeStructureMAX;
	}


	public void setPtnDeStructureMAX(int ptnDeStructureMAX) {
		this.ptnDeStructureMAX = ptnDeStructureMAX;
	}


	public int getPtnDeBouclierMAX() {
		return ptnDeBouclierMAX;
	}


	public void setPtnDeBouclierMAX(int ptnDeBouclierMAX) {
		this.ptnDeBouclierMAX = ptnDeBouclierMAX;
	}


	public int getPtnDeStructure() {
		return ptnDeStructure;
	}


	public void setPtnDeStructure(int ptnDeStructure) {
		this.ptnDeStructure = ptnDeStructure;
	}


	public int getPtnDeBouclier() {
		return ptnDeBouclier;
	}


	public void setPtnDeBouclier(int ptnDeBouclier) {
		this.ptnDeBouclier = ptnDeBouclier;
	}


	public boolean isEstDetruit() {
		return estDetruit;
	}


	public void setEstDetruit(boolean estDetruit) {
		this.estDetruit = estDetruit;
	}

	public ArrayList<Arme> getListeArmesVaisseau() {
		return listeArmesVaisseau;
	}

	public void setListeArmesVaisseau(ArrayList<Arme> listeArmesVaisseau) {
		this.listeArmesVaisseau = listeArmesVaisseau;
	}
	
	
	
	
	//j'ai mal lu le sujet et j'ai commencé a coder la fonction non demandé encore
	/**public boolean estDetruit(){
		if(this.ptnDeBouclier && this.ptnDeStructure <= 0){
			return true;
		}
		return false;
	}*/
	
	
	
}
