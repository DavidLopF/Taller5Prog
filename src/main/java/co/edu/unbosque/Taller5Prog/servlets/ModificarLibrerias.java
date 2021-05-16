package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.LibraryService;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modificaLibreria", value = "/modificarLibreria")

public class ModificarLibrerias extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        int id = Integer.parseInt(request.getParameter("selectLibreria"));

        String newName = request.getParameter("libreria");

        LibraryService libraryService = new LibraryService();


        libraryService.modificarLibreria(id, newName);

       response.sendRedirect("crearLibreria.html");
    }
}
