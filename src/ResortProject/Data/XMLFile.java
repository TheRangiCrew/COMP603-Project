package ResortProject.Data;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;

/**
 * Class to read in XML data and parse it into Document Objects. Handles the
 * reading and writing of XML data between the file system and other classes
 */
public class XMLFile {

    // The root element of the file
    private Element root;
    // The file to access
    private File file;

    /**
     * Constructor
     * Initialise and read the first elements of the provided XML file as Document
     * Elements
     * 
     * @param filename the file to access
     * @see Document
     * @see Element
     */
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

    /**
     * Transform and save the provided document object into an XML file. Uses the
     * File initialised from the constructor
     * 
     * @param document
     * @see Document
     */
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

    /**
     * A helper function to retrieve all XML Elements with a given tag name and
     * return their content as text
     * 
     * @param element the parent Element to access
     * @param tagName the name of the tag to find
     * @return the text contents of the discovered Node, else {@code null}
     * @see Element
     */
    public static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return null;
        }
    }

    /**
     * 
     * @return the root ELement of the XML Document
     * @see Element
     */
    public Element getRoot() {
        return this.root;
    }

}
