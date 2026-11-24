package beans;

import java.util.List;
import jakarta.ejb.Remote;
import data.Researcher;

@Remote
public interface IManageResearchers {
	public List<Researcher> listResearchers();
    public List<Researcher> getResearchersByName(String name);
    public List<Researcher> getResearchersByInterest(String interest);
	
	
}
