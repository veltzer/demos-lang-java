
package calculator.client.proxy;

import javax.xml.bind.annotation.XmlEnum;


/**
 * <p>Java class for operation.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="operation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DIV"/>
 *     &lt;enumeration value="MUL"/>
 *     &lt;enumeration value="SUB"/>
 *     &lt;enumeration value="ADD"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlEnum
public enum Operation {

    ADD,
    DIV,
    MUL,
    SUB;

    public String value() {
        return name();
    }

    public static Operation fromValue(String v) {
        return valueOf(v);
    }

}
