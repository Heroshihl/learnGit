
package webservice.trythird;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "BossServiceService", targetNamespace = "http://trythird.webservice/", wsdlLocation = "http://localhost:9997/boss?wsdl")
public class BossServiceService
    extends Service
{

    private final static URL BOSSSERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(webservice.trythird.BossServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = webservice.trythird.BossServiceService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:9997/boss?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:9997/boss?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        BOSSSERVICESERVICE_WSDL_LOCATION = url;
    }

    public BossServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BossServiceService() {
        super(BOSSSERVICESERVICE_WSDL_LOCATION, new QName("http://trythird.webservice/", "BossServiceService"));
    }

    /**
     * 
     * @return
     *     returns BossService
     */
    @WebEndpoint(name = "BossServicePort")
    public BossService getBossServicePort() {
        return super.getPort(new QName("http://trythird.webservice/", "BossServicePort"), BossService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BossService
     */
    @WebEndpoint(name = "BossServicePort")
    public BossService getBossServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://trythird.webservice/", "BossServicePort"), BossService.class, features);
    }

}