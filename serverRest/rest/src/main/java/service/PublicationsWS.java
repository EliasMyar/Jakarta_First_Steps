package service;


import java.util.List;
import beans.ImanagePublications;
import data.Publication;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.QueryParam;

@RequestScoped
@Path("/myservice")
@Produces(MediaType.APPLICATION_JSON)
public class PublicationsWS {

	@EJB
	private ImanagePublications managePublications;
	
	@GET
	@Path("/listpublications")
	public List<Publication> listPublication(){
		return managePublications.listPublications();
		
	}
	
	@GET
	@Path("/getPubByTitle")
	public List<Publication> getByTitle(@QueryParam("title") String title){
		return managePublications.getPublicationByTitle(title);
	}
	
	@GET
	@Path("/getPubByResearcher")
	public List<Publication> getByResearcher(@QueryParam("name") String name){
		return managePublications.getPublicationsByResearcherName(name);
	}
	
	@GET
	@Path("/getPubByJournal")
	public List<Publication> getByJournal(@QueryParam("journal") String journal){
		return managePublications.getPublicationByJournal(journal);
	}
	
	@GET
	@Path("/getPubByJournalAndResearcher")
	public List<Publication> getByJournal_Reseacher(@QueryParam("journal") String journal, @QueryParam("name") String name){
		return managePublications.getPublicationByJournal_Researcher(journal, name);
	}
	
	
	
	
}
