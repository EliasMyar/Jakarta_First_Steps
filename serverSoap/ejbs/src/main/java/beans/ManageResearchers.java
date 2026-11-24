package beans;

import java.util.List;
import data.Researcher;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class ManageResearchers implements IManageResearchers {

	@PersistenceContext(unitName = "project2")
	private EntityManager em;

	private static final String WITH_INTERESTS = "select distinct r from Researcher r left join fetch r.interests left join fetch r.publications ";

	@Override
	public List<Researcher> listResearchers() {
		return em.createQuery(WITH_INTERESTS + "order by r.name", Researcher.class).getResultList();
	}

	@Override
	public List<Researcher> getResearchersByName(String name) {
		return em.createQuery(WITH_INTERESTS + "where r.name = :name order by r.name", Researcher.class)
				.setParameter("name", name).getResultList();
	}

	@Override
	public List<Researcher> getResearchersByInterest(String interest) {
		return em
				.createQuery(WITH_INTERESTS + "where :interest member of r.interests order by r.name", Researcher.class)
				.setParameter("interest", interest).getResultList();
	}

}