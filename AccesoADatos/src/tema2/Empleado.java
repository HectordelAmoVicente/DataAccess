package tema2;

public class Empleado {
    enum Puesto{analista,programador,tester,becario,jefeDeEquipo};
    private String nombre;
    private Puesto puesto;
    private int antiguedad;
    private String telefono;
    private boolean indefinido;

    public Empleado(String nombre, Puesto puesto, int antiguedad, String telefono, boolean indefinido) {
        this.nombre = nombre;
        this.puesto = puesto;
        this.antiguedad = antiguedad;
        this.telefono = telefono;
        this.indefinido = indefinido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isIndefinido() {
        return indefinido;
    }

    public void setIndefinido(boolean indefinido) {
        this.indefinido = indefinido;
    }
}
