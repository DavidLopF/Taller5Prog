package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "changeCustomer", value = "change-customer")
public class ChangeCustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String id_email = request.getParameter("selectCusto");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String genero = request.getParameter("selectGen");
        int age = Integer.parseInt(request.getParameter("age"));

        CustomerService customerService = new CustomerService();
        customerService.UpdateCustomer(id_email, firstName, lastName, genero, age);

        response.sendRedirect("CreateCustomer.html");
    }
}
