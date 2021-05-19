package co.edu.unbosque.Taller5Prog.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "FindRetsOfCustomer", value = "/find-rents")
public class FindRetsOfCustomer extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/hmtl");

        String email_customer = request.getParameter("selectCusto");
        String desde = request.getParameter("from");
        String hasta = request.getParameter("to");

        Cookie email = new Cookie("email_customer", email_customer);
        Cookie filtroDesde = new Cookie("desde", desde);
        Cookie filtroHasta = new Cookie("hasta", hasta);

        response.addCookie(email);
        response.addCookie(filtroDesde);
        response.addCookie(filtroHasta);

        response.sendRedirect("tablaRentasCliente.html");
    }
}
