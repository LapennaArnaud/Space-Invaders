
public class ViperMKII extends Vaisseau{

	public ViperMKII() throws ArmurerieException{
		super(100,15);
		ajoutArme(Armurerie.getInstance().getArme("mitrailleuse")); 
		ajoutArme(Armurerie.getInstance().getArme("emg")); 
		ajoutArme(Armurerie.getInstance().getArme("missile"));
		
	}

	
	
	@Override
	public void attaque(Vaisseau vaisseau) {
		int indexArme=0;
		double degatMax=0;
		int degatArmeEffectue=0;
		for(Arme arme: listeArmesVaisseau){
			if(arme.getCompteutToursRecharge()<= 0){ // on va chercher l'arme a utiliser sans utiliser sa fonction tir() sinon ça va modifier son comtpeur juste pour comparer
				if(arme.degatMoy()>degatMax){
					degatMax=arme.degatMoy(); // on se base sur l'arme a utiliser qui a la meilleure moyenne de degat
					indexArme=listeArmesVaisseau.indexOf(arme);
				}
			}else{
				arme.rechargeUnTour();
			}
		}
		
		degatArmeEffectue=listeArmesVaisseau.get(indexArme).tir();//je stocke les dégat dans une variable pour pouvoir la print
		vaisseau.repartirDegat(degatArmeEffectue);// on tir avec l'arme choisie juste avant
		
		//affichage des info de l'attaque par le viper (vaisseau du joueur)
		System.out.println("Le Viper tir avec: "+listeArmesVaisseau.get(indexArme).toString()+ "\t sur: "+vaisseau.getClass().getName()+" (-"+degatArmeEffectue+" points)");
		
		//vaisseau.repartirDegat(listeArmesVaisseau.get(indexArme).tir());// on tir avec l'arme choisie juste avant
	}
	
	

}
