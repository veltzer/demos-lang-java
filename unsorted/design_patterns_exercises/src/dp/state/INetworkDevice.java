package dp.state;

public interface INetworkDevice
{
	public void enable();

	public void disable();

	public void transmit();

	public void receive();

	public void suspend();

	public void resume();
}
