package designpatterns.exercises.state;

public class EnabledState extends AbstractDeviceState {
	public EnabledState(NetworkDevice device) {
		super(device);
	}
	public void disable() {
		device.setState(device.DISABLED_STATE);
	}
	public void suspend() {
		device.setState(device.SUSPENDED_STATE);
	}
	public void transmit() {
		System.out.println("Transmitting");
	}
	public void receive() {
		System.out.println("receiving");
	}
}
