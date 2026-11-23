package plantillasBasicas.CGR.model;

import java.time.LocalDate;

public class Pelicula {
    private Long identificador;
    private String titulo;
    private String genero;
    private Float puntuacion;
    private String imbd;
    private String imagen;
    private LocalDate fechaEstreno;

    public Pelicula(Long identificador, String titulo,String genero, Float puntuacion, String imbd, String imagen, LocalDate fechaEstreno) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.genero = genero;
        this.puntuacion = puntuacion;
        this.imbd = imbd;
        this.imagen = imagen;
        this.fechaEstreno = fechaEstreno;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public Float getPuntuacion() {
        return puntuacion;
    }

    public String getImbd() {
        return imbd;
    }

    public String getImagen() {
        return imagen;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public boolean isClasica() {
        return fechaEstreno != null && fechaEstreno.getYear() < 2000;
    }
}
