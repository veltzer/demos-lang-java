package ejb_exercises.solutions.source.dtos;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerDTO implements Serializable{
	private String id;
	private String name;
	private String email;
	private String address;

	public CustomerDTO(String id, String name, String email, String address){
		this.id=id;
		this.name = name;
		this.email=email;
		this.address = address;
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

	public String toString(){
		return "CustomerDTO id:"+ id + " name:"+name+ " email:"+email + " address:"+address;
	}
}
