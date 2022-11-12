package Frontend_Pantallas;


//Clase que obtiene y manda el formato de la base de datos de FireBase
public class subirBD {
    String id;
    String titulo;
    String contenido;
    String imagen;

    public subirBD(String id, String titulo, String contenido, String imagen) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getImagen() {
        return imagen;
    }
}
