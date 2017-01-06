
public class Slavel extends Vaisseau{

	public Slavel() throws ArmurerieException{
		super(30,0);
		ajoutArme(Armurerie.getInstance().getArme("hammer"));
	}

	@Override
	public void attaque(Vaisseau vaisseau) {
		for(Arme arme: listeArmesVaisseau){
			vaisseau.repartirDegat(arme.tir());
			if(arme.getTypeDegat()==Type.Explosif){ // si le type de l'arme est directe on remet directement à 1 le compteur après avoir tiré
				arme.setCompteutToursRecharge(1);
			}
		}
	}

}
