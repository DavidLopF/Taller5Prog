package co.edu.unbosque.Taller5Prog.servlets;

import co.edu.unbosque.Taller5Prog.services.EditionService;
import co.edu.unbosque.Taller5Prog.services.LibraryService;
import co.edu.unbosque.Taller5Prog.servlets.pojos.EdtionPOJO;
import co.edu.unbosque.Taller5Prog.servlets.pojos.LibraryPOJO;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listEditionServlet", value = "/list-edtions")
public class listEditionsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        EditionService editionService = new EditionService();
        List<EdtionPOJO> editions = editionService.listEditions();


        String librariesJsonString = new Gson().toJson(editions);

        PrintWriter out = response.getWriter();
        out.print(librariesJsonString);
        out.flush();


    }

}
