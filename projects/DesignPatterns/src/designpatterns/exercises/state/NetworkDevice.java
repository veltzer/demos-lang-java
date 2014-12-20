package designpatterns.exercises.state;

public class NetworkDevice implements INetworkDevice
{
	private AbstractDeviceState currentState;
	public final AbstractDeviceState DISABLED_STATE = new DisabledState(this);
	public final AbstractDeviceState ENABLED_STATE = new EnabledState(this);
	public final AbstractDeviceState SUSPENDED_STATE = new SuspendedState(this);

	public NetworkDevice()
	{
		super();
		currentState = DISABLED_STATE;
	}

	public void enable()
	{
		currentState.enable();
	}

	public void disable()
	{
		currentState.disable();
	}

	public void transmit()
	{
		currentState.transmit();
	}

	public void receive()
	{
		currentState.receive();
	}

	public void suspend()
	{
		currentState.suspend();
	}

	public void resume()
	{
		currentState.resume();
	}

	public void setState(AbstractDeviceState newState)
	{
		currentState = newState;
		System.out.println("State changed to: " + newState.getClass().getName());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			NetworkDevice device = new NetworkDevice();
			device.enable();
			device.transmit();
			device.suspend();
			device.receive();
			device.resume();
			device.disable();

			System.out.println("Done");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
