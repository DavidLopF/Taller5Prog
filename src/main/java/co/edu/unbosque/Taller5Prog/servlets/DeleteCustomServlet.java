package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.CustomerService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleCustomer", value = "/delete-customer")
public class DeleteCustomServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");

        String id = request.getParameter("selectCusto");

        CustomerService customerService = new CustomerService();
        customerService.deleteCustomer(id);

        response.sendRedirect("CreateCustomer.html");

    }

}
