package tema3;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class RecrearXML {
    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document documento=builder.parse(new File("resources\\asignaturas.xml"));
            recorrerNodos(documento.getDocumentElement(), 0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void recorrerNodos(Node nodo, int nivel) {
        if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            for (int i=0;i<nivel;i++) {
                System.out.print("  ");
            }
            NamedNodeMap atributos=nodo.getAttributes();
            if(atributos!=null) {
                if(atributos.getLength()==0){
                    System.out.println("<"+nodo.getNodeName()+">");
                }else System.out.println("<"+nodo.getNodeName());
                for (int i=0;i<atributos.getLength(); i++) {
                    Node atributo=atributos.item(i);
                    if(i+1==atributos.getLength()){
                        System.out.println("  ".repeat(nivel + 1) + atributo.getNodeName() + ": " + atributo.getNodeValue()+">");
                    }else System.out.println("  ".repeat(nivel + 1) + atributo.getNodeName() + ": " + atributo.getNodeValue());
                }

            }else System.out.println("<"+nodo.getNodeName()+">");
        }
        if (nodo.getNodeType()==Node.TEXT_NODE) {
            String texto=nodo.getNodeValue().trim();
            if (!texto.isEmpty()) {
                System.out.println("  ".repeat(nivel)+texto);
            }
        }
        NodeList hijos = nodo.getChildNodes();
        for (int i=0;i<hijos.getLength();i++) {
            Node hijo = hijos.item(i);
            recorrerNodos(hijo,nivel+1);
        }
    }
}
