import data.Researcher;

import java.util.List;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class WriteData {
	public static void main(String[] args) {
		
		Researcher r1 = new Researcher("Nuno Laranjeiro", "University of Coimbra", 230, Set.of("Dependable Computing", "Software Robustness", "Software Security", "Software Engineering","Cloud Computing"), Set.of("An analysis of public REST web service APIs", "A survey on data quality: classifying poor data"));
		Researcher r2 = new Researcher("Cesar Teixeira", "University of Coimbra", 394, Set.of("Biomedical Signal Processing", "Epileptic Seizure Prediction/Forecasting"), Set.of("An analysis of public REST web service APIs", "A survey on data quality: classifying poor data"));
		Researcher r3 = new Researcher("Antonio Ruano", "University of Algarve", 251, Set.of("Computational Intelligence", "Intelligent Control"), Set.of("A black box tool for robustness testing of REST services", "EEG epilepsy seizure prediction: the post-processing stage as a chronology"));
		Researcher r4 = new Researcher("Diogo Pessoa", "University of Coimbra", 395, Set.of("Biomedical Engineering", "Signal Processing", "Image Processing", "Machine Learning", "Data Science"), Set.of("A survey on data quality: classifying poor data"));
		Researcher r5 = new Researcher("David Weiss", "Iowa State University", 3606, Set.of("Software Engineering", "Software Product Lines", "Software Measurement","Software Architecture"), Set.of("A black box tool for robustness testing of REST services", "Prediction of disease progression and outcomes in multiple sclerosis with machine learning", "EEG epilepsy seizure prediction: the post-processing stage as a chronology"));
		Researcher r6 = new Researcher("Joaquim Luis", "University of Algarve", 931, Set.of("Geophysics", "Scientific Programming"), Set.of("Prediction of disease progression and outcomes in multiple sclerosis with machine learning", "EEG epilepsy seizure prediction: the post-processing stage as a chronology"));
		Researcher r7 = new Researcher("LF Menezes", "University of Coimbra", 280, Set.of("Mechanical Engineering", "Computational Mechanics"), Set.of("A black box tool for robustness testing of REST services", "Prediction of disease progression and outcomes in multiple sclerosis with machine learning"));
		Researcher r8 = new Researcher("Jorge Sa Silva", "University of Coimbra", 281, Set.of("Network Protocols", "Wireless Sensor Networks", "IoT"), Set.of("Prediction of disease progression and outcomes in multiple sclerosis with machine learning"));
		
		List<Researcher> researchers = List.of(r1,r2,r3,r4,r5,r6,r7,r8);
		
	 	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Researchers");
        EntityManager em = emf.createEntityManager();
        EntityTransaction trx = em.getTransaction();
        trx.begin();
        researchers.forEach(em::persist);
        trx.commit();
        em.close();
        emf.close();
	}
}
