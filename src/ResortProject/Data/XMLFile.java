package ResortProject.Data;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;
/**
 *
 * @author ryanz
 */
public class XMLFile {
    
    public Element root;
    private File file;
    
    public XMLFile(String filename) {
        try {
            file = new File(filename);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
                        
            // Get the root element
            this.root = document.getDocumentElement();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    
    public void save(Document document) {
        try {
            // Transform the DOM document to XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            // Write to the file
            FileWriter fileWriter = new FileWriter(this.file);
            transformer.transform(new DOMSource(document), new StreamResult(fileWriter));
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to finish writing data to a file!");
        } catch (TransformerException e) {
            System.out.println("Failed to transform an XML Document Object!");
        }
    }
    
    public static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return null;
        }
    }
    
}
