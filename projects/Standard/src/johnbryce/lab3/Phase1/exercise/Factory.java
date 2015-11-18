package johnbryce.lab3.Phase1.exercise;

public class Factory
{
	public static void main(String[] args)
	{
		Stack myStack = new Stack();
		Producer producer=new Producer("producer", myStack);
		Consumer consumer=new Consumer("consumer", myStack);

		Thread [] threads=new Thread[4];
		for(int i=0;i<2;i++){
			threads[i]=new Thread(producer);
			threads[i+2]=new Thread(consumer);
		}
		for(Thread t:threads){
			t.start();
		}
	}
}
