package addressbook.service;

public class Address {
	private String country;
	private String city;
	private String street;
	private int num;

	public String getCity() {
		return city;
	}
	public void setCity(String icity) {
		city = icity;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String icountry) {
		country = icountry;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int inum) {
		num = inum;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String istreet) {
		street = istreet;
	}
}
