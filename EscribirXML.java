/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UF3;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 *
 * @author juand
 */
public class EscribirXML {

    public static void main(String[] args) {
        try {
            //Esto es siempre igual. Son Estos 5 pasos:
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();

            Document documento = implementation.createDocument(null, "personas", null);
            documento.setXmlVersion("1.0");

            //A partir de aquí, se añaden los elementos que se deseen en xml:
            Element persona = documento.createElement("persona");

            //ELEMENTO 1 DE PERSONA
            Element nombre = documento.createElement("nombre");
            Text textNombre = documento.createTextNode("Juan");
            nombre.appendChild(textNombre); //Indico que el texto es de este elemento
            persona.appendChild(nombre); //Indico que el elemento es de este (persona=padre; nombre=hijo)

            //ELEMENTO 2 DE PERSONA
            Element apellido = documento.createElement("apellido");
            Text textApellido = documento.createTextNode("Domenech");
            apellido.appendChild(textApellido);
            persona.appendChild(apellido);

            //ELEMENTO 3 DE PERSONA
            Element nacionalidad = documento.createElement("nacionalidad");
            Text textNacionalidad = documento.createTextNode("España");
            nacionalidad.appendChild(textNacionalidad);
            persona.appendChild(nacionalidad);

            //ELEMENTO 4 DE PERSONA
            Element edad = documento.createElement("edad");
            Text textEdad = documento.createTextNode("28");
            edad.appendChild(textEdad);
            persona.appendChild(edad);

            documento.getDocumentElement().appendChild(persona);

            //PERSONA 2
            persona = documento.createElement("persona");

            //ELEMENTO 1 DE PERSONA 2
            nombre = documento.createElement("nombre");
            textNombre = documento.createTextNode("Beatriz");
            nombre.appendChild(textNombre); //Indico que el texto es de este elemento
            persona.appendChild(nombre); //Indico que el elemento es de este (persona=padre; nombre=hijo)

            //ELEMENTO 2 DE PERSONA 2
            apellido = documento.createElement("apellido");
            textApellido = documento.createTextNode("De Águeda");
            apellido.appendChild(textApellido);
            persona.appendChild(apellido);

            //ELEMENTO 3 DE PERSONA 2
            nacionalidad = documento.createElement("nacionalidad");
            textNacionalidad = documento.createTextNode("Portugal");
            nacionalidad.appendChild(textNacionalidad);
            persona.appendChild(nacionalidad);

            //ELEMENTO 4 DE PERSONA 2
            edad = documento.createElement("edad");
            textEdad = documento.createTextNode("30");
            edad.appendChild(textEdad);
            persona.appendChild(edad);

            documento.getDocumentElement().appendChild(persona);

            //PERSONA 3
            persona = documento.createElement("persona");

            //ELEMENTO 1 DE PERSONA 3
            nombre = documento.createElement("nombre");
            textNombre = documento.createTextNode("Alex");
            nombre.appendChild(textNombre); //Indico que el texto es de este elemento
            persona.appendChild(nombre); //Indico que el elemento es de este (persona=padre; nombre=hijo)

            //ELEMENTO 2 DE PERSONA 3
            apellido = documento.createElement("apellido");
            textApellido = documento.createTextNode("Gunn");
            apellido.appendChild(textApellido);
            persona.appendChild(apellido);

            //ELEMENTO 3 DE PERSONA 3
            nacionalidad = documento.createElement("nacionalidad");
            textNacionalidad = documento.createTextNode("EEUU");
            nacionalidad.appendChild(textNacionalidad);
            persona.appendChild(nacionalidad);

            //ELEMENTO 4 DE PERSONA 3
            edad = documento.createElement("edad");
            textEdad = documento.createTextNode("58");
            edad.appendChild(textEdad);
            persona.appendChild(edad);

            documento.getDocumentElement().appendChild(persona);

            //ESTO TAMBIEN SE HACE SIEMPRE IGUAL. 
            Source source = new DOMSource(documento);
            Result result = new StreamResult(new File("personas.xml"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

            System.out.println("Fichero XML creado");
        } catch (ParserConfigurationException | TransformerException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
