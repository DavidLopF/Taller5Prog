package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.AuthorService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteAuthorServlet", value = "/delete-author")
public class DeleteAuthorServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        int authorId = Integer.parseInt(request.getParameter("selectAuthor"));

        AuthorService authorService = new AuthorService();
        authorService.deleteAuthor(authorId);

        response.sendRedirect("crearAuthor.html");
    }

}
