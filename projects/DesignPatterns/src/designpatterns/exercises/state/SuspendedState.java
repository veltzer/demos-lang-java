package designpatterns.exercises.state;

public class SuspendedState extends AbstractDeviceState {
	public SuspendedState(NetworkDevice device) {
		super(device);
	}
	public void resume() {
		getDevice().setState(getDevice().getEnabledState());
	}
	public void disable() {
		getDevice().setState(getDevice().getDisableState());
	}
}
