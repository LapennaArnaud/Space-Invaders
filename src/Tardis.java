import java.util.ArrayList;
import java.util.Random;

public class Tardis extends Vaisseau implements IAptitude{

	public Tardis() throws ArmurerieException{
		super(1,0);
		
	}
	
	@Override
	public void attaque(Vaisseau vaisseau) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int utilise(ArrayList<Vaisseau> lesVaisseaux) { // déplace les vaisseaux
		Random rand = new Random();
		int index1 = rand.nextInt(lesVaisseaux.size());
		int index2 = rand.nextInt(lesVaisseaux.size());
		
		System.out.println("Le tardis échange le vaiseau à la place " + index1 + " avec le vaisseau à la place " +index2);
		System.out.println(lesVaisseaux.get(index1).getClass()+" <=> " +lesVaisseaux.get(index2).getClass());
		Vaisseau vaisseau = lesVaisseaux.get(index1); // change les positions des deux vaisseaux
		lesVaisseaux.set(index1, lesVaisseaux.get(index2));
		lesVaisseaux.set(index2, vaisseau);
		return 0;
	}

}
