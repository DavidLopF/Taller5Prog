package co.edu.unbosque.Taller5Prog.servlets.pojos;

public class RentPOJO {

    private String edicion;
    private String fecha;
    private String libro;

    public RentPOJO(String edicion, String fecha, String libro) {
        this.edicion = edicion;
        this.fecha = fecha;
        this.libro = libro;
    }


    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getLibro() {
        return libro;
    }

    public void setLibro(String libro) {
        this.libro = libro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
