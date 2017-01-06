
public class Alkesh extends Vaisseau {

	public Alkesh() throws ArmurerieException{
		super(3,5);
		ajoutArme(Armurerie.getInstance().getArme("torpille"));
		
	}

	@Override
	public void attaque(Vaisseau vaisseau) {
		for(Arme arme: listeArmesVaisseau){
			vaisseau.repartirDegat(arme.tir());
		}
	}

}
