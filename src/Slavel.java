
public class Slavel extends Vaisseau{

	public Slavel() throws ArmurerieException{
		super(30,0);
		ajoutArme(Armurerie.getInstance().getArme("hammer"));
	}

	@Override
	public void attaque(Vaisseau vaisseau) {
		for(Arme arme: listeArmesVaisseau){
			vaisseau.repartirDegat(arme.tir());
			if(arme.getTypeDegat()==Type.Explosif){ // si le type de l'arme est directe on remet directement � 1 le compteur apr�s avoir tir�
				arme.setCompteutToursRecharge(1);
			}
		}
	}

}
