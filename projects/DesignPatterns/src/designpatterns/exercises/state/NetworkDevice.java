package designpatterns.exercises.state;

public class NetworkDevice implements INetworkDevice {
	private AbstractDeviceState currentState;
	private final AbstractDeviceState disabledState = new DisabledState(this);
	private final AbstractDeviceState enabledState = new EnabledState(this);
	private final AbstractDeviceState suspendedState = new SuspendedState(this);

	public NetworkDevice() {
		super();
		currentState = disabledState;
	}

	public void enable() {
		currentState.enable();
	}

	public void disable() {
		currentState.disable();
	}

	public void transmit() {
		currentState.transmit();
	}

	public void receive() {
		currentState.receive();
	}

	public void suspend() {
		currentState.suspend();
	}

	public void resume() {
		currentState.resume();
	}

	public void setState(AbstractDeviceState newState) {
		currentState = newState;
		System.out
				.println("State changed to: " + newState.getClass().getName());
	}

	public static void main(String[] args) {
		try {
			NetworkDevice device = new NetworkDevice();
			device.enable();
			device.transmit();
			device.suspend();
			device.receive();
			device.resume();
			device.disable();
			System.out.println("Done");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public AbstractDeviceState getDisableState() {
		return disabledState;
	}

	public AbstractDeviceState getEnabledState() {
		return enabledState;
	}

	public AbstractDeviceState getSuspendedState() {
		return suspendedState;
	}
}
