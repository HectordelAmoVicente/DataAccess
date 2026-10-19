package tema3;

public class Alumno {
    private String nombre;
    private String apellidos;
    private int notaAD;
    private int notaPSP;
    private int notaSGE;
    public Alumno(String nombre, String apellidos,int notaAD, int notaPSP, int notaSGE) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.notaAD = notaAD;
        this.notaPSP = notaPSP;
        this.notaSGE = notaSGE;
    }
    @Override
    public String toString() {
        return "Nombre: "+nombre
                + "\nApellidos: "+apellidos
                + "\nNota AD: "+notaAD
                + "\nNota PSP: "+notaPSP
                + "\nNota SGE: "+notaSGE;
    }
}
