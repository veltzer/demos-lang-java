package design_patterns_exercises.abstractfactory;

public class BuffTest
{

	public BuffTest()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int numObjects = 100000;
		Object[] array = new Object[numObjects];
		Object[] array2 = new Object[numObjects];
		for (int i = 0; i < array.length; ++i)
			array[i] = new StringBuffer();
		for (int i = 0; i < array.length; ++i)
			array[i] = new StringBuffer();
		for (int i = 0; i < array.length; ++i)
			array[i] = new StringBuffer();
		for (int i = 0; i < array.length; ++i)
			array[i] = new StringBuffer();
		long freeMem = Runtime.getRuntime().freeMemory();
		for (int i = 0; i < array.length; ++i)
			array2[i] = new StringBuffer();
		long endFreeMem = Runtime.getRuntime().freeMemory();
		System.out.println("start memory: " + freeMem);
		System.out.println("end memory: " + endFreeMem);
		System.out.println("Memory per object: " + ((freeMem-endFreeMem) / numObjects));
		System.out.println("array length: "+array.length ) ;
		System.out.println("array length: "+array2.length ) ;

	}

}
