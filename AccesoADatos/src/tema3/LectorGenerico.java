package tema3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class LectorGenerico {
    public static void main(String[] args){
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();

        try{
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document document=builder.parse(new File("C:\\Users\\DAM_201\\Documents\\xml\\Alumnos.xml"));
            document.getDocumentElement().normalize();

            System.out.printf("Raíz del documento: "+document.getDocumentElement().getNodeName()+"\n");
            Element documento=document.getDocumentElement();
            recorrerNodo(documento);
        }catch(Exception e){
            e.printStackTrace();
        }
    }   

    private static void recorrerNodo(Element documento) {
        NodeList nodes= documento.getChildNodes();
        for(int i=0;i<nodes.getLength();i++) {
            Node node=nodes.item(i);
            if(node.getNodeType()==Node.ELEMENT_NODE){
                recorrerNodo((Element)node);
            }else{
                Element element=(Element) node;
                System.out.println("Elemento : "+element.getTextContent());

            }
        }
    }

}



