package designpatterns.exercises.state;

public interface INetworkDevice {
	void enable();
	void disable();
	void transmit();
	void receive();
	void suspend();
	void resume();
}
