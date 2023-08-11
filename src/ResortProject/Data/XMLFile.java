package ResortProject.Data;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
/**
 *
 * @author ryanz
 */
public class XMLFile {
    
    public Element root;
    
    public XMLFile(String filename) {
        try {
            File inputFile = new File(filename);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            
            // Get the root element
            this.root = document.getDocumentElement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
