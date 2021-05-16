package co.edu.unbosque.Taller5Prog.servlets;


import co.edu.unbosque.Taller5Prog.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modificarAuthor", value = "/modificarAuthor")
public class ChangeAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int authorID = Integer.parseInt(request.getParameter("selectAuthor"));

        String newName = request.getParameter("author");
        String newLastName = request.getParameter("lastName");
        String newFullName = newName+" "+newLastName;
        String newCountry = request.getParameter("country");

       // int authorID = 100;

        AuthorService service = new AuthorService();
        service.modificarAutor(authorID,newFullName,newCountry);

        response.sendRedirect("crearAuthor.html");

    }
}
