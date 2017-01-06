import java.util.ArrayList;

public class Assault extends Vaisseau implements IAptitude {

	public Assault(){
		super(15,0);
	}
	
	@Override
	public void attaque(Vaisseau vaisseau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int utilise(ArrayList<Vaisseau> lesVaisseaux) { // il explose à la tronche du joueur
		if(lesVaisseaux.get(0) == this){
			this.ptnDeStructure = 0;
			this.estDetruit = true;
			System.out.println("Assault EXPLOOOOOOOOOSE!");
			return 10;
		}
		else
			return 0;
		
	}

}
