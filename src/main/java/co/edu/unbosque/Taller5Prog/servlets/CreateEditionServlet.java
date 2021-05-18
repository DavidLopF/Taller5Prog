package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.EditionService;
import javafx.print.Printer;

import javax.print.attribute.PrintRequestAttribute;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CreateEdtionServlet", value = "/create-edition")
public class CreateEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        int id_book = Integer.parseInt(request.getParameter("selectLibro"));
        String description = request.getParameter("description");
        String year = request.getParameter("year");
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = format.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        EditionService service = new EditionService();
        service.saveEdition(description, date, id_book);
        response.sendRedirect("crearEdicion.html");

    }
}
