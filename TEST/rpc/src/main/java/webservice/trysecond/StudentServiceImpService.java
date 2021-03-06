
package webservice.trysecond;

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
@WebServiceClient(name = "StudentServiceImpService", targetNamespace = "http://trysecond.webservice/", wsdlLocation = "http://localhost:8888/stu?wsdl")
public class StudentServiceImpService
    extends Service
{

    private final static URL STUDENTSERVICEIMPSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(webservice.trysecond.StudentServiceImpService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = webservice.trysecond.StudentServiceImpService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8888/stu?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8888/stu?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        STUDENTSERVICEIMPSERVICE_WSDL_LOCATION = url;
    }

    public StudentServiceImpService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StudentServiceImpService() {
        super(STUDENTSERVICEIMPSERVICE_WSDL_LOCATION, new QName("http://trysecond.webservice/", "StudentServiceImpService"));
    }

    /**
     * 
     * @return
     *     returns StudentServiceImp
     */
    @WebEndpoint(name = "StudentServiceImpPort")
    public StudentServiceImp getStudentServiceImpPort() {
        return super.getPort(new QName("http://trysecond.webservice/", "StudentServiceImpPort"), StudentServiceImp.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StudentServiceImp
     */
    @WebEndpoint(name = "StudentServiceImpPort")
    public StudentServiceImp getStudentServiceImpPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://trysecond.webservice/", "StudentServiceImpPort"), StudentServiceImp.class, features);
    }

}
