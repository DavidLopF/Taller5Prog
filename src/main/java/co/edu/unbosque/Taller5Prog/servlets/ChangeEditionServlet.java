package co.edu.unbosque.Taller5Prog.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebServlet(name = "changeEdition", value = "change-edition")
public class ChangeEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");

        int id_book = Integer.parseInt(request.getParameter("selectLibro"));
        String descripcion = request.getParameter("description");
        String year = request.getParameter("year");
        SimpleDateFormat format = new SimpleDateFormat("yyyy");
        Date date = null;
        try {
            date = format.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
