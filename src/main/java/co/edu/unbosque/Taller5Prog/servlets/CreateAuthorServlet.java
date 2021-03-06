package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cretateAuthorServlet", value = "/create-author")
public class CreateAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");


        String newName = request.getParameter("author");
        String newLastName = request.getParameter("lastName");
        String newFullName = newName + " " + newLastName;
        String newCountry = request.getParameter("country");

        // int authorID = 100;

        AuthorService service = new AuthorService();
        service.saveAuthor(newFullName, newCountry);

        response.sendRedirect("crearAuthor.html");
    }

}
