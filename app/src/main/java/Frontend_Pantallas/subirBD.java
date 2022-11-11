package Frontend_Pantallas;

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
