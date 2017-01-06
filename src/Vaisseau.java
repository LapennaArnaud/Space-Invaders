import java.util.ArrayList;

public abstract class Vaisseau {
	
	protected int ptnDeStructureMAX;
	protected int ptnDeBouclierMAX;
	
	protected int ptnDeStructure;
	protected int ptnDeBouclier;
	
	protected boolean estDetruit=false;
	
	protected ArrayList<Arme> listeArmesVaisseau = new ArrayList<Arme>();
	
	public Vaisseau (int ptnDeStructureMAX,int ptnDeBouclierMAX) {
		this.ptnDeStructureMAX=ptnDeStructureMAX;
		this.ptnDeBouclierMAX=ptnDeBouclierMAX;
		ptnDeStructure=ptnDeStructureMAX;
		ptnDeBouclier=ptnDeBouclierMAX;		
	}
	
	public void ajoutArme(Arme arme) throws ArmurerieException{
		if (listeArmesVaisseau!= null){
			if (listeArmesVaisseau.size()< 3 ){	// ici toutes les conditions sont bonnes pour ajouter l'arme
				
				try {
				    if(Armurerie.getInstance().contientArme(arme)) { // on check si elle est bien dans l'armurerie
				    	listeArmesVaisseau.add(arme);
				    }else{
				    	throw new ArmurerieException();
				    }
				} catch(ArmurerieException e){
					e.printStackTrace();
				}
								
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
	
	public void repartirDegat(int degatDuTir){
		int difference;
		if(ptnDeBouclier>0 && ptnDeBouclier>=degatDuTir){
			ptnDeBouclier-=degatDuTir;
		}else if (ptnDeBouclier>0 && ptnDeBouclier<degatDuTir){ // ici les dégat sont supérieur au bouclier restant.
			difference = (degatDuTir-ptnDeBouclier);
			ptnDeBouclier=0;
			ptnDeStructure-=difference;
		}else{
			ptnDeStructure-=degatDuTir;
		}
	}
	
	public abstract void attaque(Vaisseau vaisseau);
	
	@Override
	public String toString(){  // permet d'afficher les infos du vaisseau( utile pour la classe space invaders)
		String infoVaisseau="";
		infoVaisseau="Pts de structure Max: "+ptnDeStructureMAX+" Pts de bouclier: "+ptnDeBouclierMAX+" Dégat moyen : "+calculTotDegatMOY();
		return infoVaisseau;
	}
	
	public boolean estDetruit(){
		if(this.ptnDeBouclier <=0 && this.ptnDeStructure <= 0){
			return true;
		}
		if(estDetruit){
			return true;
		}
		return false;
	}
	
	public void rechargeBouclier(int recharge){
		
		ptnDeBouclier += recharge;
		
		if(ptnDeBouclier > ptnDeBouclierMAX) // On ne peux pas avoir des boucliers supérieurs au maximum du bouclier
			ptnDeBouclier = ptnDeBouclierMAX;
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

	
}
