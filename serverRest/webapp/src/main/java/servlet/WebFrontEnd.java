package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import beans.ImanagePublications;
import data.Publication;
import jakarta.ejb.EJB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/publications")
public class WebFrontEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ImanagePublications managePublications;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {

	    List<Publication> publications = managePublications.listPublications();

	    request.setAttribute("publications", publications);
	    request.getRequestDispatcher("/display3.jsp").forward(request, response);
	}
}
