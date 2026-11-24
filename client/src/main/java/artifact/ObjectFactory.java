
package artifact;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the artifact package. 
 * <p>An ObjectFactory allows you to programmatically 
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

    private static final QName _GetResearchersByInterest_QNAME = new QName("http://ws/", "getResearchersByInterest");
    private static final QName _GetResearchersByInterestResponse_QNAME = new QName("http://ws/", "getResearchersByInterestResponse");
    private static final QName _GetResearchersByName_QNAME = new QName("http://ws/", "getResearchersByName");
    private static final QName _GetResearchersByNameResponse_QNAME = new QName("http://ws/", "getResearchersByNameResponse");
    private static final QName _ListResearchers_QNAME = new QName("http://ws/", "listResearchers");
    private static final QName _ListResearchersResponse_QNAME = new QName("http://ws/", "listResearchersResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: artifact
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetResearchersByInterest }
     * 
     * @return
     *     the new instance of {@link GetResearchersByInterest }
     */
    public GetResearchersByInterest createGetResearchersByInterest() {
        return new GetResearchersByInterest();
    }

    /**
     * Create an instance of {@link GetResearchersByInterestResponse }
     * 
     * @return
     *     the new instance of {@link GetResearchersByInterestResponse }
     */
    public GetResearchersByInterestResponse createGetResearchersByInterestResponse() {
        return new GetResearchersByInterestResponse();
    }

    /**
     * Create an instance of {@link GetResearchersByName }
     * 
     * @return
     *     the new instance of {@link GetResearchersByName }
     */
    public GetResearchersByName createGetResearchersByName() {
        return new GetResearchersByName();
    }

    /**
     * Create an instance of {@link GetResearchersByNameResponse }
     * 
     * @return
     *     the new instance of {@link GetResearchersByNameResponse }
     */
    public GetResearchersByNameResponse createGetResearchersByNameResponse() {
        return new GetResearchersByNameResponse();
    }

    /**
     * Create an instance of {@link ListResearchers }
     * 
     * @return
     *     the new instance of {@link ListResearchers }
     */
    public ListResearchers createListResearchers() {
        return new ListResearchers();
    }

    /**
     * Create an instance of {@link ListResearchersResponse }
     * 
     * @return
     *     the new instance of {@link ListResearchersResponse }
     */
    public ListResearchersResponse createListResearchersResponse() {
        return new ListResearchersResponse();
    }

    /**
     * Create an instance of {@link Researcher }
     * 
     * @return
     *     the new instance of {@link Researcher }
     */
    public Researcher createResearcher() {
        return new Researcher();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResearchersByInterest }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetResearchersByInterest }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getResearchersByInterest")
    public JAXBElement<GetResearchersByInterest> createGetResearchersByInterest(GetResearchersByInterest value) {
        return new JAXBElement<>(_GetResearchersByInterest_QNAME, GetResearchersByInterest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResearchersByInterestResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetResearchersByInterestResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getResearchersByInterestResponse")
    public JAXBElement<GetResearchersByInterestResponse> createGetResearchersByInterestResponse(GetResearchersByInterestResponse value) {
        return new JAXBElement<>(_GetResearchersByInterestResponse_QNAME, GetResearchersByInterestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResearchersByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetResearchersByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getResearchersByName")
    public JAXBElement<GetResearchersByName> createGetResearchersByName(GetResearchersByName value) {
        return new JAXBElement<>(_GetResearchersByName_QNAME, GetResearchersByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResearchersByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetResearchersByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "getResearchersByNameResponse")
    public JAXBElement<GetResearchersByNameResponse> createGetResearchersByNameResponse(GetResearchersByNameResponse value) {
        return new JAXBElement<>(_GetResearchersByNameResponse_QNAME, GetResearchersByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResearchers }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListResearchers }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "listResearchers")
    public JAXBElement<ListResearchers> createListResearchers(ListResearchers value) {
        return new JAXBElement<>(_ListResearchers_QNAME, ListResearchers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListResearchersResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListResearchersResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws/", name = "listResearchersResponse")
    public JAXBElement<ListResearchersResponse> createListResearchersResponse(ListResearchersResponse value) {
        return new JAXBElement<>(_ListResearchersResponse_QNAME, ListResearchersResponse.class, null, value);
    }

}
