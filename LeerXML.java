/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author juand
 */
public class LeerXML {

    public static void main(String[] args) {
        //LEER ARCHIVOS XML
        try {
            //Mismos pasos que antes (sin DOMImplementation, solo queremos leer):
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.parse(new File("personas.xml"));

            NodeList listaPersonas = documento.getElementsByTagName("persona");

            for (int i = 0; i < listaPersonas.getLength(); i++) {
                Node nodo = listaPersonas.item(i); //Selecciona el nodo
                if (nodo.getNodeType() == Node.ELEMENT_NODE) { //Filtra los nodos (quita metadatos). Cuando sea un tag, lee.
                    Element e = (Element) nodo;
                    NodeList hijos = e.getChildNodes();

                    for (int j = 0; j < hijos.getLength(); j++) {
                        Node hijo = hijos.item(j);
                        if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println("Nodo: " + hijo.getNodeName() + " ---> Texto: " + hijo.getTextContent());
                        }
                    }
                }
            }
        } catch (ParserConfigurationException | IOException | SAXException ex) {
            Logger.getLogger(LeerXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
