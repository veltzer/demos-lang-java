
package calculator.client.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the calculator.client.proxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InvokeOperationResponse_QNAME = new QName("http://service.calculator/", "invokeOperationResponse");
    private final static QName _StartCalc_QNAME = new QName("http://service.calculator/", "startCalc");
    private final static QName _StartCalcResponse_QNAME = new QName("http://service.calculator/", "startCalcResponse");
    private final static QName _InvokeOperation_QNAME = new QName("http://service.calculator/", "invokeOperation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: calculator.client.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StartCalcResponse }
     * 
     */
    public StartCalcResponse createStartCalcResponse() {
        return new StartCalcResponse();
    }

    /**
     * Create an instance of {@link InvokeOperationResponse }
     * 
     */
    public InvokeOperationResponse createInvokeOperationResponse() {
        return new InvokeOperationResponse();
    }

    /**
     * Create an instance of {@link StartCalc }
     * 
     */
    public StartCalc createStartCalc() {
        return new StartCalc();
    }

    /**
     * Create an instance of {@link InvokeOperation }
     * 
     */
    public InvokeOperation createInvokeOperation() {
        return new InvokeOperation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvokeOperationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.calculator/", name = "invokeOperationResponse")
    public JAXBElement<InvokeOperationResponse> createInvokeOperationResponse(InvokeOperationResponse value) {
        return new JAXBElement<InvokeOperationResponse>(_InvokeOperationResponse_QNAME, InvokeOperationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartCalc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.calculator/", name = "startCalc")
    public JAXBElement<StartCalc> createStartCalc(StartCalc value) {
        return new JAXBElement<StartCalc>(_StartCalc_QNAME, StartCalc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StartCalcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.calculator/", name = "startCalcResponse")
    public JAXBElement<StartCalcResponse> createStartCalcResponse(StartCalcResponse value) {
        return new JAXBElement<StartCalcResponse>(_StartCalcResponse_QNAME, StartCalcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvokeOperation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.calculator/", name = "invokeOperation")
    public JAXBElement<InvokeOperation> createInvokeOperation(InvokeOperation value) {
        return new JAXBElement<InvokeOperation>(_InvokeOperation_QNAME, InvokeOperation.class, null, value);
    }

}
