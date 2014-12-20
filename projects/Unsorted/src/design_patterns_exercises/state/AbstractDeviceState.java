package design_patterns_exercises.state;

public class AbstractDeviceState implements INetworkDevice
{
	protected NetworkDevice device;

	public AbstractDeviceState(NetworkDevice device)
	{
		this.device = device;
	}

	public void enable()
	{
		throw new UnsupportedOperationException("enable not applicable for: "+this.getClass().getName());
	}

	public void disable()
	{
		throw new UnsupportedOperationException("disable not applicable for: "+this.getClass().getName());
	}

	public void transmit()
	{
		throw new UnsupportedOperationException("transmit not applicable for: "+this.getClass().getName());
	}

	public void receive()
	{
		throw new UnsupportedOperationException("receive not applicable for: "+this.getClass().getName());
	}

	public void suspend()
	{
		throw new UnsupportedOperationException("suspend not applicable for: "+this.getClass().getName());
	}

	public void resume()
	{
		throw new UnsupportedOperationException("resume not applicable for: "+this.getClass().getName());
	}
}
