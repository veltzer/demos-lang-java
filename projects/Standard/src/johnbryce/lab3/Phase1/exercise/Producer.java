package johnbryce.lab3.Phase1.exercise;

public class Producer implements Runnable
{
	String producerId;
	Stack s;

	public Producer(String producerId, Stack s){
		this.producerId=producerId;
		this.s = s;
	}

	public void run(){
		for(int i = 0; i <20; i++){
			//enter text here
		}
	}
}
