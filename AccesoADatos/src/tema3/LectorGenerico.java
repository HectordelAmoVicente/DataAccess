package tema3;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;

public class LectorGenerico {

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
            System.out.println(nodo.getNodeName());
            NamedNodeMap atributos=nodo.getAttributes();
            for (int i=0;i<atributos.getLength(); i++) {
                Node atributo=atributos.item(i);
                System.out.println("  ".repeat(nivel+1)+atributo.getNodeName()+": "+atributo.getNodeValue());
            }
        }
        if (nodo.getNodeType()==Node.TEXT_NODE) {
            String texto =nodo.getNodeValue().trim();
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
