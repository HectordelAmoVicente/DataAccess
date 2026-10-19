package tema3;


import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class ParserAlumnos extends DefaultHandler {
    private GestorAlumnos gestor = new GestorAlumnos();
    private String nombre;
    private String apellidos;
    private int notaAD;
    private int notaPSP;
    private int notaSGE;
    private StringBuilder texto = new StringBuilder();
    @Override
    public void startElement(String uri, String localName,String qName, Attributes attributes){
        texto.setLength(0);
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        texto.append(ch, start, length);
    }
    @Override
    public void endElement(String uri,String localName,String qName) {
        String valor=texto.toString().trim();
        switch (qName) {
            case "nombre":
                nombre=valor;
                break;
            case "apellidos":
                apellidos=valor;
                break;
            case "notaAD":
                notaAD=Integer.parseInt(valor);
                break;
            case "notaPSP":
                notaPSP=Integer.parseInt(valor);
                break;
            case "notaSGE":
                notaSGE=Integer.parseInt(valor);
                break;
            case "alumno":
                Alumno alumno=new Alumno(nombre, apellidos,notaAD,notaPSP,notaSGE);
                gestor.agregarAlumno(alumno);
                break;
        }
        texto.setLength(0);
    }
    public GestorAlumnos getGestor() {
        return gestor;
    }
}

