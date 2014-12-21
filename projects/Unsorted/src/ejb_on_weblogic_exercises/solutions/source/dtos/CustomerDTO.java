package dtos;

import java.io.Serializable;

public class CustomerDTO implements Serializable{
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

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param string
	 */
	public void setAddress(String string) {
		address = string;
	}

	/**
	 * @param string
	 */
	public void setEmail(String string) {
		email = string;
	}

	/**
	 * @param string
	 */
	public void setId(String string) {
		id = string;
	}

	/**
	 * @param string
	 */
	public void setName(String string) {
		name = string;
	}

	public String toString() {
		return "CustomerDTO id:" + id + " name:" + name + " email:" + email + " address:" + address;
	}
}
