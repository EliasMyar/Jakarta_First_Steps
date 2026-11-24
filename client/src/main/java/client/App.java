package client;

import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import artifact.ResearchersWS;
import artifact.Researcher;
import artifact.ResearchersWSService;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import beans.ImanagePublications;
import data.Publication;



public class App {

	public static void main(String[] args) throws NamingException {
		Scanner sc = new Scanner(System.in);
		ResearchersWSService service = new ResearchersWSService();
		ResearchersWS port = service.getResearchersWSPort();
		ImanagePublications cr = InitialContext.doLookup("rest-ear/rest-ejbs/ManagePublications!beans.ImanagePublications");
		
		Client client = ClientBuilder.newClient();
		

		boolean active = true;
		while (active) {

			System.out.println("\n1 - List all researchers\n" + "2 - Filter researcher by name\n"
					+ "3 - Filter by interest\n" + "4 - Filter citations by name\n" + 
					"\n5 - List Publications\n" + 
					"6 - Filter Publications by title\n" + 
					"7 - Filter Publications by Researcher\n" + 
					"8 - Filter Publications by Journal\n" + 
					"9 - Filter Publications by Journal and Researcher\n" + 
					"10 - Filter Publications by Institution and Period of Time\n" + 
					"11 - Exit\n" + "\n\nSelect an option:");
			String option = sc.nextLine();

			switch (option) {
			case "1":
			    printResearchers(port.listResearchers());
			    break;

			case "2": {
			    System.out.println("Write a Researcher name:");
			    String name2 = sc.nextLine();
			    printResearchers(port.getResearchersByName(name2));
			    break;
			}

			case "3": {
			    System.out.println("Write an interest:");
			    String interest3 = sc.nextLine();
			    printResearchers(port.getResearchersByInterest(interest3));
			    break;
			}

			case "4": {
			    System.out.println("Write a Researcher name:");
			    String name4 = sc.nextLine();
			    printCitations(port.getResearchersByName(name4));
			    break;
			}
				
			case "5":
			    printPublications(client, "listpublications");
			    break;

			case "6": {
			    System.out.println("Write a publication title:");
			    String title6 = sc.nextLine();
			    printPublications(client, "getPubByTitle", "title", title6);
			    break;
			}

			case "7": {
			    System.out.println("Write a researcher name:");
			    String name7 = sc.nextLine();
			    printPublications(client, "getPubByResearcher", "name", name7);
			    break;
			}

			case "8": {
			    System.out.println("Write a journal:");
			    String journal8 = sc.nextLine();
			    printPublications(client, "getPubByJournal", "journal", journal8);
			    break;
			}

			case "9": {
			    System.out.println("Write a journal:");
			    String journal9 = sc.nextLine();
			    System.out.println("Write a researcher name:");
			    String name9 = sc.nextLine();
			    printPublications(client, "getPubByJournalAndResearcher",
			            "journal", journal9, "name", name9);
			    break;
			}
			
			case "10": {
			    System.out.println("Write an institution:");
			    String institution10 = sc.nextLine();
			    System.out.println("Write start date (dd/MM/yyyy):");
			    LocalDate startDate = readDate(sc);
			    System.out.println("Write end date (dd/MM/yyyy):");
			    LocalDate endDate = readDate(sc);
			    List<Publication> pubs=cr.getPublicationByinstitutionAndPeriod(institution10, startDate, endDate);
			    printPublicationsTable(pubs);
			    break;
			}
			
			case "11":
				active = false;
				break;

			default:
				active = false;
				break;
			}

		}

	}

	private static void printTable(String[] headers, List<String[]> rows) {
	    // width of each column = longest single line in that column
	    int[] widths = new int[headers.length];
	    for (int i = 0; i < headers.length; i++) {
	        widths[i] = headers[i].length();
	    }
	    for (String[] row : rows) {
	        for (int i = 0; i < row.length; i++) {
	            for (String part : row[i].split("\n")) {
	                widths[i] = Math.max(widths[i], part.length());
	            }
	        }
	    }

	    StringBuilder sep = new StringBuilder("|");
	    for (int w : widths) {
	        sep.append("-".repeat(w + 2)).append("|");
	    }
	    String line = sep.toString();

	    System.out.println(line);
	    printRow(headers, widths);
	    System.out.println(line);
	    for (String[] row : rows) {
	        printRow(row, widths);
	        System.out.println(line);      // separator after each researcher
	    }
	}
	
	
	private static void printResearchers(List<Researcher> researchers) {
	    if (researchers.isEmpty()) {
	        System.out.println("No researchers found.");
	        return;
	    }
	    String[] headers = { "Name", "Institution", "Citations", "Interests", "Publications" };
	    List<String[]> rows = new ArrayList<>();
	    for (Researcher r : researchers) {
	        rows.add(new String[] {
	                String.valueOf(r.getName()),
	                String.valueOf(r.getHostInstitution()),
	                String.valueOf(r.getCitationsCountYear()),
	                String.join("\n", r.getInterests()),
	                String.join("\n", r.getPublications())
	        });
	    }
	    printTable(headers, rows);
	}

	private static void printCitations(List<Researcher> researchers) {
	    if (researchers.isEmpty()) {
	        System.out.println("No researchers found.");
	        return;
	    }
	    String[] headers = { "Name", "Citations" };
	    List<String[]> rows = new ArrayList<>();
	    for (Researcher r : researchers) {
	        rows.add(new String[] {
	                String.valueOf(r.getName()),
	                String.valueOf(r.getCitationsCountYear())
	        });
	    }
	    printTable(headers, rows);
	}
	
	private static void printPublications(Client client, String path, String... params) {
	    WebTarget target = client.target("http://localhost:8180/rest/services/myservice").path(path);
	    for (int i = 0; i < params.length; i += 2) {
	        target = target.queryParam(params[i], params[i + 1]);
	    }

	    try (Response response = target.request(MediaType.APPLICATION_JSON).get()) {
	        if (response.getStatus() != 200) {
	            System.out.println("Error " + response.getStatus() + ": " + response.readEntity(String.class));
	            return;
	        }

	        List<Map<String, Object>> pubs =
	                response.readEntity(new GenericType<List<Map<String, Object>>>() {});

	        if (pubs.isEmpty()) {
	            System.out.println("No publications found.");
	            return;
	        }

	        // union of keys across all items (null fields are often omitted from the JSON)
	        Set<String> keys = new LinkedHashSet<>();
	        for (Map<String, Object> p : pubs) {
	            keys.addAll(p.keySet());
	        }
	        String[] headers = keys.toArray(new String[0]);

	        List<String[]> rows = new ArrayList<>();
	        for (Map<String, Object> p : pubs) {
	            String[] row = new String[headers.length];
	            for (int i = 0; i < headers.length; i++) {
	                row[i] = formatValue(p.get(headers[i]));
	            }
	            rows.add(row);
	        }
	        printTable(headers, rows);
	    }
	}

	// lists become one item per line (like Interests/Publications in option 1)
	private static String formatValue(Object v) {
	    if (v == null) return "";
	    if (v instanceof Collection<?> c) {
	        return c.stream().map(App::formatValue).collect(Collectors.joining("\n"));
	    }
	    if (v instanceof Map<?, ?> m) {
	        Object n = m.get("name");          // e.g. a nested researcher
	        return n != null ? n.toString() : m.toString();
	    }
	    return v.toString();
	}
	
	private static final DateTimeFormatter INPUT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private static LocalDate readDate(Scanner sc) {
	    while (true) {
	        String text = sc.nextLine().trim();
	        try {
	            return LocalDate.parse(text, INPUT);
	        } catch (DateTimeParseException e) {
	            System.out.println("Invalid date, use dd/MM/yyyy:");
	        }
	    }
	}
	
	private static void printPublicationsTable(List<Publication> pubs) {
	    if (pubs == null || pubs.isEmpty()) {
	        System.out.println("No publications found.");
	        return;
	    }

	    String[] headers = { "Title", "Journal", "Institution", "Date", "Researchers" };
	    List<String[]> rows = new ArrayList<>();

	    for (Publication p : pubs) {
	        Set<String> researchers = p.getResearchers();

	        rows.add(new String[] {
	                String.valueOf(p.getTitle()),
	                String.valueOf(p.getJournal()),
	                String.valueOf(p.getInstitution()),
	                String.valueOf(p.getPublicationDate()),
	                researchers == null ? "" : String.join("\n", researchers)
	        });
	    }
	    printTable(headers, rows);
	}
	
	private static void printRow(String[] cells, int[] widths) {
	    // split every cell into its lines; the row is as tall as its tallest cell
	    String[][] parts = new String[cells.length][];
	    int height = 1;
	    for (int i = 0; i < cells.length; i++) {
	        parts[i] = cells[i].split("\n");
	        height = Math.max(height, parts[i].length);
	    }
	    for (int l = 0; l < height; l++) {
	        StringBuilder sb = new StringBuilder("|");
	        for (int i = 0; i < cells.length; i++) {
	            String text = l < parts[i].length ? parts[i][l] : "";
	            sb.append(" ").append(String.format("%-" + widths[i] + "s", text)).append(" |");
	        }
	        System.out.println(sb);
	    }
	}
}


