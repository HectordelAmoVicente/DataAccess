package tema2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio7 {
    private static Scanner sc=new Scanner(System.in);
    private static ArrayList<String> text=new ArrayList<>();
    private static boolean copy=false;
    public static void main(String[] args){
        IO.println("Write the name of the file to be copied");
        String fileToBeCopied=sc.nextLine();
        try(BufferedReader br=new BufferedReader(new FileReader(new File(fileToBeCopied)))){
            String line="";
            while((line = br.readLine()) != null){
                text.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IO.println("Write the name of the copied file");
        String copiedFile=sc.nextLine();
        if(new File(copiedFile).exists()){
            IO.println("The file already exists\n\n1.Overwrite the file (delete the old and create the new one)" +
                    "\n2.Cancel the execution of the file");
            int option=sc.nextInt();
            sc.nextLine();
            if(option==1){
                copy=true;
            }
        }else copy=true;
        if(copy){
            try (BufferedWriter bw=new BufferedWriter(new FileWriter(new File(copiedFile),false))){
                for (String l:text){
                    bw.write(l);
                    bw.newLine();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
