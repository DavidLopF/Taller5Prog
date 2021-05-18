package co.edu.unbosque.Taller5Prog.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "listCustomer", value = "list-customer")
public class ListCustomersServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");





    }
}
