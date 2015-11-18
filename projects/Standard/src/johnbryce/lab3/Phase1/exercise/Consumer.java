package johnbryce.lab3.Phase1.exercise;

public class Consumer implements Runnable
{
	String consumerId;
	Stack s;

	public Consumer(String consumerId, Stack s){
		this.consumerId=consumerId;
		this.s = s;
	}

	public void run(){
		for(int i = 0; i <20; i++){
			//enter text here
		}
	}
}
