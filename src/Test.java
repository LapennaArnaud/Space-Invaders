
public class Test {

	public static void main(String[] args) throws ArmurerieException {
		// TODO Auto-generated method stub
		
		Joueur j1 = new Joueur("lapenna", "arnaud", "arnotos");
		Joueur j2 = new Joueur("lapenna", "arnaddddud", "arnotos");
		System.out.println(j1.toString());
		
		System.out.println(j1.equals(j2));
		

	}

}
