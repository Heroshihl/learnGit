
package webservice.trythird;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webservice.trythird package. 
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

    private final static QName _SayBoss_QNAME = new QName("http://trythird.webservice/", "sayBoss");
    private final static QName _SayBossResponse_QNAME = new QName("http://trythird.webservice/", "sayBossResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webservice.trythird
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayBoss }
     * 
     */
    public SayBoss createSayBoss() {
        return new SayBoss();
    }

    /**
     * Create an instance of {@link SayBossResponse }
     * 
     */
    public SayBossResponse createSayBossResponse() {
        return new SayBossResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayBoss }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trythird.webservice/", name = "sayBoss")
    public JAXBElement<SayBoss> createSayBoss(SayBoss value) {
        return new JAXBElement<SayBoss>(_SayBoss_QNAME, SayBoss.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayBossResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://trythird.webservice/", name = "sayBossResponse")
    public JAXBElement<SayBossResponse> createSayBossResponse(SayBossResponse value) {
        return new JAXBElement<SayBossResponse>(_SayBossResponse_QNAME, SayBossResponse.class, null, value);
    }

}
