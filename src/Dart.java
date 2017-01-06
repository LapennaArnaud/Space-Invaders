
public class Dart extends Vaisseau {

	

	public Dart () throws ArmurerieException{
		super(3,10);
		ajoutArme(Armurerie.getInstance().getArme("laser")); // l'exception est traité dans la méthode ajoutArme du visseau
		
	}

	@Override
	public void attaque(Vaisseau vaisseau) {
		for(Arme arme: listeArmesVaisseau){
			vaisseau.repartirDegat(arme.tir());
			if(arme.getTypeDegat()==Type.Direct){ // si le type de l'arme est directe on remet directement à 1 le compteur après avoir tiré
				arme.setCompteutToursRecharge(1);
			}
		}
	}

}
