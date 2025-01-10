package Commands;

import Entity.Animal;
import Patterns.AnimalAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXML {
    public static List<Animal> readAnimal() {

        File file = new File("D:\\Documents\\LAB_WORKS_BSUIR\\SITAIRIS\\lab_6\\src\\main\\resources\\animals.xml");
        List<Animal> animals = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            String rootNode = document.getDocumentElement().getNodeName();
            System.out.println("Корневой элемент: " + rootNode);
            animals = getAnimalsData(document);
            for (Animal animal : animals) {
                System.out.println(animal);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return animals;
    }

    private static List<Animal> getAnimalsData(Document document) {
        NodeList list = document.getElementsByTagName("animal");
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                Animal animal = AnimalAdapter.xmlElementToBook(element);
                System.out.println("Animal parsed: " + animal);

                animals.add(animal);
            }
        }
        return animals;
    }
}
