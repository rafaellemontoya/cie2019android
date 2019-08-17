package com.myt.cie2019.Model;

public class PonenciaMagistral {
    private String nombrePonencia, nombrePonente, foto, fecha;


    public PonenciaMagistral(String nombrePonencia, String nombrePonente, String foto, String fecha) {
        this.nombrePonencia = nombrePonencia;
        this.nombrePonente = nombrePonente;
        this.foto = foto;
        this.fecha = fecha;
    }

    public String getNombrePonencia() {
        return nombrePonencia;
    }

    public void setNombrePonencia(String nombrePonencia) {
        this.nombrePonencia = nombrePonencia;
    }

    public String getNombrePonente() {
        return nombrePonente;
    }

    public void setNombrePonente(String nombrePonente) {
        this.nombrePonente = nombrePonente;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
