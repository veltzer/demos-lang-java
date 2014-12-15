package addressbook.service;

import java.util.*;

import javax.jws.*;

@WebService
@HandlerChain(file="addressbook/service/handler-chains.xml")
public class AddressBook {
	private Map<String, Address> addresses = new HashMap<String, Address>();
	
	@WebMethod
	public void addAddress(String name,Address address) {
		addresses.put(name, address);
	} 
	
	@WebMethod
	public Address getAddress(String name) {
		return addresses.get(name);
	}
}
