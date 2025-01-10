package Commands;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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

public class DeleteAnimal {

    public static boolean deleteAnimal(int id) throws IOException, ParserConfigurationException, SAXException, TransformerException {

        boolean result = false;
        File file = new File("D:\\Documents\\LAB_WORKS_BSUIR\\SITAIRIS\\lab_6\\src\\main\\resources\\animals.xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            result = deleteAnimalFromXml(document, id);
            if (result) {
                TransformerFactory tFactory = TransformerFactory.newInstance();
                Transformer transformer = tFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");   //отступы
                DOMSource source = new DOMSource(document);
                StreamResult sResult = new StreamResult(file);
                transformer.transform(source, sResult);
                System.out.println("Животное успешно удалено.");
            } else {
                System.out.println("Животное не найдена.");
            }
        }catch (Exception e){
            System.out.println("Произошла ошибка");
        }
        return result;
    }

    public static boolean deleteAnimalFromXml(Document document, int id) {
        NodeList list = document.getElementsByTagName("animal");
        boolean result = false;
        int length = list.getLength();
        for (int i = 0; i < length; i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                if (element.getAttribute("id").equals(String.valueOf(id))) {
                    Node prev = node.getPreviousSibling();
                    if (prev != null && prev.getNodeType() == Node.TEXT_NODE && prev.getNodeValue().trim().length() == 0) {
                        document.getDocumentElement().removeChild(prev);
                    }
                    document.getDocumentElement().removeChild(element);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}
