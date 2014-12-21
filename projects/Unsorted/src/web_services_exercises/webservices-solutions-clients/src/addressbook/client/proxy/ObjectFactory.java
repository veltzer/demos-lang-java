
package addressbook.client.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the addressbook.client.proxy package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups. Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _GetAddress_QNAME = new QName("http://service.addressbook/", "getAddress");
	private final static QName _GetAddressResponse_QNAME = new QName("http://service.addressbook/", "getAddressResponse");
	private final static QName _AddAddress_QNAME = new QName("http://service.addressbook/", "addAddress");
	private final static QName _AddAddressResponse_QNAME = new QName("http://service.addressbook/", "addAddressResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: addressbook.client.proxy
	 *
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GetAddress }
	 *
	 */
	public GetAddress createGetAddress() {
		return new GetAddress();
	}

	/**
	 * Create an instance of {@link AddAddress }
	 *
	 */
	public AddAddress createAddAddress() {
		return new AddAddress();
	}

	/**
	 * Create an instance of {@link AddAddressResponse }
	 *
	 */
	public AddAddressResponse createAddAddressResponse() {
		return new AddAddressResponse();
	}

	/**
	 * Create an instance of {@link Address }
	 *
	 */
	public Address createAddress() {
		return new Address();
	}

	/**
	 * Create an instance of {@link GetAddressResponse }
	 *
	 */
	public GetAddressResponse createGetAddressResponse() {
		return new GetAddressResponse();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetAddress }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.addressbook/", name = "getAddress")
	public JAXBElement<GetAddress> createGetAddress(GetAddress value) {
		return new JAXBElement<GetAddress>(_GetAddress_QNAME, GetAddress.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GetAddressResponse }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.addressbook/", name = "getAddressResponse")
	public JAXBElement<GetAddressResponse> createGetAddressResponse(GetAddressResponse value) {
		return new JAXBElement<GetAddressResponse>(_GetAddressResponse_QNAME, GetAddressResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddAddress }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.addressbook/", name = "addAddress")
	public JAXBElement<AddAddress> createAddAddress(AddAddress value) {
		return new JAXBElement<AddAddress>(_AddAddress_QNAME, AddAddress.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link AddAddressResponse }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.addressbook/", name = "addAddressResponse")
	public JAXBElement<AddAddressResponse> createAddAddressResponse(AddAddressResponse value) {
		return new JAXBElement<AddAddressResponse>(_AddAddressResponse_QNAME, AddAddressResponse.class, null, value);
	}

}
