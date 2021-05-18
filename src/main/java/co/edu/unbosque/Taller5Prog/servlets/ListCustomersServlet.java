package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.jpa.entities.Customer;
import co.edu.unbosque.Taller5Prog.services.CustomerService;
import co.edu.unbosque.Taller5Prog.servlets.pojos.CustomerPOJO;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listCustomer", value = "list-customer")
public class ListCustomersServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        CustomerService customerService = new CustomerService();
        List<CustomerPOJO> customerPOJOList = customerService.listCustomers();
        String customerJsonString = new Gson().toJson(customerPOJOList);

        PrintWriter out = response.getWriter();
        out.print(customerJsonString);
        out.flush();


    }
}
