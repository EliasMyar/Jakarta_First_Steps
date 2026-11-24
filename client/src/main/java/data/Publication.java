package data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.ElementCollection;

@Entity
public class Publication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private LocalDate publicationDate;
	private String institution;
	@ElementCollection
	private Set<String> researchers = new HashSet<>();
	private String journal;

	public Publication() {
		super();
	}

	public Publication(String title, LocalDate publicationDate, String journal, String institution,
			Set<String> researchers) {
		super();
		this.journal = journal;
		this.publicationDate = publicationDate;
		this.title = title;
		this.institution = institution;
		this.researchers = new HashSet<>(researchers);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Set<String> getResearchers() {
		return researchers;
	}

	public void setResearchers(Set<String> researchers) {
		this.researchers = researchers;
	}


	public void setJournal(String journal) {
		this.journal = journal;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getJournal() {
		return journal;
	}

}

