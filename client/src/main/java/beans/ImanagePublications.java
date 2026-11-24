package beans;

import data.Publication;
import jakarta.ejb.Remote;

import java.time.LocalDate;
import java.util.List;

@Remote
public interface ImanagePublications {
	List<Publication> listPublications();
	List<Publication> getPublicationByTitle(String title);
	List<Publication> getPublicationsByResearcherName(String name);
	List<Publication> getPublicationByJournal(String journal);
	List<Publication> getPublicationByJournal_Researcher(String journal, String Researcher);
	List<Publication> getPublicationByinstitutionAndPeriod(String institution, LocalDate init, LocalDate end);	

}
