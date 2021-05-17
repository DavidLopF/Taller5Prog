package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.jpa.entities.Edition;
import co.edu.unbosque.Taller5Prog.services.EditionService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteEdition", value = "/delete-edicion")
public class DeleteEditionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        int id_edition = Integer.parseInt(request.getParameter("selectEdicion"));

        EditionService editionService = new EditionService();
        editionService.deleteBy(id_edition);


        response.sendRedirect("crearEdicion.html");

    }

}
