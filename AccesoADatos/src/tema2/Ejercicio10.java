package tema2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio10 {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        boolean bucle=true,buclePuesto=false,bucleAntiguedad=false;
        ArrayList<Empleado> empleados=new ArrayList<>();
        int numAntiguedad=0,opcionAntiguedad=0;
        Empleado.Puesto puesto=null;
        IO.println("Escribe la ruta al fichero de empleados");
        String fichero=sc.nextLine();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            while(true){
                empleados.add((Empleado)ois.readObject());
            }
        } catch (EOFException e) {
            IO.println("Fichero leido con éxito");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        do {
            IO.println("En base a que criterio quieres mostrar empleados" +
                    "\n1-Puesto" +
                    "\n2-Antiguedad" +
                    "\n3-Indefinidos" +
                    "\n4-Salir del programa");
            switch(sc.nextLine()){
                case "1"->{
                    do {
                        buclePuesto=false;
                        IO.println("Selecciona el número que corresponde con el puesto de los empleados que quieres mostrar" +
                                "\n1-Analista" +
                                "\n2-Programador" +
                                "\n3-Tester" +
                                "\n4-Becario" +
                                "\n5-Jefe de Equipo");
                        switch (sc.nextLine()) {
                            case "1" -> puesto = Empleado.Puesto.analista;
                            case "2" -> puesto = Empleado.Puesto.programador;
                            case "3" -> puesto = Empleado.Puesto.tester;
                            case "4" -> puesto = Empleado.Puesto.becario;
                            case "5" -> puesto = Empleado.Puesto.jefeDeEquipo;
                            default -> {
                                IO.println("Solo puedes seleccionar una opcion del 1 al 5");
                                buclePuesto = true;
                            }
                        }
                        for (Empleado e:empleados){
                            if(e.getPuesto().equals(puesto)){
                                IO.println(e);
                            }
                        }
                    }while(buclePuesto);
                }
                case "2"->{
                    do{
                        bucleAntiguedad=false;
                        IO.println("Escribe un numero de años de antiguedad para buscar empleados con esa antiguedad, o una mayor a ese numero o una menor");
                        numAntiguedad=sc.nextInt();
                        sc.nextLine();
                        IO.println("¿Quieres buscar empleados con una antiguedad respecto al numero que has escogido?:" +
                                "\n1-Mayor" +
                                "\n2-Menor" +
                                "\n3-Igual");
                        opcionAntiguedad=sc.nextInt();
                        sc.nextLine();
                        if (opcionAntiguedad==1){
                            for (Empleado e:empleados){
                                if(e.getAntiguedad()>numAntiguedad){
                                    IO.println(e);
                                }
                            }
                        }else if(opcionAntiguedad==2){
                            for (Empleado e:empleados){
                                if(e.getAntiguedad()>numAntiguedad){
                                    IO.println(e);
                                }
                            }
                        } else if (opcionAntiguedad==3) {
                            for (Empleado e:empleados){
                                if(e.getAntiguedad()==numAntiguedad){
                                    IO.println(e);
                                }
                            }
                        }else{
                            IO.println("Tienes que introducir un numero del 1 al 3");
                            bucleAntiguedad=true;
                        }
                    }while(bucleAntiguedad);
                }
                case "3"->{
                    IO.println("Escribe un 1 si quieres ver empleados indefinidos y cualquier tecla si quieres ver no indefinidos");
                    if (sc.nextLine().equals("1")){
                        for (Empleado e:empleados){
                            if(e.isIndefinido()){
                                IO.println(e);
                            }
                        }
                    }else{
                        for (Empleado e:empleados){
                            if(!e.isIndefinido()){
                                IO.println(e);
                            }
                        }
                    }
                }
                case "4"->bucle=false;
                default ->IO.println("Escribe un numero del 1 al 4");
            }
        }while(bucle);
    }
}
