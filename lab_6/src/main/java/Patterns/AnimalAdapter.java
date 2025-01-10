package Patterns;

import Entity.Animal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AnimalAdapter {

    public static Element animalToXmlElement(Animal animal, Document document) {

        Element element = document.createElement("animal");
        NodeList list = document.getElementsByTagName("animal");
        int count = list.getLength();
        element.setAttribute("id", String.valueOf(++count));

        Element title = document.createElement("name");
        title.setTextContent(animal.getName());
        element.appendChild(title);

        Element author = document.createElement("careCost");
        author.setTextContent(String.valueOf(animal.getCareCost()));
        element.appendChild(author);

        return element;
    }

    public static Animal xmlElementToBook(Element element) {
        int id = Integer.parseInt(element.getAttribute("id"));
        String name = element.getElementsByTagName("name").item(0).getTextContent();
        double careCost = Double.parseDouble(element.getElementsByTagName("careCost").item(0).getTextContent());

        return new Animal(id, name, careCost);
    }
}
