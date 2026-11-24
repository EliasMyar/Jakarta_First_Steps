import data.Publication;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class WriteData {
	public static void main(String[] args) {
		
		Publication p1 = new Publication("An analysis of public REST web service APIs", LocalDate.of(2021, 7, 1), "IEEE", "University of Coimbra", Set.of("Nuno Laranjeiro", "Cesar Teixeira"));
		Publication p2 =  new Publication("A survey on data quality: classifying poor data", LocalDate.of(2015, 11, 18), "IEEE", "University of Coimbra", Set.of("Nuno Laranjeiro", "Cesar Teixeira", "Diogo Pessoa"));
		Publication p3 =  new Publication("A black box tool for robustness testing of REST services", LocalDate.of(2021, 2, 2), "IEEE", "University of Algarve", Set.of("Antonio Ruano", "David Weiss", "LF Menezes"));
		Publication p4 = new Publication("Prediction of disease progression and outcomes in multiple sclerosis with machine learning", LocalDate.of(2020, 12, 3), "Nature Publishing Group UK", "Iowa State University", Set.of("David Weiss", "Joaquim Luis", "LF Menezes", "Jorge Sa Silva"));
		Publication p5 = new Publication("EEG epilepsy seizure prediction: the post-processing stage as a chronology", LocalDate.of(2024, 1, 3), "Nature Publishing Group UK", "University of Algarve", Set.of("Antonio Ruano", "David Weiss", "Joaquim Luis"));	
		
		List<Publication> publications = List.of(p1,p2,p3,p4,p5);
		
		
	 	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Researchers");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        publications.forEach(em::persist);
        trx.commit();
        em.close();
        emf.close();
	}
}
