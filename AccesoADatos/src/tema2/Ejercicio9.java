package tema2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ejercicio9 {
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        String nombre="",telefono="0";
        int antiguedad=0;
        Empleado.Puesto puesto=null;
        boolean indefinido=false,bucle=true,buclePuesto=false;
        IO.println("Escribe la ruta al fichero que almacenará la información de los empleados");
        String fichero=sc.nextLine();
        try (ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero,true))){
            do{
                IO.println("Cual es el nombre del empleado");
                nombre=sc.nextLine();
                do {
                    IO.println("Cual es el telefono del empleado, 9 dígitos");
                    telefono = sc.nextLine();
                }while (telefono.length()!=9);

                IO.println("Cual es la antigüedad del empleado");
                antiguedad=sc.nextInt();
                sc.nextLine();
                IO.println("Si el contrato del empleado es indefinido pulsa 1 sino pulsa cualquier tecla");
                indefinido="1".equals(sc.nextLine())?true:false;
                do {
                    buclePuesto=false;
                    IO.println("Selecciona el número que corresponde con el puesto del empleado" +
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
                        default->{
                                    IO.println("Solo puedes seleccionar una opcion del 1 al 5");
                                    buclePuesto=true;
                        }
                    }
                }while (buclePuesto);
                Empleado empleado=new Empleado(nombre,puesto,antiguedad,telefono,indefinido);
                oos.writeObject((Empleado)empleado);
                IO.println("Escribe un 1 para dejar de introducir empleados");
                bucle="1".equals(sc.nextLine())?false:true;
            }while(bucle);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
