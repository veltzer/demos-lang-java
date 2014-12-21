package designpatterns.exercises.state;

public class DisabledState extends AbstractDeviceState {
	public DisabledState(NetworkDevice device) {
		super(device);
	}
	public void enable() {
		device.setState(device.ENABLED_STATE);
	}
}
