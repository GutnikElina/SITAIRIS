package Patterns;

import Entity.Animal;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalAdapterTest {

    @Test
    public void testAnimalToXmlElement() throws Exception {
        Animal animal = new Animal(1, "Кролик", 150.0);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element element = AnimalAdapter.animalToXmlElement(animal, document);

        assertNotNull(element);
        assertEquals("1", element.getAttribute("id"));
        assertEquals("Кролик", element.getElementsByTagName("name").item(0).getTextContent());
        assertEquals("150.0", element.getElementsByTagName("careCost").item(0).getTextContent());
    }

    @Test
    public void testXmlElementToAnimal() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element element = document.createElement("animal");
        element.setAttribute("id", "1");

        Element name = document.createElement("name");
        name.setTextContent("Кролик");
        element.appendChild(name);

        Element careCost = document.createElement("careCost");
        careCost.setTextContent("150.0");
        element.appendChild(careCost);

        Animal animal = AnimalAdapter.xmlElementToBook(element);

        assertNotNull(animal);
        assertEquals(1, animal.getId());
        assertEquals("Кролик", animal.getName());
        assertEquals(150.0, animal.getCareCost());
    }
}
