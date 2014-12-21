package addressbook.client;

//import addressbook.client.proxy.*;

public abstract class AddressBookClient {
	public static void main(String[] args) {
		AddressBookService service = new AddressBookService();
		AddressBook port = service.getAddressBookPort();
		Address addr1 = new Address();
		addr1.setCountry("USA");
		addr1.setCity("NY");
		addr1.setStreet("5th av.");
		addr1.setNum(42);
		port.addAddress("John", addr1);
		Address addr2 = port.getAddress("John");
		System.out.format("John's address is: %s %s, %s, %s", addr2.getNum(), addr2.getStreet(), addr2.getCity(), addr2.getCountry());
	}

}
