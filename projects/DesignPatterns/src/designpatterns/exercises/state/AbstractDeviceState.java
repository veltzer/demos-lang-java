package designpatterns.exercises.state;

public class AbstractDeviceState implements INetworkDevice {
	private NetworkDevice device;

	public AbstractDeviceState(NetworkDevice idevice) {
		setDevice(idevice);
	}
	public void enable() {
		throw new UnsupportedOperationException("enable not applicable for: " + getClass().getName());
	}
	public void disable() {
		throw new UnsupportedOperationException("disable not applicable for: " + getClass().getName());
	}
	public void transmit() {
		throw new UnsupportedOperationException("transmit not applicable for: " + getClass().getName());
	}
	public void receive() {
		throw new UnsupportedOperationException("receive not applicable for: " + getClass().getName());
	}
	public void suspend() {
		throw new UnsupportedOperationException("suspend not applicable for: " + getClass().getName());
	}
	public void resume() {
		throw new UnsupportedOperationException("resume not applicable for: " + getClass().getName());
	}
	public NetworkDevice getDevice() {
		return device;
	}
	public void setDevice(NetworkDevice idevice) {
		device = idevice;
	}
}
