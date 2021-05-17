package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.BookService;
import co.edu.unbosque.Taller5Prog.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "cretateBookServlet", value = "/create-book")
public class CreateBookServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        int autor = Integer.parseInt(request.getParameter("selectAuthor"));
        String titulo = request.getParameter("libro");
        String isb = request.getParameter("isbn");
        String genero = request.getParameter("selectLibro");

        BookService bookService = new BookService();
        bookService.saveBook(titulo, isb, autor,genero);


        EditionService editionService = new EditionService();
        Date date = new Date();
        editionService.saveEdition("Primera edición",date,bookService.findByTitle(titulo).get().getBookId());
        response.sendRedirect("./crearLibro.html");

    }

}
