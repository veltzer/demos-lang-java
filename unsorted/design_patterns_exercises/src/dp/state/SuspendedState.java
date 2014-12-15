/*
 * Created on Feb 9, 2006
 */
package dp.state;

public class SuspendedState extends AbstractDeviceState
{

	public SuspendedState(NetworkDevice device)
	{
		super(device);
	}

	public void resume()
	{
		device.setState( device.ENABLED_STATE );
	}

	public void disable()
	{
		device.setState( device.DISABLED_STATE );
	}

}
