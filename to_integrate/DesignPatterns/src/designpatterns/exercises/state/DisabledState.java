package designpatterns.exercises.state;

public class DisabledState extends AbstractDeviceState {
	public DisabledState(NetworkDevice device) {
		super(device);
	}

	public void enable() {
		getDevice().setState(getDevice().getEnabledState());
	}
}
