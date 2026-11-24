package beans;

import java.time.LocalDate;
import java.util.List;

import data.Publication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;

@Stateless
public class ManagePublications implements ImanagePublications{
	@PersistenceContext(unitName = "project2")
    private EntityManager em;
	
	private static final String WITH_RESEARCHERS = "select distinct p from Publication p left join fetch p.researchers";
	
	@Override
	public List<Publication> listPublications(){
		return em.createQuery(WITH_RESEARCHERS + " order by p.publicationDate", Publication.class)
				.getResultList();
	}
	
	@Override
	public List<Publication> getPublicationByTitle(String title){
		
		return em.createQuery(WITH_RESEARCHERS + " where p.title = :title order by p.publicationDate", Publication.class)
				.setParameter("title", title)
				.getResultList();
		
	}
	
	@Override
	public List<Publication> getPublicationsByResearcherName(String name) {
	    return em.createQuery(
			WITH_RESEARCHERS +
	        " where p.id in (select p2.id from Publication p2 join p2.researchers r where r = :name) " +
	        " order by p.publicationDate", Publication.class)
	        .setParameter("name", name)
	        .getResultList();
	} 

	@Override
	public List<Publication> getPublicationByJournal_Researcher(String journal, String researcher) {
	    return em.createQuery(
	    	WITH_RESEARCHERS +
	        " where p.journal = :journal " +
	        " and p.id in (select p2.id from Publication p2 join p2.researchers r where r = :name) " +
	        " order by p.publicationDate", Publication.class)
	        .setParameter("journal", journal)
	        .setParameter("name", researcher)
	        .getResultList();   
	}
	
	
	
	
	@Override
	public List<Publication> getPublicationByJournal(String journal){
		
		return em.createQuery(WITH_RESEARCHERS + " where p.journal = :journal order by p.publicationDate", Publication.class)
				.setParameter("journal", journal)
				.getResultList();
		
	}
	
	
	
	@Override
	public List<Publication> getPublicationByinstitutionAndPeriod(String institution, LocalDate init, LocalDate end){
	
		return em.createQuery(WITH_RESEARCHERS + " where p.institution = :institution and p.publicationDate between :init and :end order by p.publicationDate", Publication.class)
				.setParameter("institution", institution)
				.setParameter("init", init)
				.setParameter("end", end)
				.getResultList();
	}
	
	
	
	
}

	