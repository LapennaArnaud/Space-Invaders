
public class ViperMKII extends Vaisseau{

	public ViperMKII() throws ArmurerieException{
		super(10,15);
		ajoutArme(Armurerie.getInstance().getArme("mitrailleuse")); 
		ajoutArme(Armurerie.getInstance().getArme("emg")); 
		ajoutArme(Armurerie.getInstance().getArme("missile"));
		
	}

	@Override
	public void attaque(Vaisseau vaisseau) {
		int indexArme=0;
		double degatMax=0;
		for(Arme arme: listeArmesVaisseau){
			if(arme.getCompteutToursRecharge()<= 0){ // on va chercher l'arme a utiliser sans utiliser sa fonction tir() sinon ça va modifier son comtpeur juste pour comparer
				if(arme.degatMoy()>degatMax){
					degatMax=arme.degatMoy(); // on se base sur l'arme a utiliser qui a la meilleure moyenne de degat
					indexArme=listeArmesVaisseau.indexOf(arme);
				}
			}
		}
		vaisseau.repartirDegat(listeArmesVaisseau.get(indexArme).tir());// on tir avec l'arme choisie juste avant
	}

}
