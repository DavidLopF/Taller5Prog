package co.edu.unbosque.Taller5Prog.servlets;
import co.edu.unbosque.Taller5Prog.services.BookService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteBook", value = "/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        int bookID = Integer.parseInt(request.getParameter("selectLibro"));
        BookService bookService = new BookService();
        bookService.deleteBook(bookID);
        response.sendRedirect("crearLibro.html");

    }
}