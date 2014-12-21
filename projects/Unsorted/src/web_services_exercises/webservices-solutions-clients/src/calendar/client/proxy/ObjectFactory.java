
package calendar.client.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the calendar.client.proxy package.
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

	private final static QName _HebDayNameResponse_QNAME = new QName("http://service.calendar/", "hebDayNameResponse");
	private final static QName _HebDayName_QNAME = new QName("http://service.calendar/", "hebDayName");
	private final static QName _HebDayOfWeekResponse_QNAME = new QName("http://service.calendar/", "hebDayOfWeekResponse");
	private final static QName _HebDayOfWeek_QNAME = new QName("http://service.calendar/", "hebDayOfWeek");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calendar.client.proxy
	 *
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link HebDayOfWeekResponse }
	 *
	 */
	public HebDayOfWeekResponse createHebDayOfWeekResponse() {
		return new HebDayOfWeekResponse();
	}

	/**
	 * Create an instance of {@link HebDayName }
	 *
	 */
	public HebDayName createHebDayName() {
		return new HebDayName();
	}

	/**
	 * Create an instance of {@link HebDayNameResponse }
	 *
	 */
	public HebDayNameResponse createHebDayNameResponse() {
		return new HebDayNameResponse();
	}

	/**
	 * Create an instance of {@link HebDayOfWeek }
	 *
	 */
	public HebDayOfWeek createHebDayOfWeek() {
		return new HebDayOfWeek();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link HebDayNameResponse }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.calendar/", name = "hebDayNameResponse")
	public JAXBElement<HebDayNameResponse> createHebDayNameResponse(HebDayNameResponse value) {
		return new JAXBElement<HebDayNameResponse>(_HebDayNameResponse_QNAME, HebDayNameResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link HebDayName }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.calendar/", name = "hebDayName")
	public JAXBElement<HebDayName> createHebDayName(HebDayName value) {
		return new JAXBElement<HebDayName>(_HebDayName_QNAME, HebDayName.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link HebDayOfWeekResponse }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.calendar/", name = "hebDayOfWeekResponse")
	public JAXBElement<HebDayOfWeekResponse> createHebDayOfWeekResponse(HebDayOfWeekResponse value) {
		return new JAXBElement<HebDayOfWeekResponse>(_HebDayOfWeekResponse_QNAME, HebDayOfWeekResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link HebDayOfWeek }{@code >}}
	 *
	 */
	@XmlElementDecl(namespace = "http://service.calendar/", name = "hebDayOfWeek")
	public JAXBElement<HebDayOfWeek> createHebDayOfWeek(HebDayOfWeek value) {
		return new JAXBElement<HebDayOfWeek>(_HebDayOfWeek_QNAME, HebDayOfWeek.class, null, value);
	}

}
