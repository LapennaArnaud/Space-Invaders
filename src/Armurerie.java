import java.util.ArrayList;

public class Armurerie {
	
	private static Armurerie instanceArmurerie;
	private ArrayList<Arme> listeArmes = new ArrayList<Arme>();
	
	private Armurerie(){
		init(); // initialise l'armurierie
	}
	
	public void init(){
				
		listeArmes.add(new Arme("bazooka", 40, 99, Type.Explosif,3));
		listeArmes.add(new Arme("tourelle",18,45,Type.Direct,1));
		listeArmes.add(new Arme("laser",2,3,Type.Direct,1));
		listeArmes.add(new Arme("hammer",1,8,Type.Explosif,1.5));
		listeArmes.add(new Arme("torpille",3,3,Type.Guide,2));
		listeArmes.add(new Arme("mitrailleuse",2,3,Type.Direct,1));
		listeArmes.add(new Arme("emg",1,7,Type.Explosif,1.5));
		listeArmes.add(new Arme("missile",4,100,Type.Guide,4));
	}

	public ArrayList<Arme> getListeArmes() {
		return listeArmes;
	}

	public void setListeArmes(ArrayList<Arme> listeArmes) {
		this.listeArmes = listeArmes;
	}
	
	public void afficherLesArmes(){ // affiche toutes les armes présente dans l'armurerie avec le toString de  la classe Arme
		if(listeArmes!=null){
			for(Arme arme : listeArmes){
				System.out.println(arme.toString());
			}
		}
	}
	
	
	public void ajoutArme(Arme arme){ // ajout des armes à l'armurerie
		if (listeArmes!= null){
			listeArmes.add(arme);
			System.out.println("arme ajoutée à l'armurerie");
		}		
	}
	
	public void enleveArme(Arme arme){ // on enlève une arme à l'armurerie
		if(listeArmes!=null){ // on regarde si la liste est non null
			if(listeArmes.remove(arme)){ // utilise la fonction remove de List qui renvoie true si il y a l'objet présent et le retire...
				System.out.println("arme retirée");
			}else{
				System.out.println("remove de l'arme impossible: il n'y a pas cette arme dans l'armurerie");
			}
		}
		
	}
	
	public boolean contientArme(Arme a){
		return (listeArmes.contains(a));
	}
	
	public Arme getArme(String nomArme) throws ArmurerieException { // pour rechercher une arme avec son nom
		for(Arme arme : this.listeArmes){
			if(arme.getNom() == nomArme)
				return arme;
		}
		throw new ArmurerieException();
	}
	
	public static Armurerie getInstance(){
		if(instanceArmurerie==null){
			instanceArmurerie=new Armurerie();
		}
		return instanceArmurerie;
	}
	
}
