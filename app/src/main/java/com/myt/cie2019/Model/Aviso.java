package com.myt.cie2019.Model;

public class Aviso {

    private String color, contenido, link, titulo;
    private int estado;

    public Aviso(String color, String contenido, String link, String titulo, int estado) {
        this.color = color;
        this.contenido = contenido;
        this.link = link;
        this.titulo = titulo;
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
