package data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Researcher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int citationsCountYear;
	private String hostInstitution;
	@ElementCollection
	private Set<String> interests = new HashSet<>();
	@ElementCollection
	private Set<String> publications = new HashSet<>();

	public Researcher() {
		super();
	}
	public Researcher(String name, String hostIntitution, int citationsCountYear, Set<String> interests, Set<String> publications) {
		super();
		this.citationsCountYear = citationsCountYear;
		this.name = name;
		this.interests = new HashSet<>(interests);
		this.hostInstitution = hostIntitution;
		this.publications = new HashSet<>(publications);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCitationsCountYear() {
		return citationsCountYear;
	}

	public void setCitationsCountYear(int citationsCountYear) {
		this.citationsCountYear = citationsCountYear;
	}
	public Set<String> getInterests() {
		return interests;
	}
	public void setInterests(Set<String> interests) {
		this.interests = interests;
	}
	public String getHostInstitution() {
		return hostInstitution;
	}
	public void setHostInstitution(String hostInstitution) {
		this.hostInstitution = hostInstitution;
	}
	public Set<String> getPublications() {
		return publications;
	}
	public void setPublications(Set<String> publications) {
		this.publications = publications;
	}
	


}
