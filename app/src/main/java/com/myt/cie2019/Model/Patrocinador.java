package com.myt.cie2019.Model;

public class Patrocinador {
    String nombre, urlFoto, urlPagina;


    public Patrocinador(String nombre, String urlFoto, String urlPagina) {
        this.nombre = nombre;
        this.urlFoto = urlFoto;
        this.urlPagina = urlPagina;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getUrlPagina() {
        return urlPagina;
    }

    public void setUrlPagina(String urlPagina) {
        this.urlPagina = urlPagina;
    }
}
