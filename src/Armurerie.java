import java.util.ArrayList;

public class Armurerie {

	private ArrayList<Arme> listeArmes = new ArrayList<Arme>();
	
	public Armurerie(){
		init(); // initialise l'armurierie
	}
	
	public void init(){
		Arme bazooka = new Arme("bazooka", 40, 99, Type.Explosif);
		Arme tourelle = new Arme("tourelle",18,45,Type.Direct);
		Arme missile = new Arme("missile",28,66,Type.Guide);
		
		listeArmes.add(bazooka);
		listeArmes.add(tourelle);
		listeArmes.add(missile);
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
	
}
