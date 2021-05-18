package co.edu.unbosque.Taller5Prog.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "createCookeLibrary", value = "/createCookeLibrary")
public class CreateCookeLibrary extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String bookId = request.getParameter("selectLibro");
        Cookie cookieId = new Cookie("bookId",bookId);
        response.addCookie(cookieId);
        response.sendRedirect("mostrarTabla.html");
    }

}
