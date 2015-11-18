package johnbryce.lab5.solution;

public abstract class LoadClass {

	public static void main(String[] args) throws Exception {
		Loader loader = new Loader("c:/class.xml");
		System.out.println(loader.load());
	}

}
