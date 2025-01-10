package Servlets;

import Commands.DeleteAnimal;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class DeleteAnimalServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");

        try {
            int id = Integer.parseInt(idStr);

            boolean result = DeleteAnimal.deleteAnimal(id);

            if (result) {
                request.getSession().setAttribute("successMessage", "Животное успешно удалено");
            } else {
                request.getSession().setAttribute("errorMessage", "Животное не найдена");
            }

        } catch (NumberFormatException e) {
            request.getSession().setAttribute("errorMessage", "Введите корректный id животного");
        } catch (ParserConfigurationException | TransformerException | SAXException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect("index.jsp");
    }
}
