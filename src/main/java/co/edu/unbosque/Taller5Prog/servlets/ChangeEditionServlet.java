package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "changeEdition", value = "/change-edition")
public class ChangeEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        Integer id_book = Integer.parseInt(request.getParameter("selectEdition"));
        String descripcion = request.getParameter("description");
        String year = request.getParameter("year");
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = format.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        EditionService editionService = new EditionService();
        editionService.updateEdition(id_book, descripcion, date);

        response.sendRedirect("crearEdition.html");

    }
}
