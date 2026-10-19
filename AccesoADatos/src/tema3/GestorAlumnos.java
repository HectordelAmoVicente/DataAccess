package tema3;

import java.util.ArrayList;

public class GestorAlumnos {
    private ArrayList<Alumno> alumnos = new ArrayList<>();
    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }
    public void mostrarAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
            System.out.println("--------------------");
        }
    }
}
