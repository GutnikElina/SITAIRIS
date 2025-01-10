package Commands;

import Entity.Animal;
import Patterns.AnimalAdapter;
import Patterns.AnimalFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class AddAnimal {

    public static void addAnimal(String name, double careCost)
            throws IOException, ParserConfigurationException, SAXException, TransformerException {

        File file = new File("D:\\Documents\\LAB_WORKS_BSUIR\\SITAIRIS\\lab_6\\src\\main\\resources\\animals.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        Animal animal = AnimalFactory.createAnimal(name, careCost);

        Element element = AnimalAdapter.animalToXmlElement(animal, document);
        document.getDocumentElement().appendChild(element);

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult sResult = new StreamResult(file);
        transformer.transform(source, sResult);

        System.out.println("Животное успешно добавлено.");
    }
}
