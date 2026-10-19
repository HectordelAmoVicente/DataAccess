package tema3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;

public class LecturaAsignaturas {
    public static void main(String[] args){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(new File("resources\\asignaturas.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Raíz del documento: "+document.getDocumentElement().getNodeName());
            NodeList asignaturas=document.getElementsByTagName("asignatura");
            System.out.printf("\nNúmero de nodos asignatura: "+asignaturas.getLength()+"\n");

            for(int i=0;i< asignaturas.getLength();i++){
                Node asignaturaNode=asignaturas.item(i);
                if(asignaturaNode.getNodeType()==Node.ELEMENT_NODE){
                    Element asignatura=(Element)asignaturaNode;
                    System.out.println("* Nombre: "+asignatura.getAttribute("nombre"));
                    System.out.println("* Horas: "+asignatura.getElementsByTagName("horas").item(0).getTextContent());
                    System.out.println("* Profesor: "+asignatura.getElementsByTagName("profesor").item(0).getTextContent());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
