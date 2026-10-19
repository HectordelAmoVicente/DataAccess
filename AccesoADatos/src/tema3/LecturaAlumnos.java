package tema3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LecturaAlumnos{
    public static void main(String[] args){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(new File("C:\\Users\\DAM_201\\Documents\\xml\\Alumnos.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Raíz del documento: "+document.getDocumentElement().getNodeName());
            NodeList alumnos=document.getElementsByTagName("alumno");
            System.out.printf("\nNúmero de nodos alumno: "+alumnos.getLength()+"\n");

            for(int i=0;i< alumnos.getLength();i++){
                Node alu=alumnos.item(i);
                if(alu.getNodeType()==Node.ELEMENT_NODE){
                    Element elemento=(Element)alu;
                    System.out.println("ID: "+elemento.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println("* Nombre: "+elemento.getElementsByTagName("nombre").item(0).getTextContent());
                    System.out.println("* Apellido: "+elemento.getElementsByTagName("apellido").item(0).getTextContent());
                    System.out.println("* Curso: "+elemento.getElementsByTagName("curso").item(0).getTextContent());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}