package tema2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Ejercicio4 {
    private static String[] text=new String[]{};

    public static void main(String[] args){
        IO.println("fdeefef");
        try(BufferedReader br=new BufferedReader(new FileReader("resources\\el_quijote.txt"))){
            String line=br.readLine();
            while(!line.contains("FIN")){
                text=Arrays.copyOf(text,text.length+1);
                text[text.length-1]=line;
                line=br.readLine();
            }
            for(String l:text){
                IO.println(l);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
