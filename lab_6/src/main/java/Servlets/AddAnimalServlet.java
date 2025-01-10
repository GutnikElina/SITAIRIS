package Servlets;

import Commands.AddAnimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAnimalServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String careCost = request.getParameter("careCost");

        double price = 0;

        if (name == null || careCost == null) {
            request.getSession().setAttribute("errorMessage", "Все поля должны быть заполнены");
            return;
        }

        try {
            price = Double.parseDouble(careCost);
            if (price<0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            request.getSession().setAttribute("errorMessage", "Неверный формат цены");
            return;
        }

        try {
            AddAnimal.addAnimal(name, price);
            request.getSession().setAttribute("successMessage", "Животное успешно добавлено");
            response.sendRedirect("index.jsp");
        } catch (Exception e) {
            response.getWriter().println("Произошла ошибка: " + e.getMessage());
        }
    }
}
