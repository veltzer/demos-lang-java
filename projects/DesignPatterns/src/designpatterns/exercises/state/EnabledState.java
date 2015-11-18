package designpatterns.exercises.state;

public class EnabledState extends AbstractDeviceState {
	public EnabledState(NetworkDevice device) {
		super(device);
	}

	public void disable() {
		getDevice().setState(getDevice().getDisableState());
	}

	public void suspend() {
		getDevice().setState(getDevice().getSuspendedState());
	}

	public void transmit() {
		System.out.println("Transmitting");
	}

	public void receive() {
		System.out.println("receiving");
	}
}
