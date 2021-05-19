package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.RentService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "createRent", value = "/create-rent")
public class CreateRentServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int id_edicion = Integer.parseInt(request.getParameter("edicion"));
        String id_customer = request.getParameter("selectCusto");
        String year = request.getParameter("date");
        SimpleDateFormat format = new SimpleDateFormat("yyyy");


        RentService rentService = new RentService();
        rentService.saveRent(id_customer, id_edicion, year);

        response.sendRedirect("tablaRentasCliente.html");
    }
}
