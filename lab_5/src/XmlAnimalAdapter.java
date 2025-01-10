import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Models.Animal;
import Models.Cat;
import Models.Dog;
import org.w3c.dom.*;

public class XmlAnimalAdapter implements AnimalPersistenceAdapter {
    private final String filePathAll;
    private final String filePathAdopted;

    public XmlAnimalAdapter(String filePathAll, String filePathAdopted) {
        this.filePathAll = filePathAll;
        this.filePathAdopted = filePathAdopted;
    }

    @Override
    public List<Animal> loadAnimals() {
        List<Animal> animals = new ArrayList<>();
        try {
            File inputFile = new File(filePathAll);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("animal");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nNode;
                    String type = element.getElementsByTagName("type").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    double careCost = Double.parseDouble(element.getElementsByTagName("careCost").item(0).getTextContent());
                    Animal animal = "dog".equalsIgnoreCase(type) ? new Dog(name, careCost) : new Cat(name, careCost);
                    animals.add(animal);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return animals;
    }

    @Override
    public void saveAnimals(List<Animal> animals) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("animals");
            doc.appendChild(rootElement);

            for (Animal animal : animals) {
                Element animalElement = doc.createElement("animal");
                rootElement.appendChild(animalElement);

                Element typeElement = doc.createElement("type");
                typeElement.appendChild(doc.createTextNode(animal.getType()));
                animalElement.appendChild(typeElement);

                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(animal.getName()));
                animalElement.appendChild(nameElement);

                Element careCostElement = doc.createElement("careCost");
                careCostElement.appendChild(doc.createTextNode(String.valueOf(animal.getCareCost())));
                animalElement.appendChild(careCostElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePathAll));

            transformer.transform(source, result);
            System.out.println("Данные сохранены в XML файл!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void saveAdoptedAnimals(List<Animal> adoptedAnimals) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            Element rootElement = doc.createElement("adoptedAnimals");
            doc.appendChild(rootElement);

            for (Animal animal : adoptedAnimals) {
                Element animalElement = doc.createElement("animal");
                rootElement.appendChild(animalElement);

                Element typeElement = doc.createElement("type");
                typeElement.appendChild(doc.createTextNode(animal.getType().toLowerCase()));
                animalElement.appendChild(typeElement);

                Element nameElement = doc.createElement("name");
                nameElement.appendChild(doc.createTextNode(animal.getName()));
                animalElement.appendChild(nameElement);

                Element careCostElement = doc.createElement("careCost");
                careCostElement.appendChild(doc.createTextNode(String.valueOf(animal.getCareCost())));
                animalElement.appendChild(careCostElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePathAdopted));

            transformer.transform(source, result);
            System.out.println("Данные животных сохранены в XML файл!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
