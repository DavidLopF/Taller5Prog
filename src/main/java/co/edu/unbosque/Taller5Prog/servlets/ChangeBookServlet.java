package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "modificarLibro", value = "/modificarLibro")
public class ChangeBookServlet  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int bookID = Integer.parseInt(request.getParameter("selectLibro"));
        String newName = request.getParameter("libro");
        String newIsbn = request.getParameter("isbn");
        String newGener = request.getParameter("selectGener");

        BookService bookService = new BookService();
        bookService.modificarLibro(bookID,newName,newIsbn,newGener);



        response.sendRedirect("crearLibro.html");

    }

}