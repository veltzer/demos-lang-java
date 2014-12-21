package ejbwl.exercises.solutions.source.dtos;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	private String id;
	private String name;
	private String email;
	private String address;

	public CustomerDTO(String iid, String iname, String iemail, String iaddress) {
		id = iid;
		name = iname;
		email = iemail;
		address = iaddress;
	}
	public String getAddress() {
		return address;
	}
	public String getEmail() {
		return email;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String string) {
		address = string;
	}
	public void setEmail(String string) {
		email = string;
	}
	public void setId(String string) {
		id = string;
	}
	public void setName(String string) {
		name = string;
	}
	public String toString() {
		return "CustomerDTO id:" + id + " name:" + name + " email:" + email + " address:" + address;
	}
}
