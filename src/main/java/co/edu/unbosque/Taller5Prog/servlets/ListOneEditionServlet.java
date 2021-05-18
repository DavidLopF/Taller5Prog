package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.jpa.entities.Book;
import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;
import co.edu.unbosque.Taller5Prog.services.AuthorService;
import co.edu.unbosque.Taller5Prog.services.BookService;
import co.edu.unbosque.Taller5Prog.services.EditionService;
import co.edu.unbosque.Taller5Prog.servlets.pojos.AuthorPOJO;
import co.edu.unbosque.Taller5Prog.servlets.pojos.BookPOJO;
import co.edu.unbosque.Taller5Prog.servlets.pojos.EdtionPOJO;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(name = "listOneEdition", value = "/listOneEdition")
public class ListOneEditionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");

        response.setCharacterEncoding("UTF-8");
        Cookie[] cookies = request.getCookies();
        int bookId = Integer.parseInt(cookies[0].getValue());

        EditionService editionService = new EditionService();
        List<EdtionPOJO> edition = editionService.findEditionByBookId(bookId);
        PrintWriter out = response.getWriter();
        String booksJsonString = new Gson().toJson(edition);
        out.print(booksJsonString);
        out.flush();
    }

}
