package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttcpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "asociarLibrary", value = "/asociarLibrary")
public class AsociarLibraryServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();

        int idEdicion =Integer.parseInt(cookies[1].getValue());

        int idLibreria = Integer.parseInt(request.getParameter("selectLibreria"));


        EditionService editionService = new EditionService();
        editionService.agregarEdicionLibreria(idEdicion,idLibreria);

        response.sendRedirect("mostrarTablaEdiciones.html");


    }

}
