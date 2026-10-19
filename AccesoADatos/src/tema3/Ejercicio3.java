package tema3;


import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Ejercicio3 {

    public static void main(String[] args) {

        try {
            SAXParserFactory factory=SAXParserFactory.newInstance();
            SAXParser parser=factory.newSAXParser();
            ParserAlumnos manejador=new ParserAlumnos();
            parser.parse(new File("resources\\alumnos.xml"),manejador);
            GestorAlumnos gestor = manejador.getGestor();
            gestor.mostrarAlumnos();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
