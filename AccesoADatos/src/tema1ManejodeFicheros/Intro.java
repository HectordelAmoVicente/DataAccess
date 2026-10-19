package tema1ManejodeFicheros;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Intro {
    static Scanner sc=new Scanner(System.in);
        public static void main(){
            pedirCarpeta();
            /*
            System.out.println("¿Que ejercicio quieres ejecutar?");
            int numEj=sc.nextInt();
            sc.nextLine();
            switch(numEj){
                case 1: ejercicio1(); break;
                case 2: ejercicio2(); break;
                case 3: ejercicio3(); break;
                case 4: ejercicio4();break;
                case 5:ejercicio5();break;
                case 6: ejercicio6();break;
                case 7: ejercicio7();break;
                case 8: ejercicio8();break;
                case 9: pedirCarpeta();break;
            }
            */

        }
        public static void ejercicio1(){
            String ruta=new String();
            System.out.println("Introduce la ruta absoluta de una carpeta");
            ruta=sc.nextLine();
            File directorio=new File(ruta);
            for(File archivo:directorio.listFiles())
                if(archivo.isFile()){
                    System.out.println("F-"+archivo.getName());
                }else if(archivo.isDirectory()){
                    System.out.println("D-"+archivo.getName());
                }
        }
    public static void ejercicio2(){
        String ruta=new String();
        System.out.println("Introduce la ruta absoluta de una carpeta");
        ruta=sc.nextLine();
        File directorio=new File(ruta);
        for(File archivo:directorio.listFiles())
            if(archivo.isFile()){
                System.out.println(archivo.getName()+" "+archivo.length());
            }
    }
    public static void ejercicio3(){
            String marca=new String();
        Path ruta= Paths.get("coches.txt");
        List<String> lineas=new ArrayList<>();
        try (BufferedReader br=new BufferedReader((new FileReader("coches.txt")))){
            lineas=Files.readAllLines(ruta);
            for (String elemento:lineas){
                marca=elemento.split(";")[0];
                marcasDeCoches(marca,elemento);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void marcasDeCoches(String marca,String coche){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("marcas\\"+marca+".txt",true))){
            bw.write(coche);
            bw.newLine();

        }catch (IOException e){

        }
    }
    public static void ejercicio4(){
            String ruta=new String();
            System.out.println("Introduce la ruta de un fichero");
            ruta=sc.nextLine();
            File file=new File(ruta);
            file.delete();
    }
    public static void ejercicio5(){
        String ruta=new String();
        System.out.println("Escribe la ruta de un directorio");
        ruta=sc.nextLine();
        File dir=new File(ruta);
        for(int i=1;i<=10;i++){
            File file=new File(dir.getName()+"\\alumnos"+i+".txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void ejercicio6(){
        String ruta=new String();
        System.out.println("Escribe la ruta de la carpeta");
        ruta=sc.nextLine();
        File dir=new File(ruta+"\\fotosCantabria\\fotosSantander\\fotosPlayaSantander");
        dir.mkdirs();
        File dir1=new File(ruta+"\\fotosCantabria\\fotosSantander\\fotosPuertoSantander");
        dir1.mkdirs();
        File dir2=new File(ruta+"\\fotosCantabria\\fotosSanVicente\\fotosPlayaSanVicente");
        dir2.mkdirs();
        File dir3=new File(ruta+"\\fotosCantabria\\fotosSanVicente\\fotosPuebloSanVicente");
        dir3.mkdirs();
        File dir4=new File(ruta+"\\fotosAsturias\\fotosLlanes\\fotosPlayaLlanes");
        dir4.mkdirs();
        File dir5=new File(ruta+"\\fotosAsturias\\fotosLlanes\\fotosPuebloLLanes");
        dir5.mkdirs();
        File dir6=new File(ruta+"\\fotosAsturias\\fotosDescensoSella");
        dir6.mkdirs();
       
        }
        public static void ejercicio7(){
            String ruta=new String();
            IO.println("Escribe la ruta de la carpeta que contiene los ficheros que van a ser renombrados");
            ruta=sc.nextLine();
            File carpeta=new File(ruta);
            File[] archivos=carpeta.listFiles();
            for(int i=0;i<archivos.length;i++){
                String extension=archivos[i].getName().split("\\.")[1];
                int numero=i+1;
                archivos[i].renameTo(new File(carpeta,"archivo"+numero+"."+extension));
            }
        }
    public static void ejercicio8() {
        Path pathQuijote = Path.of("resources", "el_quijote.txt");
        ArrayList<String> lines = new ArrayList<String>();
        ArrayList<String> chapters = new ArrayList<String>();
        ArrayList<String> firstLines = new ArrayList<String>();
        String chapter = "";
        boolean writing = false;
        try {
            lines = (ArrayList<String>) Files.readAllLines(pathQuijote);
            for (String line : lines) {
                if (line.contains("CAPÍTULO")) {
                    writing = true;
                }
                if (writing && line.equals(line.toUpperCase())) {
                    chapter += line;
                } else if (writing) {
                    chapters.add(chapter);
                    chapter = "";
                    writing = false;
                    firstLines.add(line);
                }
            }
            for (int i = 0; i < chapters.size(); i++) {
                IO.println(chapters.get(i));
                IO.println(firstLines.get(i));
                IO.println("\n\n\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        public static void pedirCarpeta(){
            Scanner sc=new Scanner(System.in);
            IO.println("introduce la ruta de la carpeta");
            String rutaCarpeta=sc.nextLine();
            File carpeta=new File(rutaCarpeta);
            byte nivelProfundidad=0;
            ArrayList<String> tipoArchivos=new ArrayList<>();
            HashMap<String,Byte> numeroArchivosTipo=new HashMap<>();
            System.out.println("Nivel de profundidad:"+recorrerCarpeta(carpeta, (byte) (nivelProfundidad),tipoArchivos,numeroArchivosTipo)+"\nTipo de archivos:"+tipoArchivos.toString()+
                    "\nNumero archivos por tipo:"+numeroArchivosTipo.toString());
        }
        //C:\Users\DAM_201\Desktop\DI_Actividades3a9_Hector
        private static byte recorrerCarpeta(File carpeta, byte nivelProfundidad, ArrayList<String> tipoArchivos, HashMap<String, Byte> numeroArchivosTipo) {
            if(carpeta.listFiles()!=null||carpeta.listFiles().length==0){
                nivelProfundidad++;
            }
            for (File file : carpeta.listFiles()) {
                if(file.isDirectory()){
                    byte profundidad=recorrerCarpeta(file, (byte) (nivelProfundidad),tipoArchivos,numeroArchivosTipo);
                    if(profundidad>nivelProfundidad){
                        nivelProfundidad=profundidad;
                    }
                }else if(file.isFile()){
                    int posicionPunto=file.getName().lastIndexOf(".");
                    String tipoArchivo=file.getName().substring(posicionPunto+1);
                    if(!tipoArchivos.contains(tipoArchivo)){
                        tipoArchivos.add(tipoArchivo);
                    }
                    if(numeroArchivosTipo.keySet().contains(tipoArchivo)){
                        byte numArchivos= (byte) (numeroArchivosTipo.get(tipoArchivo)+1);
                        numeroArchivosTipo.replace(tipoArchivo,numArchivos);
                    }else{
                        numeroArchivosTipo.put(tipoArchivo, (byte) 1);
                    }
                }
            }
            return nivelProfundidad;
        }
}


