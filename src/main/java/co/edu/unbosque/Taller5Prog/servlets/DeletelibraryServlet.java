package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.LibraryService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteLibrary", value = "/deleteLibrary")
public class DeletelibraryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        int id = Integer.parseInt(request.getParameter("selectLibreria"));

        LibraryService libraryService = new LibraryService();

        libraryService.deleteLibrary(id);

        response.sendRedirect("crearLibreria.html");
    }
}
