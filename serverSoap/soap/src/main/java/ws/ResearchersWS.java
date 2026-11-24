package ws;

import java.util.List;

import beans.IManageResearchers;
import data.Researcher;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;

@WebService
public class ResearchersWS {

    @EJB
    private IManageResearchers manageResearchers;

    @WebMethod
    @WebResult(name = "researcher")
    public List<Researcher> listResearchers() {
        return manageResearchers.listResearchers();
    }

    @WebMethod
    @WebResult(name = "researcher")
    public List<Researcher> getResearchersByName(@WebParam(name = "name") String name) {
        return manageResearchers.getResearchersByName(name);
    }

    @WebMethod
    @WebResult(name = "researcher")
    public List<Researcher> getResearchersByInterest(@WebParam(name = "interest") String interest) {
        return manageResearchers.getResearchersByInterest(interest);
    }
}