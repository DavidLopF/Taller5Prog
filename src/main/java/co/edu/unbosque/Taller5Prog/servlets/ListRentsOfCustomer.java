package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.RentService;
import co.edu.unbosque.Taller5Prog.servlets.pojos.RentPOJO;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.PrinterAbortException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieStore;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "listRents", value = "/list-Rents")
public class ListRentsOfCustomer extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json");

        Cookie[] cookies = request.getCookies();
        String desde = cookies[1].getValue();
        String email_customer = cookies[2].getValue();
        String hsta = cookies[3].getValue();

        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("email_customer")) {
                email_customer = cookies[i].getValue();
            } else if (cookies[i].getName().equals("desde")) {
                desde = cookies[i].getValue();
            } else if (cookies[i].getName().equals("hasta")) {
                hsta = cookies[i].getValue();
            }
        }


        RentService rentService = new RentService();
        List<RentPOJO> rentPOJOList = rentService.listRentsByCustomer(email_customer, desde, hsta);

        String json = new Gson().toJson(rentPOJOList);

        PrintWriter out = response.getWriter();
        out.print(json);

    }
}
