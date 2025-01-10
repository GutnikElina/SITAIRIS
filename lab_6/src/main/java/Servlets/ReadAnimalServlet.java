package Servlets;

import Commands.ReadXML;
import Entity.Animal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReadAnimalServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Animal> animals = ReadXML.readAnimal();
        System.out.println("Animals: " + animals);
        request.setAttribute("animals", animals);
        request.getRequestDispatcher("animals.jsp").forward(request, response);
    }
}
