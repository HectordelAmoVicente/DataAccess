package tema2;

import java.io.*;
import java.util.Scanner;

public class Ejercicio14 {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        IO.println("Escribe la ruta del fichero que vas a leer");
        String ficheroLectura=sc.nextLine();
        IO.println("Escribe la ruta del fichero donde vas a copiar el contenido del fichero que lees");
        String ficheroEscritura=sc.nextLine();
        String line="";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroEscritura, true));
        BufferedReader br=new BufferedReader(new FileReader(ficheroLectura))) {
            while((line=br.readLine())!=null){
                bw.write(line);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
